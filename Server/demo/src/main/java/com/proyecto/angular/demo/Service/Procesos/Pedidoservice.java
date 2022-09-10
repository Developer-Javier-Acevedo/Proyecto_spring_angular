package com.proyecto.angular.demo.Service.Procesos;

import com.proyecto.angular.demo.DTO.PedidoDTO;
import com.proyecto.angular.demo.Service.Clientes.Exceptions.ServiceException;

public interface Pedidoservice {

    PedidoDTO findById(Integer id) throws ServiceException;
}
