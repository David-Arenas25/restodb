package com.restaurante.app.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
public class DishOrderViewId implements Serializable {
    private Long orderId;
    private Long dishId;

    public DishOrderViewId() {
    }

    public DishOrderViewId(Long orderId, Long dishId) {
        this.orderId = orderId;
        this.dishId = dishId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishOrderViewId that = (DishOrderViewId) o;
        return Objects.equals(orderId, that.orderId) && Objects.equals(dishId, that.dishId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, dishId);
    }


}