package com.proyecto.angular.demo.Service;

import java.util.List;

import com.proyecto.angular.demo.Entity.ClienteEntity;

public interface ClienteService  {
 
    ClienteEntity findById(Integer id);

    List<ClienteEntity> getClientes();

    ClienteEntity crearCliente(ClienteEntity clienteEntity);

    void borrarCliente(Integer id);

    List<ClienteEntity> findLikeNombre(String Nombre);

    /*
    
    ClienteEntity editarById(ClienteEntity clienteEntity);
    
    */
}
