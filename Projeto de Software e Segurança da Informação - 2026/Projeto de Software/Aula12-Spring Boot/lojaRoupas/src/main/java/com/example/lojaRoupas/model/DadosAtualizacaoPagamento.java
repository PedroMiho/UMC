package com.example.lojaRoupas.model;

public record DadosAtualizacaoPagamento(
        Long id,
        String nomeProduto,
        String marca,
        Tamanho tamanho,
        double preco,
        int quantidade
) {
}
