package com.proyecto.angular.demo.DTO;

import com.proyecto.angular.demo.Entity.General.ClienteEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    
    
    private Integer Id ;     

    private String Detalle ;  

    /*private Date FechaRegistro;*/

    private Double Total;  

    private Integer Estado ;  
    
	private ClienteEntity cliente;

}
