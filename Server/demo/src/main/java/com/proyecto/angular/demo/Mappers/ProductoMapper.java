package com.proyecto.angular.demo.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.proyecto.angular.demo.DTO.ProductoDTO;
import com.proyecto.angular.demo.Entity.General.ProductoEntity;

@Component
public class ProductoMapper {
    
    public ProductoDTO toDTO(ProductoEntity c) {
		ProductoDTO productoDTO = new ProductoDTO();
		BeanUtils.copyProperties(c,productoDTO );
		return productoDTO;
	}
	
	public ProductoEntity toEntity(ProductoDTO productoDTO) {
		ProductoEntity productoEntity= new ProductoEntity();
		BeanUtils.copyProperties(productoDTO,productoEntity);
		return productoEntity;
	}
}
