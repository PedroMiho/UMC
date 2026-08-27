package com.aula.agendamento_odontologico.controller;

import com.aula.agendamento_odontologico.dto.DadosAtualizacaoDentista;
import com.aula.agendamento_odontologico.dto.DadosCadastroDentista;
import com.aula.agendamento_odontologico.dto.DadosListagemDentista;
import com.aula.agendamento_odontologico.model.Dentista;
import com.aula.agendamento_odontologico.repository.DentistaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<DadosListagemDentista> listaDentista(Pageable paginacao){
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemDentista::new);
    }

    @PutMapping
    @Transactional
    public void alterarDadosDenstista(@RequestBody @Valid DadosAtualizacaoDentista dadosDentista){
        var dentista = repository.getReferenceById(dadosDentista.id());
        dentista.alterarDados(dadosDentista);
    }

    @DeleteMapping("{id}")
    @Transactional
    public void removerDentista(@PathVariable Long id){
        var dentista = repository.getReferenceById(id);
        dentista.atualizarStatus();
    }
}


