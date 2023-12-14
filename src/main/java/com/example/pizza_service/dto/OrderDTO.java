package com.example.pizza_service.dto;


import com.example.pizza_service.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private Long userId;

    private Double price;

    private List<PizzaDTO> pizzas;


    public static OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setUserId(order.getCustomer().getId());
        dto.setPrice(order.getPrice());
        dto.setPizzas(order.getPizzas().stream().map(PizzaDTO::toDTO).toList());

        return dto;
    }
}
