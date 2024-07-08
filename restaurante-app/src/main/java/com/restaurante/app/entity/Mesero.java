package com.restaurante.app.entity;

import javax.persistence.*;

@Entity
@Table(name = "MESEROS")
public class Mesero {

    @Id
    @Column(name = "ID_MESERO")
    private Long idMesero;

    @Column(name = "NOMBRE_MESERO")
    private String nombreMesero;

    @Column(name = "APELLIDO_MESERO")
    private String apellidoMesero;


    public Long getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(Long idMesero) {
        this.idMesero = idMesero;
    }

    public String getNombreMesero() {
        return nombreMesero;
    }

    public void setNombreMesero(String nombreMesero) {
        this.nombreMesero = nombreMesero;
    }

    public String getApellidoMesero() {
        return apellidoMesero;
    }

    public void setApellidoMesero(String apellidoMesero) {
        this.apellidoMesero = apellidoMesero;
    }


}
