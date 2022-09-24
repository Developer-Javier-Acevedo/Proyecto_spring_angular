package com.proyecto.angular.demo.Controller.Procesos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static java.util.Objects.isNull;
import com.proyecto.angular.demo.DTO.PedidoDTO;
import com.proyecto.angular.demo.Service.Exceptions.ServiceException;
import com.proyecto.angular.demo.Service.Procesos.Service.Pedidoservice;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private Pedidoservice pedidoService;

	@GetMapping("/{id}")
	public ResponseEntity<?> findbyId(@PathVariable Integer id) throws ServiceException {
		try {

			PedidoDTO pedidoDTO = pedidoService.findById(id);
			return ResponseEntity.ok(pedidoDTO);

		} catch (Exception e) {
			return ResponseEntity.internalServerError().build();
		}

	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Validated PedidoDTO pedido, BindingResult result) {
		try {

			PedidoDTO pedidoDTO = pedidoService.save(pedido);
			if (!isNull(pedidoDTO)) {
				return ResponseEntity.status(HttpStatus.CREATED).body(pedidoDTO);
			}
			return ResponseEntity.badRequest().build();

		} catch (Exception e) {

			return ResponseEntity.internalServerError().build();
		}
	}

}
