package com.proyecto.angular.demo.Service.Procesos.Service;

import com.proyecto.angular.demo.DTO.PedidoDTO;
import com.proyecto.angular.demo.Service.Exceptions.ServiceException;

public interface Pedidoservice {

    PedidoDTO findById(Integer id) throws ServiceException;
}
