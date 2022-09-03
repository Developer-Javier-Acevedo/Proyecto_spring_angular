package com.proyecto.angular.demo.Service.Productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.angular.demo.DTO.ProductoDTO;
import com.proyecto.angular.demo.Entity.General.ProductoEntity;
import com.proyecto.angular.demo.Mappers.ProductoMapper;
import com.proyecto.angular.demo.Repositoryes.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {


    @Autowired
    private ProductoMapper productoMapper;

    @Autowired
    private ProductoRepository productoRepository;


    
    @Override
	public ProductoDTO findById(Integer Id) {
        ProductoEntity productoEntity = productoRepository.findById(Id).orElse(null);
		return productoMapper.toDTO(productoEntity);
	}
    
}
