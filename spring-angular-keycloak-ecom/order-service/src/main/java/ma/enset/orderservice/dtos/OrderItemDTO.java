package ma.enset.orderservice.dtos;

import ma.enset.orderservice.model.Product;

public class OrderItemDTO {
    private Long id;
    private Long productId;
    private double price;
    private int quantity;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Long id, Long productId, OrderDTO orderDTO, Product product, double price, int quantity) {
        this.id = id;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", productId=" + productId +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
