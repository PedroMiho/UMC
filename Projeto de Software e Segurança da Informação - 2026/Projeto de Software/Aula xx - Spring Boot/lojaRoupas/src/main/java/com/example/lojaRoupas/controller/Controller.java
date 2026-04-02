package com.example.lojaRoupas.controller;

import com.example.lojaRoupas.model.DadosCadastroRoupa;
import com.example.lojaRoupas.model.Roupa;
import com.example.lojaRoupas.model.RoupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/roupa")
public class Controller {

    @Autowired
    private RoupaRepository repository;


    @PostMapping
    public void cadastrarRoupa(@RequestBody DadosCadastroRoupa dados) {

        repository.save(new Roupa(dados));
    }

    @GetMapping
    public List<Roupa> listarRoupas(){
        return repository.findAll();
    }

    @DeleteMapping("/{id}")
    public void excluirRoupa(@PathVariable Long id){
        repository.deleteById(id);
    }


}
