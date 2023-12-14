package com.example.pizza_service.service;

import com.example.pizza_service.dto.OrderDTO;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface OrderService {

    Map<String, Object> confirmOrder(Long id);

    OrderDTO getOrder(Long id);

    List<OrderDTO> getUserOrders(Long id);
}
