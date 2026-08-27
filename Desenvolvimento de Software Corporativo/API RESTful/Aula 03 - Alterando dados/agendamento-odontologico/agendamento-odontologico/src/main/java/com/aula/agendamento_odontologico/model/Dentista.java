package com.aula.agendamento_odontologico.model;

import com.aula.agendamento_odontologico.dto.DadosCadastroDentista;
import com.aula.agendamento_odontologico.enums.Especialidade;
import jakarta.persistence.*;
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
    private Endereco Endereco;

    public Dentista(DadosCadastroDentista dadosDentista) {
        this.nome = dadosDentista.nome();
        this.email = dadosDentista.email();
        this.cro = dadosDentista.cro();
        this.especialidade = dadosDentista.especialidade();
        this.Endereco = new Endereco(dadosDentista.endereco());



    }
}
