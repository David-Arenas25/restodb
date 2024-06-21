package com.restaurante.app.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class PedidoBebidaId implements Serializable {

    @Column(name = "ID_PEDIDO")
    private Long idPedido;

    @Column(name = "ID_BEBIDA")
    private Long idBebida;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Long idBebida) {
        this.idBebida = idBebida;
    }


}
