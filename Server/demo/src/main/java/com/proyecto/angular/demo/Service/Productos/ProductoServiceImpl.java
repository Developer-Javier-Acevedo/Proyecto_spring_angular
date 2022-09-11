package com.proyecto.angular.demo.Service.Productos;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proyecto.angular.demo.DTO.ProductoDTO;

import com.proyecto.angular.demo.Entity.General.ProductoEntity;
import com.proyecto.angular.demo.Mappers.ProductoMapper;
import com.proyecto.angular.demo.Repositoryes.General.ProductoRepository;
import com.proyecto.angular.demo.Service.Clientes.Exceptions.ServiceException;

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



    @Override
    public ProductoDTO CrearProducto(ProductoDTO productoDTO) throws ServiceException {
        try {
            return productoMapper.toDTO(productoRepository.save(productoMapper.toEntity(productoDTO)));

        } catch (Exception e) {
            throw new ServiceException(e);
        }
       
    }

    @Override
    public void Delete(Integer id) throws ServiceException{
        try {
            
            productoRepository.deleteById(id);

        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<ProductoDTO> traerTodos()throws ServiceException{
        try {
            List<ProductoEntity> listaProductoEntity = productoRepository.findAll();

            return listaProductoEntity.stream().map(c -> productoMapper.toDTO(c)).collect(Collectors.toList());   
        } catch (Exception e) {

            throw new ServiceException(e);
        }
    }



    @Override
    public List<ProductoDTO> findbySerial(ProductoDTO productoDTO) throws ServiceException {
        try {
            
            List<ProductoEntity> listaproductos = productoRepository.findLikeSerial("%"+productoDTO.getSerial()+"%");

            return listaproductos.stream().map(c -> productoMapper.toDTO(c)).collect(Collectors.toList());   


        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }



    @Override
    public List<ProductoDTO> findByLikeSerialPagin(Pageable pageable, String nombre) throws ServiceException {
        
        Page<ProductoEntity> lstProductoEntities = productoRepository.findByLikeSerialPagin(pageable, "%" + nombre + "%");
		
		List<ProductoDTO> lstProductoDTOs= lstProductoEntities.getContent().stream().map(c -> productoMapper.toDTO(c)).collect(Collectors.toList());
		
		return lstProductoDTOs;
	}


    
    
}
