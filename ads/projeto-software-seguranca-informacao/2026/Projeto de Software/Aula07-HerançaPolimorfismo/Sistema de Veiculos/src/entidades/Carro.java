package entidades;

import servicos.Alugavel;

public class Carro extends Veiculo implements Alugavel{

	private boolean arCordicionado;
		
	public Carro(String marca, String modelo, int ano, double valorDiario, boolean arCordicionado) {
		super(marca, modelo, ano, valorDiario);
		this.arCordicionado = arCordicionado;
	}
	
	@Override
	public double calcularAluguel(int dias) {
		double valorAluguel;
		
		if (arCordicionado) {
			valorAluguel = (dias * getValorDiario() * 1.1);
		}
		else {
			valorAluguel = (dias * getValorDiario());
		}
		
		return valorAluguel;
		
	}
	
	
	@Override
	public String toString() {
		return "marca=" + getMarca() + 
				", modelo=" + getModelo() + 
				", ano=" + getAno() + 
				", valorDiario=" + getValorDiario() + 
				", Ar condicionado=" + arCordicionado;
	}



	
	
	
	
	

}
