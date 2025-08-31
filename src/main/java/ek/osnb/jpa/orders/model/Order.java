package ek.osnb.jpa.orders.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import ek.osnb.jpa.common.model.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity
{
    @JsonManagedReference
    @OneToMany(mappedBy = "order", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    // Order not updated because CascadeType.PERSIST only works for new entities.
    // Add CascadeType.MERGE to enable cascading updates.
    // Order not deleted because CascadeType.PERSIST does not handle removals.
    // Add CascadeType.REMOVE to enable cascading deletes.

    private List<OrderLine> orderLines = new ArrayList<>();

    //Note: The mappedBy attribute indicates that the Order entity is not the owner of the relationship.
    // The OrderLine entity owns the relationship, as it contains the foreign key.

    private LocalDate orderDate;
    private OrderStatus status;

    public Order() {}

    public Order(LocalDate orderDate, OrderStatus status) {
        this.orderDate = orderDate;
        this.status = status;
    }

    public List<OrderLine> getOrderLines()
    {
        return orderLines;
    }

    //removing the setOrderLines() method to avoid manipulating the list directly.
    /*public void setOrderLines(List<OrderLine> orderLines)
    {
        this.orderLines = orderLines;
    }*/

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    //Metode til at tilføje en OrderLine
    public void addOrderLine(OrderLine orderLine) {
        orderLines.add(orderLine);
        orderLine.setOrder(this);
    }

    //Metode til at fjerne en OrderLine
    public void removeOrderLine(OrderLine orderLine) {
        orderLines.remove(orderLine);
        orderLine.setOrder(null);
    }

    //Metode til at clear alle OrderLines
    public void clearOrderLines() {
        for (OrderLine orderLine : new ArrayList<>(orderLines)) {
            removeOrderLine(orderLine);
        }
    }
}
