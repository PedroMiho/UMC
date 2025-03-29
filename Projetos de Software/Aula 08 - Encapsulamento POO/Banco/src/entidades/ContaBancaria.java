package entidades;

public class ContaBancaria {
	private String titular;
	private double saldo;
	
	public ContaBancaria(String titular, double saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}

	public String getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	public void depositar (double valor) {
		if (valor > 0) {
			this.saldo += valor;
		}
		else {
			System.out.println("Valor depositado invalido");
		}
	}
	
	public void sacar (double valor) {
		if (valor > 0 && valor <= this.saldo) {
			this.saldo -= valor;
			System.out.println("O saque no valor de R$: " + valor + " foi efetuado com sucesso");
		}
		else {
			System.out.println("Saldo insuficiente ou valor invalido");
		}
	}
	
	@Override
	public String toString() {
		return "Titular: " + titular + 
				"\nSaldo: R$ " + saldo;
	}
	
	
	
	
	
	
}
