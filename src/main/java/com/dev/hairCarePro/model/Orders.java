package com.dev.hairCarePro.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_cost", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalCost;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "mode_of_payment", nullable = false)
    private String modeOfPayment;

    @Column(name = "order_status", nullable = false)
    private String orderStatus;

    // One-to-many relationship with Product
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<Product> products;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Constructors

    public Orders() {}

    public Orders(BigDecimal totalCost, LocalDateTime createdAt, String productName, String address, String modeOfPayment, String orderStatus, List<Product> products) {
        this.totalCost = totalCost;
        this.createdAt = createdAt;
        this.productName = productName;
        this.address = address;
        this.modeOfPayment = modeOfPayment;
        this.orderStatus = orderStatus;
        this.products = products;
    }

    // toString Method

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", totalCost=" + totalCost +
                ", createdAt=" + createdAt +
                ", productName='" + productName + '\'' +
                ", address='" + address + '\'' +
                ", modeOfPayment='" + modeOfPayment + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", products=" + products +
                '}';
    }
}
