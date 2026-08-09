package com.aula.agendamento_odontologico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record Endereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String uf,
        String complemento,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep
) {
}
