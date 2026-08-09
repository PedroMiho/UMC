package Entidades;

public class Livro {
	
	private String livro;
	private String autor;
	private int quantidade;
	private double valor;
	
	public Livro(String livro, String autor, int quantidade, double valor) {
		this.livro = livro;
		this.autor = autor;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	
	public Livro(String livro, String autor, double valor) {
		this.livro = livro;
		this.autor = autor;
		this.valor = valor;
	}
	
	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double valorTotalLivro() {
		double valorTotal = quantidade * valor;
		return valorTotal;
	}
	
	public void emprestaLivro(int quantidade) {
		this.quantidade -= quantidade;	
	}
	
	public void devolveLivro(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public String toString() {
		return "Livro: " + livro
			+ " Autor: " + autor
			+ " Quantidade de Examplares: " + quantidade
			+ " Valor do Livro: R$ " + String.format("%.2f", valor)
			+ " Valor total dos livro: R$ " + String.format("%.2f", valorTotalLivro());
	}
	
}
