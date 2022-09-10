package com.proyecto.angular.demo.Service.Clientes.Base;

import java.util.List;


import com.proyecto.angular.demo.Service.Clientes.Exceptions.ServiceException;


public interface GenericService<T>  {
 
    T findById(Integer id) throws ServiceException ;

    T crearCliente(T t)throws ServiceException;

    List<T> findLikeObject(T t)throws ServiceException;  
   
    List<T> traerTodos()throws ServiceException;

    void BorrarCliente(Integer id ) throws ServiceException;

    List<T> findbyIdentificacion(T t) throws ServiceException;
}