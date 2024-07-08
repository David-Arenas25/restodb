package com.restaurante.app.dto;
import javax.persistence.*;
@Entity
public class DrinkOrderView {

    @Id
    @Column(name ="id_Pedido")
    private Long orderId;
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
}
