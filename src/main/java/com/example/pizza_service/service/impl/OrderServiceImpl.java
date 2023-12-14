package com.example.pizza_service.service.impl;


import com.example.pizza_service.dto.OrderDTO;
import com.example.pizza_service.entity.Order;
import com.example.pizza_service.entity.User;
import com.example.pizza_service.repository.OrderRepository;
import com.example.pizza_service.repository.UserRepository;
import com.example.pizza_service.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Map<String, Object> confirmOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalStateException("Order not found"));
        if (!order.getActive()) throw new IllegalStateException("Order isn't active anymore");
        order.setActive(false);
        orderRepository.save(order);

        Map<String, Object> container = new HashMap<>();
        container.put("message", String.format("Order %s confirmed", order.getId()));
        container.put("total", order.getPrice());

        return container;
    }

    @Override
    public OrderDTO getOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalStateException("Order not found"));

        return OrderDTO.toDTO(order);
    }

    @Override
    public List<OrderDTO> getUserOrders(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("User not found"));

        return user.getOrders().stream().map(OrderDTO::toDTO).toList();
    }
}
