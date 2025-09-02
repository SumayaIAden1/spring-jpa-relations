package ek.osnb.jpa.orders.DTO;

import java.time.LocalDate;
import java.util.List;

public record OrderDto(Long id, LocalDate orderDate, String status, List<OrderLineDto> orderLines) {
}
