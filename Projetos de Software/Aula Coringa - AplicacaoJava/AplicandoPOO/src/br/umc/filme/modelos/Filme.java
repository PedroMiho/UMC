package br.umc.filme.modelos;

import br.umc.filme.calculo.Classificavel;

public class Filme extends Titulo implements Classificavel {
	
	private String diretor;

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
	@Override
	public void exibeFichaTecnica () {
		System.out.println("=== Ficha Técnica do Filme ===");
		System.out.println("Nome Filme: "+ getNome());
		System.out.println("Ano lançamento: " + getAnoLancamento());
		System.out.println("Tempo de duracao: " + getDuracaoMinutos());
		System.out.println("Diretor: " + diretor);
	}

	@Override
	public int getClassificacao() {
		return (int) calculaMedia() / 2;
	}
	
	
	
}
