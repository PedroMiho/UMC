package com.aula.agendamento_odontologico.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoDentista(
        @NotNull
        Long id,
        String nome,
        Endereco endereco
) {
}
