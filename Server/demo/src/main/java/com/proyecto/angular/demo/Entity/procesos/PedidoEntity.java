package com.proyecto.angular.demo.Entity.procesos;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.proyecto.angular.demo.Entity.General.ClienteEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PedidoEntity")
@Table(name = "tb_pedido")

public class PedidoEntity {

    @Id
    @Column(name = "Id_pedido")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer Id ;  

    @Column(name = "Detalle")
    private String Detalle ;
   
    @Column(name = "Fecha_Registro")    
    private Date FechaRegistro; 

    @Column(name = "Total")
    private Double Total;

    @Column(name = "Estado")
    private Integer Estado ;
    
    @NotNull(message = "El cliente es requerido")
	@ManyToOne
	@JoinColumn(name = "Id_Cliente", nullable = false)
	private ClienteEntity cliente;


    @PrePersist
	private void persistFechaRegistro() {
		FechaRegistro = new Date();
	}

	@PreUpdate
	private void updateFechaRegistro() {
		FechaRegistro = new Date();
	}

}
