package entidades;

import servicos.Alugavel;

public class Moto extends Veiculo implements Alugavel{
	private int cilindrada;
	
	public Moto(String marca, String modelo, int ano, double valorDiario, int cilindrada) {
		super(marca, modelo, ano, valorDiario);
		this.cilindrada = cilindrada;
	}

	@Override
	public String toString() {
		return "marca=" + getMarca() + 
				", modelo=" + getModelo() + 
				", ano=" + getAno() + 
				", valorDiario=" + getValorDiario() + 
				", Cilindradas=" + cilindrada;	
	}
	
	@Override
	public double calcularAluguel(int dias) {
		double valorAluguel;
		
		if (cilindrada < 250) {
			valorAluguel = (dias * getValorDiario());
		}
		else if (cilindrada < 500) {
			valorAluguel = (dias * getValorDiario() * 1.25);
		}
		else {
			valorAluguel = (dias * getValorDiario() * 1.5);
		}
		
		return valorAluguel;
		
	}
	
	
	
	
}
