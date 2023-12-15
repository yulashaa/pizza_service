package com.example.pizza_service.dto;


import com.example.pizza_service.entity.Topping;
import com.example.pizza_service.enums.Toppings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToppingDTO {

    private Long id;
    private String name;
    private Double price;

    private Double price;

    public static ToppingDTO toDTO(Topping topping) {
        ToppingDTO dto = new ToppingDTO();
        dto.setName(topping.getName());
        return dto;
    }

    public static Topping fromDTO(ToppingDTO dto) {
        return create(dto.getName());
    }

    public static Topping create(String name) {
        Topping topping = new Topping();
        Toppings toppings = Toppings.getByName(name);
        topping.setName(toppings.getName());
        topping.setPrice(toppings.getPrice());

        return topping;
    }
}
