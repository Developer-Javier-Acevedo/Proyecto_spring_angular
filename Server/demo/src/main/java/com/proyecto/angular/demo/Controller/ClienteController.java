package com.proyecto.angular.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.angular.demo.DTO.ClienteDTO;
import com.proyecto.angular.demo.Entity.General.ClienteEntity;
import com.proyecto.angular.demo.Service.Clientes.ClienteService;




@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    

    @Autowired
    private ClienteService clienteService;



 
    @GetMapping("/{id}")
	public ClienteDTO findById(@PathVariable Integer id) {

		        
        return clienteService.findById(id);
	}

    @PostMapping
    public ClienteDTO Crear(@RequestBody ClienteDTO clienteDTO ){
        return clienteService.crearCliente(clienteDTO);
    }

    // No se han implementeado Los DTO 
    @GetMapping("/Clientes")
    public List<ClienteDTO> traerTodos(){
        return clienteService.traerTodos();
    }

 // No se han implementeado Los DTO 
    @GetMapping("/buscar-nombre")
    public  List<ClienteDTO> findLikeNombre(@RequestParam(value = "nombre",defaultValue = "" ) String Nombre){
	return clienteService.findLikeNombre(Nombre);
    }

}

