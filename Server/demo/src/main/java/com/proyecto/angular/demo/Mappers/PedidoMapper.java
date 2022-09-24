package com.proyecto.angular.demo.Mappers;

import java.util.ArrayList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.angular.demo.DTO.PedidoDTO;
import com.proyecto.angular.demo.DTO.PedidoDetalleDTO;
import com.proyecto.angular.demo.Entity.procesos.PedidoEntity;

@Component
public class PedidoMapper {

	@Autowired
	private PedidoDetalleMapper pedidoDetalleMapper;

	@Autowired
	private ProductoMapper productoMapper;

	@Autowired
	private ClienteMapper clienteMapper;

	public PedidoDTO toDTO(PedidoEntity pedidoEntity) {

		PedidoDTO pedidoDTO = new PedidoDTO();

		// datos del cliente
		pedidoDTO.setCliente(clienteMapper.toDTO(pedidoEntity.getCliente()));

		// datos del detalle del pedido
		pedidoDTO.setPedidoDetallado(new ArrayList<>());

		pedidoEntity.getPedidoDetallado().forEach(pd -> {
			PedidoDetalleDTO pedidoDetalleDTO = pedidoDetalleMapper.toDTO(pd);

			pedidoDetalleDTO.setProductos(productoMapper.toDTO(pd.getProducto()));

			pedidoDTO.getPedidoDetallado().add(pedidoDetalleDTO);

		}

		);
		BeanUtils.copyProperties(pedidoEntity, pedidoDTO);
		return pedidoDTO;
	}

	public PedidoEntity toEntity(PedidoDTO pedidoDTO) {
		PedidoEntity pedidoEntity = new PedidoEntity();
		BeanUtils.copyProperties(pedidoDTO, pedidoEntity);
		pedidoEntity.setCliente(clienteMapper.toEntity(pedidoDTO.getCliente()));
		return pedidoEntity;
	}
}
