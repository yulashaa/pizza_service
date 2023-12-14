package com.example.pizza_service.controller;


import com.example.pizza_service.service.CacheSampleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleController {

    private final CacheSampleService service;

    public SampleController(CacheSampleService service) {
        this.service = service;
    }

    @GetMapping("/{number}")
    public Long sampleCache(@PathVariable Long number) {
        return service.sample(number);
    }

    @GetMapping("/call/{number}")
    public Long sampleNotCached(@PathVariable Long number) {
        return service.sampleNoCached(number);
    }

}
