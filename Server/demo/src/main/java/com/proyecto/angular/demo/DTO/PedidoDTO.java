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
    private String detalles;
    private Date fechaRegistro;
    private Double total;
    private String estado;
    private ClienteDTO cliente;
    private List<PedidoDetalleDTO> PedidoDetallado;

}
