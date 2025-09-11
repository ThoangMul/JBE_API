package com.example.demo.SpringDataAPIs_bai2.Order;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class OrderDTO {
    private int id;

    @NotNull(message = "Order date is required")
    private LocalDateTime orderDate;

    private int employeeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
