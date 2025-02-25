package filme;

public class Filme {
	String nome;
	int anoLancamento;
	boolean incluidoPlano;
	private double somaAvaliacao;
	private int totalAvaliacao;
	private int duracaoMinutos;
	
	void exibeFichaTecnica () {
		System.out.println("Nome Filme: "+ nome);
		System.out.println("Ano lançamento: " + anoLancamento);
		System.out.println("Tempo de duracao: " + duracaoMinutos);
	}
	
	void avalia (double nota) {
		somaAvaliacao += nota;
		totalAvaliacao++;
	}
	
	double pegaMedia() {
		return somaAvaliacao / totalAvaliacao;
	}
	
	
	
}
