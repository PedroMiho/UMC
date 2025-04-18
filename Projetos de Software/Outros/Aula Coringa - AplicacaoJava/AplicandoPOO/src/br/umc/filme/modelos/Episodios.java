package br.umc.filme.modelos;

import br.umc.filme.calculo.Classificavel;

public class Episodios implements Classificavel {
	
	private int numero;
	private String nome;
	private Serie serie;
	private int totalVisualizacoes;
	
	
	public void setTotalVisualizacoes(int totalVisualizacoes) {
		this.totalVisualizacoes = totalVisualizacoes;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	public int getTotalVisualizacoes() {
		return totalVisualizacoes;
	}
	
	public String getNome() {
		return nome;
	}

	public Serie getSerie() {
		return serie;
	}
	
	public int getNumero() {
		return numero;
	}
	
	@Override
	public int getClassificacao() {
		
		if (totalVisualizacoes > 100) {
			return 4;			
		}
		else {
			return 2;
		}
	}
	
	
	
	
	
}
