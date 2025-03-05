package br.umc.filme.modelos;

public class Titulo {

	//Classes Privadas
	private String nome;
	private int anoLancamento;
	private boolean incluidoPlano;
	private int duracaoMinutos;
	
	//Metodos Privadas
	private double somaAvaliacao;
	private int totalAvaliacao;
	
	//Getters para os metodos
	public int getTotalAvaliacao() {
		return totalAvaliacao;
	}
	
	public double getSomaAvaliacao() {
		return somaAvaliacao;
	}
	
	//Getters para os atributos
	public String getNome() {
		return nome;
	}

	public boolean isIncluidoPlano() {
		return incluidoPlano;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public int getDuracaoMinutos() {
		return duracaoMinutos;
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
