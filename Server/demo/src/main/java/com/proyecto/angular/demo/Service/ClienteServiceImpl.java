package com.proyecto.angular.demo.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.angular.demo.DTO.ClienteDTO;
import com.proyecto.angular.demo.Entity.ClienteEntity;
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
	
    /*
    @Override
    public List<ClienteDTO> getClientes(){
       List<ClienteEntity> ListaClienteEntity = clienteRepository.findAll();
        return ListaClienteEntity.stream().map(clienteMapper.toDTO(ListaClienteEntity)).toList();

    } */
 
    @Override
    public ClienteDTO crearCliente(ClienteDTO clienteDTO){
       return clienteMapper.toDTO(clienteRepository.save(clienteMapper.toEntity(clienteDTO)));
    }

    @Override
    public void borrarCliente(Integer id ){
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteDTO> getClientes() {
        // TODO Auto-generated method stub
        return null;
    }

/* 
    @Override
    public List<ClienteDTO> findLikeNombre(ClienteDTO clienteDTO){
        List<ClienteEntity> listaClienteEntity = clienteRepository.findLikeNombre("%"+clienteDTO.getNombre()+"%");
        return listaClienteEntity.stream().map(c-> clienteMapper.toDTO(c)).toList();
    }
*/

    

    
}
