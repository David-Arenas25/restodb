package com.restaurante.app.dto;
import javax.persistence.*;
@Entity
@Table(name = "pedido_bebidas",
       uniqueConstraints = @UniqueConstraint(
           columnNames = {"id_pedido", "id_bebida"}
       ))
public class DrinkOrderView {

    @Id
    @Column(name ="id_pedido")
    private Long orderId;
    @Id
    @Column(name ="id_bebida")
    private Long drinkId;
    @Column(name ="nombre_bebida")
    private String drinkName;
    @Column(name ="cantidad")
    private Integer quantity;
    @Column(name ="nombre_mesero")
    private String waiterName;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public Long getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(Long drinkId) {
        this.drinkId = drinkId;
    }
}
