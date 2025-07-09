package com.restaurante.app.config;

import java.io.Serializable;
import java.util.Objects;

public class DrinkOrderViewId implements Serializable {
    private Long orderId;
    private Long drinkId;

    public DrinkOrderViewId() {}

    public DrinkOrderViewId(Long orderId, Long drinkId) {
        this.orderId = orderId;
        this.drinkId = drinkId;
    }

    // Getters y setters
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public Long getDrinkId() { return drinkId; }
    public void setDrinkId(Long drinkId) { this.drinkId = drinkId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrinkOrderViewId that = (DrinkOrderViewId) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(drinkId, that.drinkId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, drinkId);
    }
}