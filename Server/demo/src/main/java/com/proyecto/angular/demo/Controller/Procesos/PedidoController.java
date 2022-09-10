package com.proyecto.angular.demo.Controller.Procesos;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.angular.demo.DTO.PedidoDTO;

import com.proyecto.angular.demo.Service.Clientes.Exceptions.ServiceException;
import com.proyecto.angular.demo.Service.Procesos.Pedidoservice;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private Pedidoservice pedidoService ; 
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findbyId(@PathVariable Integer id )throws ServiceException  {
        try {
            
            PedidoDTO pedidoDTO = pedidoService.findById(id);
            return ResponseEntity.ok(pedidoDTO);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        
    }


}
