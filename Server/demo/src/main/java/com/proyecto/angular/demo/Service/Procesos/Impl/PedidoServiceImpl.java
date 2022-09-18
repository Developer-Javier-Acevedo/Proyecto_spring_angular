package com.proyecto.angular.demo.Service.Procesos.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.angular.demo.DTO.PedidoDTO;
import com.proyecto.angular.demo.Entity.procesos.PedidoEntity;
import com.proyecto.angular.demo.Mappers.PedidoMapper;
import com.proyecto.angular.demo.Repositoryes.Procesos.PedidoRepository;
import com.proyecto.angular.demo.Service.Exceptions.ServiceException;
import com.proyecto.angular.demo.Service.Procesos.Service.Pedidoservice;

@Service
public class PedidoServiceImpl implements Pedidoservice {

    @Autowired
    public PedidoRepository pedidoRepository;
    @Autowired
    public PedidoMapper pedidoMapper;



    @Override
    public PedidoDTO findById(Integer id) throws ServiceException {

    try {
        
        PedidoEntity pedidoEntity = pedidoRepository.findById(id).orElse(null);

        return pedidoMapper.toDTO(pedidoEntity);
    } catch (Exception e) {
        throw new ServiceException(e);
    }

     


    }

  
    
}
