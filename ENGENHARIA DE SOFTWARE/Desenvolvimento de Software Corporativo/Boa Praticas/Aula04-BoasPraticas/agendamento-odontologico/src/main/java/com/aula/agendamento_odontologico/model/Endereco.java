package com.aula.agendamento_odontologico.model;

import com.aula.agendamento_odontologico.dto.DtoEndereco;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
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

    public Endereco(DtoEndereco dtoEndereco) {
        this.logradouro = dtoEndereco.logradouro();
        this.bairro = dtoEndereco.bairro();
        this.cep = dtoEndereco.cep();
        this.cidade = dtoEndereco.cidade();
        this.uf = dtoEndereco.uf();
        this.complemento = dtoEndereco.complemento();
    }

    public void atualizarInformacao(DtoEndereco dtoEndereco) {
        if (dtoEndereco.logradouro() != null){
            this.logradouro = dtoEndereco.logradouro();
        }
        if (dtoEndereco.bairro() != null){
            this.bairro = dtoEndereco.bairro();
        }
        if (dtoEndereco.cep() != null){
            this.cep = dtoEndereco.cep();
        }
        if (dtoEndereco.cidade() != null){
            this.cidade = dtoEndereco.cidade();
        }
        if (dtoEndereco.uf() != null){
            this.uf = dtoEndereco.uf();
        }
        if (dtoEndereco.complemento() != null){
            this.complemento = dtoEndereco.complemento();
        }
    }
}
