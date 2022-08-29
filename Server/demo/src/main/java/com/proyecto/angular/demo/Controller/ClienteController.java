package com.proyecto.angular.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.angular.demo.Entity.ClienteEntity;
import com.proyecto.angular.demo.Service.ClienteService;



@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    

    @Autowired
    private ClienteService clienteService;


    @GetMapping("/{id}")
	public ClienteEntity findById(@PathVariable Integer id) {
		return clienteService.findById(id);
		
	}

    @GetMapping
    public List<ClienteEntity> getClientes(){

        return clienteService.getClientes();

    } 

    @PostMapping
    public ClienteEntity Crear(@RequestBody ClienteEntity clienteEntity ){
        return clienteService.crearCliente(clienteEntity);
    }

    @DeleteMapping("/{id}")
    public void borrar(@PathVariable Integer id){
        clienteService.borrarCliente(id);
    }

    @GetMapping("/buscar-nombre")
    public List<ClienteEntity> findLikeNombre(@RequestParam(value = "nombre",defaultValue = "" ) String Nombre){
        return clienteService.findLikeNombre(Nombre);
    }

    /*
    @PutMapping("/{id}")
    public ClienteEntity Editar(@PathVariable("Id")Integer id, @RequestBody ClienteEntity clienteEntity ){
        clienteEntity.setId(id);
        return clienteService.editarById(clienteEntity);
	
	} 
     */
}

