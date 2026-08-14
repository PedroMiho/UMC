package com.aula.agendamento_odontologico.controller;

import com.aula.agendamento_odontologico.dto.DadosCadastroDentista;
import com.aula.agendamento_odontologico.dto.DadosListagemDentista;
import com.aula.agendamento_odontologico.model.Dentista;
import com.aula.agendamento_odontologico.repository.DentistaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dentista")
@RestController
public class ControllerDentista {

    @Autowired //Deixa a responsabilidade de instanciar para o Spring
    private DentistaRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarDentista(@RequestBody @Valid  DadosCadastroDentista dadosDentista) {
        repository.save(new Dentista(dadosDentista));
    }

    @GetMapping
    public List<DadosListagemDentista> listarDentistas() {
        return repository.findAll().stream().map(DadosListagemDentista::new).toList();
    }
}
