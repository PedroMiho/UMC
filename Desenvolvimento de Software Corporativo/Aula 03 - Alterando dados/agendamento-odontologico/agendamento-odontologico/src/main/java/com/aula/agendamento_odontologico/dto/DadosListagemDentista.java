package com.aula.agendamento_odontologico.dto;

import com.aula.agendamento_odontologico.enums.Especialidade;
import com.aula.agendamento_odontologico.model.Dentista;

public record DadosListagemDentista(
        String nome,
        String email,
        String cro,
        Especialidade especialidade
) {

    public  DadosListagemDentista(Dentista dentista){
        this(dentista.getNome(), dentista.getEmail(), dentista.getCro(), dentista.getEspecialidade());
    }
}


