package com.proyecto.angular.demo.Service.Clientes;

import java.util.List;

import com.proyecto.angular.demo.DTO.ClienteDTO;
import com.proyecto.angular.demo.Entity.General.ClienteEntity;


public interface ClienteService  {
 
    ClienteDTO findById(Integer id);

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    // No se han implementeado Los DTO 

    List<ClienteDTO> findLikeNombre(String Nombre);

    
    // No se han implementeado Los DTO 
    List<ClienteDTO> traerTodos();

  
}
