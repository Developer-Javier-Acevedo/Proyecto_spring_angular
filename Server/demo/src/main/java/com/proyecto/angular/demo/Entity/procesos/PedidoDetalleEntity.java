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
import static java.util.Objects.isNull;

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

	@Column(name = "Cantidad")
	private Integer cantidad;

	@Column(name = "Precio")
	private Double precio;

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

	@Override
	public String toString() {
		return "PedidoDetalleEntity [Id=" + Id + ", cantidad=" + cantidad + ", precio=" + precio + ", subTotal="
				+ subTotal + ", estado=" + estado + ", producto=" + producto + "]";
	}

	public void calcularSubTotal() {

		if (isNull(cantidad)) {
			cantidad = 0;
		}
		if (isNull(precio)) {
			precio = 0.0;
		}
		setSubTotal(cantidad * precio);
	}

	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public PedidoEntity getPedido() {
		return this.pedido;
	}

	public void setPedido(PedidoEntity pedido) {
		this.pedido = pedido;
	}

	public ProductoEntity getProducto() {
		return this.producto;
	}

	public void setProducto(ProductoEntity producto) {
		this.producto = producto;
	}

}
