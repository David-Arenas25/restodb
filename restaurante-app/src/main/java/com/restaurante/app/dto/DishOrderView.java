package com.restaurante.app.dto;

import com.restaurante.app.config.DishOrderViewId;
import lombok.*;

import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(DishOrderViewId.class)
@Table(name = "pedido_platos",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"id_pedido", "id_plato"}
        ))
public class DishOrderView {

    @Id
    @Column(name = "id_pedido")
    private Long orderId;
    @Id
    @Column(name = "id_plato")
    private Long dishId;
    @Column(name = "nombre_plato")
    private String dishName;
    @Column(name = "cantidad")
    private Integer quantity;
    @Column(name = "nombre_mesero")
    private String waiterName;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
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
