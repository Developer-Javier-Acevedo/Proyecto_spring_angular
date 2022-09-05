package com.proyecto.angular.demo.DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ProductoDTO {
    private Integer Id;
    private String Nombre;
    private Double Precio ; 
    private Double Telefono;
    private String Estado;
}
