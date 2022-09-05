package com.proyecto.angular.demo.Service.Clientes;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.angular.demo.DTO.ClienteDTO;
import com.proyecto.angular.demo.Entity.General.ClienteEntity;
import com.proyecto.angular.demo.Mappers.ClienteMapper;
import com.proyecto.angular.demo.Repositoryes.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    
    @Override
	public ClienteDTO findById(Integer id) {
        ClienteEntity clienteEntity = clienteRepository.findById(id).orElse(null);
		return clienteMapper.toDTO(clienteEntity);
	}
	
    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO){

       return clienteMapper.toDTO(clienteRepository.save(clienteMapper.toEntity(clienteDTO)));
    }

    @Override
    public List<ClienteDTO>  findLikeNombre(String Nombre)
    {
        List<ClienteEntity> listaClienteEntity = clienteRepository.findLikeNombre("%" + Nombre + "%");
         
        
        return listaClienteEntity.stream().map(c -> clienteMapper.toDTO(c)).collect(Collectors.toList()); 
    }   

    @Override
    public List<ClienteDTO> traerTodos(){

        List<ClienteEntity> listaClienteEntity = clienteRepository.findAll();

        return listaClienteEntity.stream().map(c -> clienteMapper.toDTO(c)).collect(Collectors.toList());   
                                
    }
        
}
