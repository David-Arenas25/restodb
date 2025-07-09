package com.restaurante.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MESAS")
public class Mesa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MESA")
    private Long idMesa;

    @Column(name = "NUMERO_MESA")
    private int numeroMesa;

    @Column(name = "CAPACIDAD")
    private int capacidad;

    @Column(name = "ESTADO_MESA")
    private String estadoMesa;


    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(String estadoMesa) {
        this.estadoMesa = estadoMesa;
    }
}



