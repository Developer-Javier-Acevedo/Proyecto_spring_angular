package com.proyecto.angular.demo.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDetalleDTO {

    private Integer Id;
    private Integer Cantidad;
    private String FechaRegistro;
    private Double Precio;
    private Double Subtotal;
    private ProductoDTO Productos;
    @JsonIgnore
    private PedidoDTO Pedido;
    private String detalle;

}
