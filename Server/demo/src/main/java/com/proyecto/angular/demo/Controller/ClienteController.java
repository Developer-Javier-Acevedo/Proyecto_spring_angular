package com.proyecto.angular.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.angular.demo.DTO.ClienteDTO;
import com.proyecto.angular.demo.Service.Clientes.ClienteService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    

    @Autowired
    private ClienteService clienteService;



 
    @GetMapping("/{id}")
	public ClienteDTO findById(@PathVariable Integer id) {

		        
        return clienteService.findById(id);
	}
/*
    @GetMapping
    public List<ClienteDTO> getClientes(){

        List<ClienteDTO> clienteDTO = clienteService.getClientes();
        ClienteDTO.builder().Nombre(Nombre).build()
        return ResponseEntity.ok(clienteDTO);

    } 

     */

    @PostMapping
    public ClienteDTO Crear(@RequestBody ClienteDTO clienteDTO ){
        return clienteService.crearCliente(clienteDTO);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id){
        clienteService.borrarCliente(id);
    }


    /*
    @PutMapping("/{id}")
    public ClienteEntity Editar(@PathVariable("Id")Integer id, @RequestBody ClienteEntity clienteEntity ){
        clienteEntity.setId(id);
        return clienteService.editarById(clienteEntity);
	
	} 
     */
}

