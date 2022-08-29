package com.proyecto.angular.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.angular.demo.Entity.ClienteEntity;
import com.proyecto.angular.demo.Repositoryes.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    
    @Override
	public ClienteEntity findById(Integer id) {
		return clienteRepository.findById(id).orElse(null);
	}
	
    @Override
    public List<ClienteEntity> getClientes(){
        return clienteRepository.findAll();
    }

    @Override
    public ClienteEntity crearCliente(ClienteEntity clienteEntity){
       return clienteRepository.save(clienteEntity);
    }

    @Override
    public void borrarCliente(Integer id ){
        clienteRepository.deleteById(id);
    }

    @Override
    public List<ClienteEntity> findLikeNombre(String Nombre){
        return clienteRepository.findLikeNombre("%"+Nombre+"%");
    }
    



    /* 
    @Override
    public ClienteEntity editarById(ClienteEntity clienteEntity){
        
        Optional<ClienteEntity> optCliente = clienteRepository.findById(clienteEntity.getId());

		if (optCliente.isPresent()) {
			ClienteEntity retCliente = optCliente.get();
			BeanUtils.copyProperties(clienteEntity, retCliente);
			return clienteRepository.save(retCliente);
		}

		return null;
    }*/
    
}
