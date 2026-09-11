package com.aula.agendamento_odontologico.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(
        @NotNull
        Long id,
        String nome,
        DtoEndereco dtoEndereco
) {
}
