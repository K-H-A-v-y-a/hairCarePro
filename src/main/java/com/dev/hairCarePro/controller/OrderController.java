package com.dev.hairCarePro.controller;

import com.dev.hairCarePro.repository.*;
import com.dev.hairCarePro.model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping("/all")
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll(); // Fetches all orders from the database
    }
    
    // Endpoint to create an order
    @PostMapping("/create")
    public Orders createOrder(@RequestBody OrderRequest orderRequest) {
        // Retrieve products based on the product IDs provided in the request
        List<Product> products = productRepository.findAllById(orderRequest.getProductIds());

        // Calculate the total cost
        BigDecimal totalCost = products.stream()
            .map(Product::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        // Create the order with the provided details and products
        Orders order = new Orders(
                totalCost,
                LocalDateTime.now(),
                orderRequest.getProductName(),  // You can adjust this if you need a single name or multiple
                orderRequest.getAddress(),
                orderRequest.getModeOfPayment(),
                orderRequest.getOrderStatus(),
                products
        );

        // Save the order to the database
        return ordersRepository.save(order);
    }

    // Request body model (directly within the controller for simplicity)
    public static class OrderRequest {

        private String productName;   // You can adjust this if you want to use a single name or a list
        private String address;
        private String modeOfPayment;
        private String orderStatus;
        private List<Long> productIds;  // List of product IDs added to the order

        // Getters and Setters
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

        public List<Long> getProductIds() {
            return productIds;
        }

        public void setProductIds(List<Long> productIds) {
            this.productIds = productIds;
        }
    }
}
