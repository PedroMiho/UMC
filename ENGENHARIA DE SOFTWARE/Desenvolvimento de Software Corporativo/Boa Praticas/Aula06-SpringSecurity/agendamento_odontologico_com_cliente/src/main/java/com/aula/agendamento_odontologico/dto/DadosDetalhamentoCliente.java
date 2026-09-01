package com.aula.agendamento_odontologico.dto;

import com.aula.agendamento_odontologico.model.Cliente;
import com.aula.agendamento_odontologico.model.Endereco;

public record DadosDetalhamentoCliente(
        Long id,
        String nome,
        String email,
        Endereco endereco
) {

    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getEndereco());
    }
}
