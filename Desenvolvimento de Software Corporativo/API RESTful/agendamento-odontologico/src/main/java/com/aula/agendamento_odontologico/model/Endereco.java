package com.aula.agendamento_odontologico.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;

    public Endereco(com.aula.agendamento_odontologico.dto.Endereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
    }

    public void atualizarInformacao(com.aula.agendamento_odontologico.dto.Endereco endereco) {
        if (endereco.logradouro() != null){
            this.logradouro = endereco.logradouro();
        }
        if (endereco.bairro() != null){
            this.bairro = endereco.bairro();
        }
        if (endereco.cep() != null){
            this.cep = endereco.cep();
        }
        if (endereco.cidade() != null){
            this.cidade = endereco.cidade();
        }
        if (endereco.uf() != null){
            this.uf = endereco.uf();
        }
        if (endereco.complemento() != null){
            this.complemento = endereco.complemento();
        }
    }
}
