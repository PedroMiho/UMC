package entidades;

public class Conta {
    private String titular;
    private double saldo;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    //Getters
    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

   //Setters
    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void depositar(double valor){
        if (valor <= 0){
            System.out.println("Valor invalido");
        } else {
            this.saldo += valor;
            System.out.println("Depositado com sucesso");
        }
    }

    //Criar o metodo Sacar
    public void sacar(double valor){
        if (valor <= 0 && valor > this.saldo){
            System.out.println("Valor invalido");
        } else {
            this.saldo -= valor;
        }
    }




}
