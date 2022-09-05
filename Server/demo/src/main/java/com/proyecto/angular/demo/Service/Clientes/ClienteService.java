package com.proyecto.angular.demo.Service.Clientes;

import java.util.List;

import com.proyecto.angular.demo.DTO.ClienteDTO;


public interface ClienteService  {
 
    ClienteDTO findById(Integer id);

    List<ClienteDTO> getClientes();

    ClienteDTO crearCliente(ClienteDTO clienteDTO);

    void borrarCliente(Integer id);

    List<ClienteDTO> findLikeNombre(String Nombre);

  
}
