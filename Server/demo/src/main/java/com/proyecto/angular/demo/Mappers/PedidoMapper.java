package com.proyecto.angular.demo.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.proyecto.angular.demo.DTO.PedidoDTO;
import com.proyecto.angular.demo.Entity.procesos.PedidoEntity;

@Component
public class PedidoMapper {
    
    public PedidoDTO toDTO(PedidoEntity pedidoEntity) {
		PedidoDTO pedidoDTO = new PedidoDTO();
		BeanUtils.copyProperties(pedidoEntity,pedidoDTO );
		return pedidoDTO;
	}
	
	public PedidoEntity toEntity(PedidoDTO pedidoDTO) {
		PedidoEntity productoEntity= new PedidoEntity();
		BeanUtils.copyProperties(pedidoDTO,productoEntity);
		return productoEntity;
	}
}
