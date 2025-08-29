package ek.osnb.jpa.orders.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum OrderStatus {
    PENDING, SHIPPED, DELIVERED;

    public OrderStatus getStatus()
    {
        return status;
    }

    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
