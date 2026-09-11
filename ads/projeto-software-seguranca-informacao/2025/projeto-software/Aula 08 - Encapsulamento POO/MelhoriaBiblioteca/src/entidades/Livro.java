package entidades;

public class Livro {
	private String livro;
	private String autor;
	private int quantidade = 0;
	private double valor = 0;
	
	public Livro(String livro, String autor, int quantidade, double valor) {
		this.livro = livro;
		this.autor = autor;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	public Livro(String livro, String autor) {
		this.livro = livro;
		this.autor = autor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getLivro() {
		return livro;
	}

	public String getAutor() {
		return autor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void emprestaLivro(int quantidade) {
		if (quantidade > 0 && quantidade <= this.quantidade) {
			this.quantidade -= quantidade;			
		}
		else {
			System.out.println("Quandidade indisponível ou Valor Inválido");
		}
	}
	
	public void devolveLivro(int quantidade) {
		if (quantidade > 0) {
			this.quantidade += quantidade;			
		}
		else {
			System.out.println("Valor Inválido");
		}
		
	}
	
	public double valorTotalLivro() {
		double valorTotal = quantidade * valor;
		return valorTotal;
	}

	@Override
	public String toString() {
		return "Livro: " + livro + 
				"\nAutor: " + autor + 
				"\nQuantidade: " + quantidade + 
				"\nValor: R$" + valor +
				"\nValot Total: R$" + valorTotalLivro();
	}
}
