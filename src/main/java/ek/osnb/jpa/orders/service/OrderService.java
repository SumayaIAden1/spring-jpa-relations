package ek.osnb.jpa.orders.service;


import ek.osnb.jpa.orders.model.Order;
import ek.osnb.jpa.orders.model.OrderStatus;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders(OrderStatus status);
    Order getOrderById(Long id);
    Order createOrder(Order order);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);

}
