package com.example.lojaRoupas.controller;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Boolean> teste() {
        try {
            // lógica de cadastro aqui
            return ResponseEntity.ok(true); // 200 OK
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }
}
