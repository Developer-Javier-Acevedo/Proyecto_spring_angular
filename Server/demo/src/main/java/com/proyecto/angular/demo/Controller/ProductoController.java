package com.proyecto.angular.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.angular.demo.DTO.ProductoDTO;
import com.proyecto.angular.demo.Service.Productos.ProductoService;

@RestController
@RequestMapping("/Productos")
public class ProductoController {


    @Autowired
    private ProductoService productoService;


    @GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {

		ProductoDTO productoDTO =productoService.findById(id);
        
        return ResponseEntity.ok(productoDTO);
	}
    
}
