package com.example.pizza_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User customer;

    @OneToMany()
    private List<Pizza> pizzas = new ArrayList<>();

    @Column(name = "final_price")
    private Double price = 0.0;

    @Column(name = "is_active")
    private Boolean isActive;

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
    public Order(User customer, boolean isActive) {
        this.customer = customer;
        this.isActive = isActive;
    }


    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
        price = 0.0;
        pizzas.forEach(pizza -> price += pizza.getPrice());
    }

    public void addPizza(Pizza pizza) {
        price += pizza.getPrice();
        pizzas.add(pizza);
    }


}
