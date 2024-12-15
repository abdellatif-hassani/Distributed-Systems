package ma.enset.orderservice.dtos;

import jakarta.persistence.*;
import ma.enset.orderservice.entities.OrderItem;
import ma.enset.orderservice.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class OrderDTO {
    private Long id;
    private Long customerId;
    private String description;
    private List<OrderItemDTO> items = new ArrayList<>();
    private Customer customer;
    public OrderDTO() {
    }

    public OrderDTO(Long id, Long customerId, String description, List<OrderItemDTO> items, Customer customer) {
        this.id = id;
        this.customerId = customerId;
        this.description = description;
        this.items = items;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", description='" + description + '\'' +
                ", items=" + items +
                ", customer=" + customer +
                '}';
    }
}
