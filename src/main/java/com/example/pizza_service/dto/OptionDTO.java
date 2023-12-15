package com.example.pizza_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OptionDTO {
    private Long id;

    private String option;

    private String price;
    
}
