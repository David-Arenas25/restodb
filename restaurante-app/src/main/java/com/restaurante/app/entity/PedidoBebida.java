package com.restaurante.app.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "PEDIDO_BEBIDA")
public class PedidoBebida {

    @EmbeddedId
    private PedidoBebidaId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPedido")
    @JoinColumn(name = "ID_PEDIDO")
    private Pedido pedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idBebida")
    @JoinColumn(name = "ID_BEBIDA")
    private Bebida bebida;

    @Column(name = "CANTIDAD")
    private Long cantidad;

    public PedidoBebidaId getId() {
        return id;
    }

    public void setId(PedidoBebidaId id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Bebida getBebida() {
        return bebida;
    }


    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
