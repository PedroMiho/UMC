package br.umc.filme.modelos;

public class Serie extends Titulo{
	
	private int temporadas;
	private int espidiosPorTemporada;
	private boolean ativa;
	private int minutosPorEpisodio;
	
	//Setters Atributos
	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}
	public void setMinutosPorEpisodio(int minutosPorEpisodio) {
		this.minutosPorEpisodio = minutosPorEpisodio;
	}
	public void setEspidiosPorTemporada(int espidiosPorTemporada) {
		this.espidiosPorTemporada = espidiosPorTemporada;
	}
	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}
	
	//Getters Atributos
	public int getTemporadas() {
		return temporadas;
	}

	public int getMinutosPorEpisodio() {
		return minutosPorEpisodio;
	}
	
	public boolean isAtiva() {
		return ativa;
	}
	
	public int getEspidiosPorTemporada() {
		return espidiosPorTemporada;
	}
	
	@Override
	public int getDuracaoMinutos() {
		return temporadas *  minutosPorEpisodio * espidiosPorTemporada;
	}
	
	@Override
	public void exibeFichaTecnica () {
		System.out.println("=== Ficha Técnica da Serie ===");
		System.out.println("Nome Filme: "+ getNome());
		System.out.println("Ano lançamento: " + getAnoLancamento());
		System.out.println("Tempo de duracao: " + getDuracaoMinutos());
	}

	
}
