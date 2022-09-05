package com.proyecto.angular.demo.Service.Clientes;

import java.util.List;

import com.proyecto.angular.demo.DTO.ClienteDTO;


public interface ClienteService  {
 
    ClienteDTO findById(Integer id);

    ClienteDTO crearCliente(ClienteDTO clienteDTO);


    List<ClienteDTO> findLikeNombre(String Nombre);

    
   
    List<ClienteDTO> traerTodos();

  
}
