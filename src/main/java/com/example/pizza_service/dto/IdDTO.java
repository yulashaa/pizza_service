package com.example.pizza_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class IdDTO {
    @NotNull
    private Long id;
}

public class яIdDTO {
    @NotNull
    private Long id;

    public IdDTO() {
    }

    public IdDTO(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}