package com.aula.agendamento_odontologico.model;

import com.aula.agendamento_odontologico.dto.DadosAtualizacaoDentista;
import com.aula.agendamento_odontologico.dto.DadosCadastroDentista;
import com.aula.agendamento_odontologico.enums.Especialidade;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "dentista")
@Entity(name = "Dentista")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Dentista {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cro;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Dentista(DadosCadastroDentista dadosDentista) {
        this.ativo = true;
        this.nome = dadosDentista.nome();
        this.email = dadosDentista.email();
        this.cro = dadosDentista.cro();
        this.especialidade = dadosDentista.especialidade();
        this.endereco = new Endereco(dadosDentista.endereco());



    }

    public void alterarDados(DadosAtualizacaoDentista dadosDentista) {
        if (dadosDentista.nome() != null){
            this.nome = dadosDentista.nome();
        }

        if (dadosDentista.endereco() != null) {
            this.endereco.atualizarInformacao(dadosDentista.endereco());
        }
    }

    public void atualizarStatus() {
        this.ativo = false;
    }
}
