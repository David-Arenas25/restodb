package com.restaurante.app.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "BEBIDAS")
public class Bebida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BEBIDA")
    private Long idBebida;

    @Column(name = "NOMBRE_BEBIDA")
    private String nombreBebida;

    @Column(name = "DESCRIPCION_BEBIDA")
    private String descripcionBebida;

    @Column(name = "PRECIO_BEBIDA")
    private Float precioBebida;

    @OneToMany(mappedBy = "bebida", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PedidoBebida> pedidoBebidas;

    public List<PedidoBebida> getPedidoBebidas() {
        return pedidoBebidas;
    }

    public void setPedidoBebidas(List<PedidoBebida> pedidoBebidas) {
        this.pedidoBebidas = pedidoBebidas;
    }

    public Long getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Long idBebida) {
        this.idBebida = idBebida;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public String getDescripcionBebida() {
        return descripcionBebida;
    }

    public void setDescripcionBebida(String descripcionBebida) {
        this.descripcionBebida = descripcionBebida;
    }

    public Float getPrecioBebida() {
        return precioBebida;
    }

    public void setPrecioBebida(Float precioBebida) {
        this.precioBebida = precioBebida;
    }
}
