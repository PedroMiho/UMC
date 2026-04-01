package com.example.lojaRoupas.controller;


import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/hello")
public class Hello {

    @GetMapping
    public String helloWorld(){
        return "Hello Mundo";
    }

}
