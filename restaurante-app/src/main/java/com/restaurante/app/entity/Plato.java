package com.restaurante.app.entity;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PLATOS")
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PLATO")
    private Long idPlato;

    @Column(name = "NOMBRE_PLATO")
    private String nombrePlato;

    @Column(name = "DESCRIPCION_PLATO")
    private String descripcionPlato;

    @Column(name = "PRECIO_PLATO")
    private Double precioPlato;

    @OneToMany(mappedBy = "plato", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PedidoPlato> pedidoPlato;

    public List<PedidoPlato> getPedidoPlato() {
        return pedidoPlato;
    }

    public void setPedidoPlato(List<PedidoPlato> pedidoPlato) {
        this.pedidoPlato = pedidoPlato;
    }

    public Long getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Long idPlato) {
        this.idPlato = idPlato;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public String getDescripcionPlato() {
        return descripcionPlato;
    }

    public void setDescripcionPlato(String descripcionPlato) {
        this.descripcionPlato = descripcionPlato;
    }

    public Double getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(Double precioPlato) {
        this.precioPlato = precioPlato;
    }
}
