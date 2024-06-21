package com.restaurante.app.entity;

import java.io.Serializable;
import jakarta.persistence.*;


@Embeddable
public class PedidoPlatoId implements Serializable {

    @Column(name = "ID_PEDIDO")
    private Long idPedido;

    @Column(name = "ID_PLATO")
    private Long idPlato;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Long idPlato) {
        this.idPlato = idPlato;
    }
}
