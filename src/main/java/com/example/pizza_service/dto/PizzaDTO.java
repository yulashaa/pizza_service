package com.example.pizza_service.dto;

import com.example.pizza_service.entity.Pizza;
import com.example.pizza_service.enums.Pizzas;
import com.example.pizza_service.validation.IsPizza;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PizzaDTO {
    private Long id;
    @NotBlank
    @IsPizza
    private String type;
    private Double price;
    private List<ToppingDTO> toppings;
    private String additionally;

    public static PizzaDTO toDTO(Pizza pizza) {
        return new PizzaDTO(
                pizza.getId(),
                pizza.getType(),
                pizza.getPrice(),
                pizza.getToppings().stream().map(ToppingDTO::toDTO).collect(Collectors.toList()),
                pizza.getAdditionally()
        );
    }

    public static Pizza fromDTO(PizzaDTO dto) {
        Pizza pizza = new Pizza(Pizzas.getByName(dto.getType()));

        if (dto.getToppings() != null) {
            List<String> toppings = dto.getToppings().stream().map(ToppingDTO::getName).collect(Collectors.toList());
            pizza.addToppings(toppings.stream().map(ToppingDTO::create).collect(Collectors.toList()));
            pizza.setAdditionally(String.format("[%s]", String.join(", ", toppings)));
        }

        return pizza;
    }
}
