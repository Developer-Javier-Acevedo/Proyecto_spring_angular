package com.proyecto.angular.demo.Service.Clientes.General;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.angular.demo.DTO.ClienteDTO;
import com.proyecto.angular.demo.Entity.General.ClienteEntity;
import com.proyecto.angular.demo.Mappers.ClienteMapper;
import com.proyecto.angular.demo.Repositoryes.ClienteRepository;
import com.proyecto.angular.demo.Service.Clientes.Exceptions.ServiceException;

@Service
public class ClienteServiceImpl implements ClienteService {

    // esto es nuevo 
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    
    @Override
	public ClienteDTO findById(Integer id) throws ServiceException {
        try {
            ClienteEntity clienteEntity = clienteRepository.findById(id).orElse(null);
		return clienteMapper.toDTO(clienteEntity);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
        
	}
	
    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO)  throws ServiceException {
        try {
            
       return clienteMapper.toDTO(clienteRepository.save(clienteMapper.toEntity(clienteDTO)));
        } catch (Exception e) {
            throw new ServiceException(e);
        }

    }

    @Override
    public List<ClienteDTO>  findLikeObject(ClienteDTO clienteDTO) throws ServiceException
    {
        try {
            List<ClienteEntity> listaClienteEntity = clienteRepository.findLikeNombre("%" + clienteDTO.getNombre() + "%");
         
        
        return listaClienteEntity.stream().map(c -> clienteMapper.toDTO(c)).collect(Collectors.toList()); 
            
        } catch (Exception e) {

            throw new ServiceException(e);

        }
        
    }   

    @Override
    public List<ClienteDTO> traerTodos() throws ServiceException{
        try {
            
            List<ClienteEntity> listaClienteEntity = clienteRepository.findAll();

            return listaClienteEntity.stream().map(c -> clienteMapper.toDTO(c)).collect(Collectors.toList());   

        } catch (Exception e) {
            throw new ServiceException(e);
        }

       
                                
    }

  

    
        
}
