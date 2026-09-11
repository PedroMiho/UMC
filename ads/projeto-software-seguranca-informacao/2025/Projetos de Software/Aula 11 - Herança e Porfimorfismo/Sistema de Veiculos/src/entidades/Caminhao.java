package entidades;

import servicos.Alugavel;

public class Caminhao extends Veiculo implements Alugavel{
	private int capacidadeCarga;
	
	public Caminhao(String marca, String modelo, int ano, double valorDiario, int capacidadeCarga) {
		super(marca, modelo, ano, valorDiario);
		this.capacidadeCarga = capacidadeCarga;
	}

	@Override
	public double calcularAluguel(int dias) {
		double valorAluguel;
		
		if (capacidadeCarga < 250) {
			valorAluguel = (dias * getValorDiario());
		}
		else if (capacidadeCarga < 500) {
			valorAluguel = (dias * getValorDiario() * 1.25);
		}
		else if (capacidadeCarga < 750) {
			valorAluguel = (dias * getValorDiario() * 1.5);
		}
		else {
			valorAluguel = (dias * getValorDiario() * 1.75);
		}
		
		return valorAluguel;
		
	}
	@Override
	public String toString() {
		return "marca=" + getMarca() + 
				", modelo=" + getModelo() + 
				", ano=" + getAno() + 
				", valorDiario=" + getValorDiario() + 
				", Capacidade de Carga=" + capacidadeCarga;	
	}

	
	
	
}
