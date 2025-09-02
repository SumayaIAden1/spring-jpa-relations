package ek.osnb.jpa.orders.DTO;

public record OrderLineDto(Long id, double unitPrice, int quantity, String product) {
}
