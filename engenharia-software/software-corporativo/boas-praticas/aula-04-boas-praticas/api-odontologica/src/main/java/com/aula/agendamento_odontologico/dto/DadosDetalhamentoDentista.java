package com.aula.agendamento_odontologico.dto;

import com.aula.agendamento_odontologico.enums.Especialidade;
import com.aula.agendamento_odontologico.model.Dentista;
import com.aula.agendamento_odontologico.model.Endereco;

public record DadosDetalhamentoDentista(
        Long id,
        String nome,
        String cro,
        Especialidade especialidade,
        String email,
        Endereco endereco
) {

    public DadosDetalhamentoDentista(Dentista dentista) {
        this(dentista.getId(), dentista.getNome(), dentista.getCro(), dentista.getEspecialidade(), dentista.getEmail(), dentista.getEndereco());
    }
}
