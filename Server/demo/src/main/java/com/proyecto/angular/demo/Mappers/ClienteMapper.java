package com.proyecto.angular.demo.Mappers;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.proyecto.angular.demo.DTO.ClienteDTO;
import com.proyecto.angular.demo.Entity.General.ClienteEntity;

@Component
public class ClienteMapper {

	public ClienteDTO toDTO(ClienteEntity clienteEntity) {
		ClienteDTO clienteDTO = new ClienteDTO();
		BeanUtils.copyProperties(clienteEntity, clienteDTO);
		return clienteDTO;
	}

	public ClienteEntity toEntity(ClienteDTO clienteDTO) {
		ClienteEntity clienteEntity = new ClienteEntity();
		BeanUtils.copyProperties(clienteDTO, clienteEntity);
		return clienteEntity;
	}

}
