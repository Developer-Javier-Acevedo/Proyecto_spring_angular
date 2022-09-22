package com.proyecto.angular.demo.Service.Procesos.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.angular.demo.DTO.PedidoDTO;
import com.proyecto.angular.demo.Entity.General.ProductoEntity;
import com.proyecto.angular.demo.Entity.procesos.PedidoDetalleEntity;
import com.proyecto.angular.demo.Entity.procesos.PedidoEntity;
import com.proyecto.angular.demo.Mappers.PedidoDetalleMapper;
import com.proyecto.angular.demo.Mappers.PedidoMapper;
import com.proyecto.angular.demo.Mappers.ProductoMapper;
import com.proyecto.angular.demo.Repositoryes.General.ProductoRepository;
import com.proyecto.angular.demo.Repositoryes.Procesos.PedidoDetalleRepository;
import com.proyecto.angular.demo.Repositoryes.Procesos.PedidoRepository;
import com.proyecto.angular.demo.Service.Exceptions.ServiceException;
import com.proyecto.angular.demo.Service.Procesos.Service.Pedidoservice;

@Service
public class PedidoServiceImpl implements Pedidoservice {

    @Autowired
    public PedidoRepository pedidoRepository;
    @Autowired
    public PedidoMapper pedidoMapper;

    @Autowired
    public PedidoDetalleMapper pedidoDetalleMapper;

    @Autowired
    public ProductoMapper productoMapper;

    @Autowired
    public PedidoDetalleRepository pedidoDetalleRepository;

    @Autowired
    public ProductoRepository productoRepository;

    @Override
    public PedidoDTO findById(Integer id) throws ServiceException {

        try {
            PedidoEntity pedidoEntity = pedidoRepository.findById(id).orElse(null);
            return pedidoMapper.toDTO(pedidoEntity);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Transactional
    @Override
    public PedidoDTO save(PedidoDTO pedidoDTO) throws ServiceException {
        try {
            PedidoEntity pedidoEntity = pedidoMapper.toEntity(pedidoDTO);
            List<PedidoDetalleEntity> listPedidoDetalleEntity = new ArrayList<>();

            // Detalle Pedido
            pedidoDTO.getDetalle().forEach(dp -> {

                // Buscando el producto

                PedidoDetalleEntity pedidoDetalleEntity = pedidoDetalleMapper.toEntity(dp);

                Optional<ProductoEntity> optProductoEntity = productoRepository.findById(dp.getProductos().getId());

                if (optProductoEntity.isPresent()) {

                    ProductoEntity producto = optProductoEntity.get();

                    pedidoDetalleEntity.setProducto(productoMapper.toEntity(dp.getProductos()));

                    pedidoDetalleEntity.setPrecio(producto.getPrecio());
                    pedidoDetalleEntity.calcularSubTotal();
                    pedidoDetalleEntity.setPedido(pedidoEntity);
                    pedidoDetalleEntity.setEstado("1");
                    listPedidoDetalleEntity.add(pedidoDetalleEntity);
                    // Actualizar la tabla producto

                    productoRepository.updataStock(producto.getId(), dp.getCantidad());
                }

            });

            pedidoEntity.setDetalle(listPedidoDetalleEntity);

            pedidoEntity.calcularSubTotal();

            pedidoEntity.setEstado("1");

            pedidoRepository.saveAndFlush(pedidoEntity);

            pedidoDetalleRepository.refresh(pedidoEntity);

            return pedidoMapper.toDTO(pedidoEntity);

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

}
