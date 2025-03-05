package entidades;

public class ItemPedido {
	
	private String nome;
	private int quantidade;
	private double precoUnitario;
	
	//Construtores
	public ItemPedido(String nome, int quantidade, double precoUnitario) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
	}

	//Getters e Setters
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public double getPrecoUnitario() {
		return precoUnitario;
	}


	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	public double calcularTotal() {
		return precoUnitario * quantidade;
	}

	@Override
	public String toString() {
		return "Produto: " + nome + "\nQuantidade: " + quantidade + "\nprecoUnitario: R$ " 
				+ String.format("%.2f",precoUnitario) 
				+ "\nSubtotal: R$ " + String.format("%.2f", calcularTotal());
	}
	
	
	
	
}
