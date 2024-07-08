package com.restaurante.app.entity;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "PEDIDOS")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PEDIDO")
    private Long idPedido;

    @Column(name = "FECHA_PEDIDO")
    private Date fechaPedido;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "ID_MESERO")
    private Long idMesero; // Este campo guarda el ID del mesero

    @ManyToOne
    @JoinColumn(name = "ID_MESERO",insertable = false,updatable = false)
    private Mesero mesero;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<PedidoBebida> pedidoBebidas;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PedidoPlato> pedidoPlatos;

    private Float total;

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Mesero getMesero() {
        return mesero;
    }

    public void setMesero(Mesero mesero) {
        this.mesero = mesero;
    }

    public List<PedidoBebida> getPedidoBebidas() {
        return pedidoBebidas;
    }

    public void setPedidoBebidas(List<PedidoBebida> pedidoBebidas) {
        this.pedidoBebidas = pedidoBebidas;
    }

    public List<PedidoPlato> getPedidoPlatos() {
        return pedidoPlatos;
    }

    public void setPedidoPlatos(List<PedidoPlato> pedidoPlatos) {
        this.pedidoPlatos = pedidoPlatos;
    }

    public Long getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(Long idMesero) {
        this.idMesero = idMesero;
    }
}
