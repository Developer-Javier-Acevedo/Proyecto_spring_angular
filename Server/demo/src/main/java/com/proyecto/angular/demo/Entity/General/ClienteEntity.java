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
@Entity (name = "Cliente")
@Table(name = "tb_cliente")


public class ClienteEntity {

    @Id
    @Column (name = "Id_Cliente")   
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id ; 
    @Column (name = "Id_Identificacion")
    private String  Id_Identificacion;
    @Column (name = "Nombre")
    private String Nombre;
    @Column (name = "email")
    private String Email ;
    @Column (name ="Telefono")
    private String Telefono;
    @Column (name = "Estado")
    private Integer Estado;
    
}
