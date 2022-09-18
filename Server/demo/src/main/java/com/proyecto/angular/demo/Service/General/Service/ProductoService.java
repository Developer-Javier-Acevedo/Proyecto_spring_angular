package com.proyecto.angular.demo.Service.General.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.proyecto.angular.demo.DTO.ProductoDTO;
import com.proyecto.angular.demo.Service.Exceptions.ServiceException;

public interface ProductoService  {

    ProductoDTO findById(Integer id) throws ServiceException;

    ProductoDTO CrearProducto(ProductoDTO producto) throws ServiceException;

    void Delete( Integer id ) throws ServiceException;

    List<ProductoDTO> traerTodos() throws ServiceException;

    List<ProductoDTO> findbySerial( ProductoDTO productoDTO ) throws ServiceException;

    List<ProductoDTO> findByLikeSerialPagin(Pageable pageable, String nombre)throws ServiceException;
}
