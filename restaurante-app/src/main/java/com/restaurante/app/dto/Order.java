package com.restaurante.app.dto;
import com.restaurante.app.entity.Mesa;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {

    private long orderId;
    private LocalDateTime orderDate;
    private String status;
    private String total;
    private long waiterId;
    private int tableId;
    private Mesa tables;

    public Mesa getTables() {
        return tables;
    }

    public void setTables(Mesa tables) {
        this.tables = tables;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public long getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(long waiterId) {
        this.waiterId = waiterId;
    }

}
