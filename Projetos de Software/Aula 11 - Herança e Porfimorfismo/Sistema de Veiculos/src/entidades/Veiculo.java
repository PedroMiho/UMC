package entidades;

public class Veiculo {
	
	private String marca;
	private String modelo;
	private int ano;
	private double valorDiario;
	
	public Veiculo(String marca, String modelo, int ano, double valorDiario) {
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valorDiario = valorDiario;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public int getAno() {
		return ano;
	}
	
	public double getValorDiario() {
		return valorDiario;
	}
	
	@Override
	public String toString() {
		return "marca=" + marca + 
				", modelo=" + modelo + 
				", ano=" + ano + 
				", valorDiario=" + valorDiario;
	}
	
	
		
	
}
