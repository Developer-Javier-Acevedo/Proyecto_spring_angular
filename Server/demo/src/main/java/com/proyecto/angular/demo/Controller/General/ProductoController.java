package com.proyecto.angular.demo.Controller.General;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.angular.demo.DTO.ProductoDTO;
import com.proyecto.angular.demo.Service.Productos.ProductoService;
import static java.util.Objects.isNull;

@RestController
@RequestMapping("/Productos")
public class ProductoController {


    @Autowired
    private ProductoService productoService;


    @GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Integer id) {

        try {
            ProductoDTO productoDTO =productoService.findById(id);

            if (isNull(productoDTO) ) {
				return ResponseEntity.noContent().build();
			}

            return ResponseEntity.ok(productoDTO);
        } catch (Exception e) {

            return ResponseEntity.internalServerError().build();

        }	
        
	}

    @GetMapping("/All")
    public ResponseEntity<?> traerTodos(){
        try {
            List<ProductoDTO> productoDTO = productoService.traerTodos();

            if (isNull(productoDTO) || productoDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
            
            return ResponseEntity.ok(productoDTO);
        } catch (Exception e) {

            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> CrearProducto(@RequestBody @Validated ProductoDTO producto, BindingResult result){
        try {
            
            ProductoDTO productoDTO = productoService.CrearProducto(producto);

            return ResponseEntity.ok(productoDTO);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping ("/borrarProducto/{id}")
    public ResponseEntity<?> borrar(@PathVariable Integer id ){

        try {
            
            productoService.Delete(id);

            return ResponseEntity.ok().build();

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }        
        
    }

    @GetMapping("/BuscarPorSerial")
    public ResponseEntity<?> TraerPorSerial (@RequestParam(value ="Serial",defaultValue = "" ) String Serial){
        try {
            
            List<ProductoDTO> productoDTO = productoService.findbySerial(ProductoDTO.builder().Serial(Serial).build());
            if (isNull(productoDTO) || productoDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
            return ResponseEntity.ok(productoDTO);

        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/serial-pagin")
	public ResponseEntity<?> findByLikeSerialPagin( @RequestParam(value = "page", defaultValue = "1") Integer page,
													@RequestParam(value = "size", defaultValue = "10") Integer size,
													@RequestParam(value = "nombre", defaultValue = "") String nombre) {
		try {
					
			Pageable pageable = PageRequest.of(page-1, size);
			
			List<ProductoDTO> productoDTO = productoService.findByLikeSerialPagin(pageable,nombre);
			if (isNull(productoDTO) || productoDTO.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(productoDTO);
		} catch (Exception e) {
			
			return ResponseEntity.internalServerError().build();
		}
	}
}
