package com.restaurante.app.dto;

public class Waiter {

    private long waiterId;
    private String waiterName;
    private String waiterLastName;


    public long getWaiterId() {
        return waiterId;
    }

    public void setWaiterId(long waiterId) {
        this.waiterId = waiterId;
    }

    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public String getWaiterLastName() {
        return waiterLastName;
    }

    public void setWaiterLastName(String waiterLastName) {
        this.waiterLastName = waiterLastName;
    }
}
