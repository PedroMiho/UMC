package com.example.lojaRoupas.controller;


import lombok.Getter;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/roupa")
public class Roupa {

    @GetMapping
    public String helloWorld(){
        return "Hello Mundo";
    }

    @PostMapping
    public void teste(){
        System.out.println("teste");
    }
}
