package com.example.service;


import com.example.entity.OrderItem;
import com.example.repository.OrderItemRepository;

import java.util.List;

public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public void saveOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public void updateOrderItem(OrderItem orderItem) {
        orderItemRepository.update(orderItem);
    }

    public OrderItem findOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public List<OrderItem> findAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public List<OrderItem> findOrderItemsByQuantity(int quantity) {
        return orderItemRepository.findByQuantity(quantity);
    }
}