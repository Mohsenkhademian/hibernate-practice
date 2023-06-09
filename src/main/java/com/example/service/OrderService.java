package com.example.service;


import com.example.entity.Order;
import com.example.repository.OrderRepository;

import java.time.LocalDate;
import java.util.List;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(Order order) {
        orderRepository.update(order);
    }

    public Order findOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> findOrdersByDateRange(LocalDate startDate, LocalDate endDate) {
        return orderRepository.findOrderByDateRange(startDate, endDate);
    }
}