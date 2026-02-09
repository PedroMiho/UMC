package org.example.Model;

public class Pagamento {
    private int id;
    private String nomeCliente;
    private double valor;
    private String data;

    // Construtor
    public Pagamento(String nomeCliente, double valor, String data) {
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.data = data;
    }

    // Getters e Setters (encapsulamento)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if(valor > 0) { // regra de negócio simples
            this.valor = valor;
        }
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
