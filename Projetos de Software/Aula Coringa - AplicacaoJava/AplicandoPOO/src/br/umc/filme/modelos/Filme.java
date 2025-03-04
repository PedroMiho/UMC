package br.umc.filme.modelos;

public class Filme {
	
	//Classes Privadas
	private String nome;
	private int anoLancamento;
	private boolean incluidoPlano;
	private int duracaoMinutos;
	
	//Metodos Privadas
	private double somaAvaliacao;
	private int totalAvaliacao;
	
	//Getters
	public int getTotalAvaliacao() {
		return totalAvaliacao;
	}
	
	public double getSomaAvaliacao() {
		return somaAvaliacao;
	}
	
	//Setters para os atributos 
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public void setIncluidoPlano(boolean incluidoPlano) {
		this.incluidoPlano = incluidoPlano;
	}

	public void setDuracaoMinutos(int duracaoMinutos) {
		this.duracaoMinutos = duracaoMinutos;
	}

	//Metodos
	//Metodo para mostrar as propriedades da classe
	public void exibeFichaTecnica () {
		System.out.println("Nome Filme: "+ nome);
		System.out.println("Ano lançamento: " + anoLancamento);
		System.out.println("Tempo de duracao: " + duracaoMinutos);
	}

	//Metodo soma as notas e o numeros de notas digitadas
	public void avalia (double nota) {
		somaAvaliacao += nota;
		totalAvaliacao++;
	}
	
	//Metodos calcula a media
	public double calculaMedia() {
		return somaAvaliacao / totalAvaliacao;
	}
	
}
