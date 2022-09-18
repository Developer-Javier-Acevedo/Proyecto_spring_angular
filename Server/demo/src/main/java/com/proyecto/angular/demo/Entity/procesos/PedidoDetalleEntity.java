package com.proyecto.angular.demo.Entity.procesos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.proyecto.angular.demo.Entity.General.ProductoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "DetallePedidoEntity")
@Table(name = "tb_detallepedido")


public class PedidoDetalleEntity {
    

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Id_pedido_detalle")
	private Integer Id;

	//@Positive(message = "La cantidad debe ser mayo que cero")
	@Column(name = "Cantidad")
	private Integer cantidad;

	//@Positive(message = "El precio debe ser mayo que cero")
	@Column(name = "Precio")
	private Double precio;

	//@Positive(message = "El sub total debe ser mayo que cero")
	@Column(name = "Subtotal")
	private Double subTotal;

	@Column(name = "Estado")
	@Builder.Default
	private String estado = "1";

	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name = "Id_Pedido", nullable = false)
	private PedidoEntity pedido;

	@ManyToOne
	@JoinColumn(name = "Id_Producto", nullable = false)
	private ProductoEntity producto;
}
