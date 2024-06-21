package com.restaurante.app.entity;

import com.restaurante.app.entity.PedidoPlatoId;
import jakarta.persistence.*;

@Entity
@Table(name = "PEDIDO_PLATO")
public class PedidoPlato {

    @EmbeddedId
    private PedidoPlatoId id;

    @ManyToOne
    @MapsId("idPedido")
    @JoinColumn(name = "ID_PEDIDO")
    private Pedido pedido;

    @ManyToOne
    @MapsId("idPlato")
    @JoinColumn(name = "ID_PLATO")
    private Plato plato;

    @Column(name = "CANTIDAD")
    private Long cantidad;

    public PedidoPlatoId getId() {
        return id;
    }

    public void setId(PedidoPlatoId id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }


    public Plato getPlato() {
        return plato;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }
}
