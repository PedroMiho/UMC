package com.aula.agendamento_odontologico.controller;

import com.aula.agendamento_odontologico.dto.DadosAtualizacaoCliente;
import com.aula.agendamento_odontologico.dto.DadosCadastroCliente;
import com.aula.agendamento_odontologico.dto.DadosDetalhamentoCliente;
import com.aula.agendamento_odontologico.dto.DadosListagemCliente;
import com.aula.agendamento_odontologico.model.Cliente;
import com.aula.agendamento_odontologico.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RequestMapping("/cliente")
@RestController
public class ControllerCliente {

    @Autowired //Deixa a responsabilidade de instanciar para o Spring
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dadosCliente, UriComponentsBuilder uriBuilder) {
        var cliente = new Cliente(dadosCliente);
        repository.save(cliente);

        var uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemCliente>> listaCliente(Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemCliente::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity alterarDadosCliente(@RequestBody @Valid DadosAtualizacaoCliente dadosCliente){
        var cliente = repository.getReferenceById(dadosCliente.id());
        cliente.alterarDados(dadosCliente);

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));

    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity removerCliente(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.atualizarStatus();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity detalharCliente(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }
}
