package com.example.pizza_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Topping implements Comparable<Topping> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "topping_id")
    private Long id;

    private String name;

    private Double price = 0.0;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "toppings")
    private Set<Pizza> pizzas = new TreeSet<>();

    @Override
    public int compareTo(Topping topping) {
        if (id == null) return 1;
        if (topping.getId() == null) return -1;

        return id.compareTo(topping.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topping topping = (Topping) o;
        return Objects.equals(id, topping.getId())
                && Objects.equals(name, topping.getName())
                && Objects.equals(price, topping.getPrice())
                && Objects.equals(pizzas, topping.getPizzas());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, pizzas);
    }
}
