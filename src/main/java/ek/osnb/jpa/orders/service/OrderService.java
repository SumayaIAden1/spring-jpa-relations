package ek.osnb.jpa.orders.service;


import ek.osnb.jpa.orders.DTO.OrderDto;
import ek.osnb.jpa.orders.DTO.OrderLineDto;
import ek.osnb.jpa.orders.model.Order;
import ek.osnb.jpa.orders.model.OrderStatus;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrders(OrderStatus status);
    OrderDto getOrderById(Long id);
    OrderDto createOrder(OrderDto orderdto);
    OrderDto updateOrder(Long id, OrderDto orderDto);
    void deleteOrder(Long id);
    void addOrderLine(Long orderId, OrderLineDto orderLineDto);
    void removeOrderLine(Long orderId, Long orderLineId);
}
