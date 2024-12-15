package ma.enset.orderservice.entities;

import jakarta.persistence.*;
import ma.enset.orderservice.model.Customer;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long customerId;
    private String description;
    @OneToMany(mappedBy = "order")
    private List<OrderItem> items = new ArrayList<>();
    @Transient
    private Customer customer;

    public Order() {
    }

    public Order(Long id, Long customerId, String description, List<OrderItem> items, Customer customer) {
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

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
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
                ", customer=" + customer +
                '}';
    }

}
