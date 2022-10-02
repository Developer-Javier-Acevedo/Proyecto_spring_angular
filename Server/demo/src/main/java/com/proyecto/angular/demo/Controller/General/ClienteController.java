package com.proyecto.angular.demo.Controller.General;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.angular.demo.Controller.base.GenericController;
import com.proyecto.angular.demo.DTO.ClienteDTO;
import com.proyecto.angular.demo.Service.General.Service.ClienteService;

import static java.util.Objects.isNull;

import java.util.List;

@RestController
@RequestMapping("/V1/Cliente")
public class ClienteController extends GenericController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id) {

        try {
            if (id <= 0) {
                return ResponseEntity.badRequest().body(String.format("El id %d no es válido", id));
            }
            ClienteDTO clienteDTO = clienteService.findById(id);

            if (!isNull(clienteDTO)) {
                return ResponseEntity.ok(clienteDTO);
            }
            return ResponseEntity.noContent().build();
        } catch (Exception e) {

            return ResponseEntity.internalServerError().build();

        }

    }

    @PostMapping
    public ResponseEntity<?> Crear(@RequestBody @Validated ClienteDTO cliente, BindingResult result) {
        try {

            if (result.hasErrors()) {
                return ResponseEntity.badRequest().body(result.getAllErrors());
            }

            ClienteDTO clienteDTO = clienteService.crearCliente(cliente);

            if (!isNull(clienteDTO)) {
                return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

    @GetMapping("/Clientes")
    public ResponseEntity<?> traerTodos() {
        try {

            List<ClienteDTO> clientes = clienteService.traerTodos();
            if (isNull(clientes) || clientes.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/buscar-nombre")
    public ResponseEntity<?> findLikeNombre(@RequestParam(value = "nombre", defaultValue = "") String Nombre) {
        try {
            List<ClienteDTO> cliente = clienteService.findLikeObject(ClienteDTO.builder().Nombre(Nombre).build());
            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> BorrarCliente(@PathVariable Integer id) {
        try {
            clienteService.BorrarCliente(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/ClienteID")
    public ResponseEntity<?> encontrarIdentificacion(
            @RequestParam(value = "identificacion", defaultValue = "") String Identificacion) {

        try {
            List<ClienteDTO> cliente = clienteService
                    .findbyIdentificacion(ClienteDTO.builder().Id_Identificacion(Identificacion).build());

            return ResponseEntity.ok(cliente);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
