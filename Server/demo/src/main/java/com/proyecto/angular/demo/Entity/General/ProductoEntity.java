package com.proyecto.angular.demo.Entity.General;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity (name = "Producto")
@Table(name = "tb_producto")
public class ProductoEntity {

    @Id
    @Column (name = "Id_producto")   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column (name = "Serial")
    private String Serial;

    @Column (name = "Nombre")
    private String Nombre;
    @Column (name = "Precio")
    private Double Precio ; 
    @Column (name = "Stock")
    private Integer Stock;
    @Column (name = "Estado")
    private String Estado;
  
    
}
