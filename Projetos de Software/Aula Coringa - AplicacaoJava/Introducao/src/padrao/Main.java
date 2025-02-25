package padrao;
public class Main {

	public static void main(String[] args) {
		System.out.println("Esse é o filme");
		System.out.println("Filme: Top Gun: Maverick");
		
		int anoLancamento = 2022;
		boolean incluidoPlano = true;
		double notaFilme = 8.1;
		double media = (9.8 + 6.3 + 8)/3;
		System.out.printf("%.2f%n",media);
		
		String sinopse;
		sinopse = """
				Filme Top Gun
				Filme de aventura com galã dos anos 80
				Muito Bom!
				Ano de Lançamento
				""" + anoLancamento;
		System.out.println(sinopse);
		
		//Convertendo valores
		int classificacao = (int) media/2;
		System.out.println(classificacao);
		
		
	}
}
