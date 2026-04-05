package com.example.lojaRoupas.model;


import jakarta.persistence.*;
import lombok.*;

@Table(name = "roupa")
@Entity (name = "pagamento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Roupa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomeProduto;
    private String marca;
    @Enumerated(EnumType.STRING)
    private Tamanho tamanho;
    private double preco;
    private int quantidade;


    public Roupa(DadosCadastroRoupa dados) {
        this.nomeProduto = dados.nomeProduto();
        this.marca = dados.marca();
        this.tamanho = dados.tamanho();
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();
    }

    public void atualizarInformacoes(DadosAtualizacaoPagamento dados) {
        this.nomeProduto = dados.nomeProduto();
        this.marca = dados.marca();
        this.tamanho = dados.tamanho();
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();
    }
}
