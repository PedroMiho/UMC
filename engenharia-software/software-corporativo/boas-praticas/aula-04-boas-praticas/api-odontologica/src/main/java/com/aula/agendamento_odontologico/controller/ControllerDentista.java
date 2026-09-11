package com.aula.agendamento_odontologico.controller;

import com.aula.agendamento_odontologico.dto.DadosAtualizacaoDentista;
import com.aula.agendamento_odontologico.dto.DadosCadastroDentista;
import com.aula.agendamento_odontologico.dto.DadosDetalhamentoDentista;
import com.aula.agendamento_odontologico.dto.DadosListagemDentista;
import com.aula.agendamento_odontologico.model.Dentista;
import com.aula.agendamento_odontologico.repository.DentistaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequestMapping("/dentista")
@RestController
public class ControllerDentista {

    @Autowired //Deixa a responsabilidade de instanciar para o Spring
    private DentistaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarDentista(@RequestBody @Valid  DadosCadastroDentista dadosDentista, UriComponentsBuilder uriBuilder) {
        var dentista = new Dentista(dadosDentista);
        repository.save(dentista);

        var uri = uriBuilder.path("/dentista/{id}").buildAndExpand(dentista.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoDentista(dentista));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemDentista>> listaDentista(Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemDentista::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity alterarDadosDenstista(@RequestBody @Valid DadosAtualizacaoDentista dadosDentista){
        var dentista = repository.getReferenceById(dadosDentista.id());
        dentista.alterarDados(dadosDentista);

        return ResponseEntity.ok(new DadosDetalhamentoDentista(dentista));

    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity removerDentista(@PathVariable Long id){
        var dentista = repository.getReferenceById(id);
        dentista.atualizarStatus();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity detalharDentista(@PathVariable Long id){
        var dentista = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoDentista(dentista));
    }
}


