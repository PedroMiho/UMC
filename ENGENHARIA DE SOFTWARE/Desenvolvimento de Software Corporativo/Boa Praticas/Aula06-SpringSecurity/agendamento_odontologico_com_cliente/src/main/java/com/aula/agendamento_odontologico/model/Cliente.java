package com.aula.agendamento_odontologico.model;

import com.aula.agendamento_odontologico.dto.DadosAtualizacaoCliente;
import com.aula.agendamento_odontologico.dto.DadosCadastroCliente;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "cliente")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Cliente(DadosCadastroCliente dadosCliente) {
        this.ativo = true;
        this.nome = dadosCliente.nome();
        this.email = dadosCliente.email();
        this.endereco = new Endereco(dadosCliente.endereco());
    }

    public void alterarDados(DadosAtualizacaoCliente dadosCliente) {
        if (dadosCliente.nome() != null){
            this.nome = dadosCliente.nome();
        }

        if (dadosCliente.dtoEndereco() != null) {
            this.endereco.atualizarInformacao(dadosCliente.dtoEndereco());
        }
    }

    public void atualizarStatus() {
        this.ativo = false;
    }
}
