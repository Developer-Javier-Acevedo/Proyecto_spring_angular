package com.proyecto.angular.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Integer Id;
    private String Id_Identificacion;
    private String Nombre;
    private String Email;
    private String Telefono;
    private Integer Estado;

}
