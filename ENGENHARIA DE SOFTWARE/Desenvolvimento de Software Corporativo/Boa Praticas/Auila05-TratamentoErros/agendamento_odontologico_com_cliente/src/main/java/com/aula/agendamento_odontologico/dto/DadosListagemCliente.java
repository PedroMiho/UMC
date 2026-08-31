package com.aula.agendamento_odontologico.dto;

import com.aula.agendamento_odontologico.model.Cliente;

public record DadosListagemCliente(
        Long id,
        String nome,
        String email
) {

    public DadosListagemCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }
}
