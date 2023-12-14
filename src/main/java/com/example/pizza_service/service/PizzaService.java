package com.example.pizza_service.service;


import com.example.pizza_service.dto.PizzaDTO;

import java.util.List;
import java.util.Map;

public interface PizzaService {

    Long addPizza(Long userId, PizzaDTO pizzaDTO);

    Map<String, Object> getAll();
}
