package com.proyecto.angular.demo.Entity.procesos;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import com.proyecto.angular.demo.Entity.General.ClienteEntity;
import static java.util.Objects.isNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PedidoEntity")
@Table(name = "tb_pedido")

public class PedidoEntity {

    @Id
    @Column(name = "Id_Pedido")
    private Integer Id;

    @ManyToOne
    @JoinColumn(name = "Id_Cliente", nullable = false)
    private ClienteEntity cliente;

    @Column(name = "Detalle")
    private String detalles;

    @Column(name = "Fecha_Registro")
    private Date fechaRegistro;

    @Column(name = "Total")
    private Double total;

    @Column(name = "Estado")
    private String estado;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoDetalleEntity> PedidoDetallado;

    @Override
    public String toString() {
        return "PedidoEntity [id=" + Id + ", Detalles=" + detalles + ", FechaRegistro=" + fechaRegistro + ", Total="
                + total + ", Estado=" + estado + ", cliente=" + cliente + ", PedidoDetallado=" + PedidoDetallado + "]";
    }

    public void calcularSubTotal() {

        Double tmpTotal = 0.0;

        for (PedidoDetalleEntity pedidoDetalle : PedidoDetallado) {
            if (isNull(PedidoDetallado) || detalles.isEmpty() || isNull(pedidoDetalle)) {
                setTotal(0.0);
            }

            tmpTotal += pedidoDetalle.getSubTotal();
        }
        setTotal(tmpTotal);
    }

    @PrePersist
    private void persistFechaRegistro() {
        fechaRegistro = new Date();
    }

    @PreUpdate
    private void updateFechaRegistro() {
        fechaRegistro = new Date();
    }

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public void getDetalles(String detalles) {
        this.detalles = detalles;
    }

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Double gettotal() {
        return this.total;
    }

    public void setTotal(Double Total) {
        this.total = Total;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ClienteEntity getCliente() {
        return this.cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public void setPedidoDetallado(List<PedidoDetalleEntity> PedidoDetallado) {
        this.PedidoDetallado = PedidoDetallado;
    }

    public List<PedidoDetalleEntity> getPedidoDetallado() {
        return PedidoDetallado;
    }

}
