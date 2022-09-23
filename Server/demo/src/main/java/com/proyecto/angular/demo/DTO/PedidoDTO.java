package com.proyecto.angular.demo.DTO;

import java.sql.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Integer Id;
    private String Detalles;
    private Date FechaRegistro;
    private Double Total;
    private String Estado;
    private ClienteDTO cliente;
    private List<PedidoDetalleDTO> PedidoDetallado;
}
