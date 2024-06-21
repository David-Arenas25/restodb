package com.restaurante.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class DishOrderView {

    @Id
    @Column(name ="id_Pedido")
    private Long orderId;
    @Column(name ="nombre_plato")
    private String dishName;
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

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
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
