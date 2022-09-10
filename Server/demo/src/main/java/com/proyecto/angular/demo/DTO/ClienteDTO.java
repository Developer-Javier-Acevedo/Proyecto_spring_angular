package com.proyecto.angular.demo.DTO;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    
    private Integer Id ;
    @NotBlank(message = "La Identificacion debe es requerida")
	@Size(min = 8, max = 11, message = "La Identificacion debe tener como mínimo {min} y máximo {max} caracteres")
    private String  Id_Identificacion;
    private String Nombre;
    private String Email ;
    private String Telefono;
    private Integer Estado;
    
}
