package com.proyecto.angular.demo.Service;

import java.util.List;

import com.proyecto.angular.demo.DTO.ClienteDTO;


public interface ClienteService  {
 
    ClienteDTO findById(Integer id);

    List<ClienteDTO> getClientes();

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    void borrarCliente(Integer id);

  

  
}
