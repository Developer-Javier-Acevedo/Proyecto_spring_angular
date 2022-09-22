package com.proyecto.angular.demo.Entity.procesos;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Pedido")
    private Integer Id;

    @Column(name = "Detalle")
    private String Detalles;

    @Column(name = "Fecha_Registro")
    private Date FechaRegistro;

    @Column(name = "Total")
    private Double Total;

    @Column(name = "Estado")
    private String Estado;

    @ManyToOne
    @Column(name = "Id_Cliente")
    private ClienteEntity cliente;

    @OneToMany
    @Column(name = "pedido")
    private List<PedidoDetalleEntity> detalle;

    public void calcularSubTotal() {

        Double tmpTotal = 0.0;

        for (PedidoDetalleEntity pedidoDetalle : detalle) {
            if (isNull(detalle) || Detalles.isEmpty() || isNull(pedidoDetalle)) {
                setTotal(0.0);
            }

            tmpTotal += pedidoDetalle.getSubTotal();
        }
        setTotal(tmpTotal);
    }

    @PrePersist
    private void persistFechaRegistro() {
        FechaRegistro = new Date();
    }

    @PreUpdate
    private void updateFechaRegistro() {
        FechaRegistro = new Date();
    }

    public Integer getId() {
        return this.Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public void setDetalles(String Detalles) {
        this.Detalles = Detalles;
    }

    public Date getFechaRegistro() {
        return this.FechaRegistro;
    }

    public void setFechaRegistro(Date FechaRegistro) {
        this.FechaRegistro = FechaRegistro;
    }

    public Double getTotal() {
        return this.Total;
    }

    public void setTotal(Double Total) {
        this.Total = Total;
    }

    public String getEstado() {
        return this.Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public ClienteEntity getCliente() {
        return this.cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public void setDetalle(List<PedidoDetalleEntity> detalle) {
        this.detalle = detalle;
    }

}
