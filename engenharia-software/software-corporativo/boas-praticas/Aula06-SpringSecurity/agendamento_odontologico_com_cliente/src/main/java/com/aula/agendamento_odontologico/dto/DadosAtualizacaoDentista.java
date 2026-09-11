package com.aula.agendamento_odontologico.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoDentista(
        @NotNull
        Long id,
        String nome,
        DtoEndereco dtoEndereco
) {
}
