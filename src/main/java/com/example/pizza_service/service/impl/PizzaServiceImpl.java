package com.example.pizza_service.service.impl;


import com.example.pizza_service.dto.PizzaDTO;
import com.example.pizza_service.entity.Order;
import com.example.pizza_service.entity.Pizza;
import com.example.pizza_service.entity.User;
import com.example.pizza_service.enums.Pizzas;
import com.example.pizza_service.enums.Toppings;
import com.example.pizza_service.repository.OrderRepository;
import com.example.pizza_service.repository.PizzaRepository;
import com.example.pizza_service.repository.UserRepository;
import com.example.pizza_service.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepository pizzaRepository;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public PizzaServiceImpl(PizzaRepository pizzaRepository, OrderRepository orderRepository, UserRepository userRepository) {
        this.pizzaRepository = pizzaRepository;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Long addPizza(Long userId, PizzaDTO pizzaDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User not found"));

        Order order = user.getOrders().stream().filter(Order::getActive).findFirst().orElse(null);

        if (order == null) {
            order = new Order(user, true);
            order = orderRepository.save(order);

            user.getOrders().add(order);
            userRepository.save(user);
        }

        Pizza pizza = PizzaDTO.fromDTO(pizzaDTO);
        order.addPizza(pizza);
        pizza.setOrder(order);
        orderRepository.save(order);

        return order.getId();
    }

    @Override
    public Map<String, Object> getAll() {
        Map<String, Object> container = new HashMap<>();
        container.put("pizzas", Pizzas.values());
        container.put("toppings", Toppings.values());
        return container;
    }

}
