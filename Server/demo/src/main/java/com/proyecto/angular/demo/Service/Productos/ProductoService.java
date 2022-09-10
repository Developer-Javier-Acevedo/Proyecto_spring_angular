package com.proyecto.angular.demo.Service.Productos;

import java.util.List;

import com.proyecto.angular.demo.DTO.ProductoDTO;
import com.proyecto.angular.demo.Service.Clientes.Exceptions.ServiceException;

public interface ProductoService  {

    ProductoDTO findById(Integer id) throws ServiceException;

    ProductoDTO CrearProducto(ProductoDTO producto) throws ServiceException;

    void Delete( Integer id ) throws ServiceException;

    List<ProductoDTO> traerTodos() throws ServiceException;

    List<ProductoDTO> findbySerial( ProductoDTO productoDTO ) throws ServiceException;
}
