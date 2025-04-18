package padrao;

public class Condicional {

	public static void main(String[] args) {
		int anoLancamento = 2022;
		boolean incluidoPlano = true;
		double notaFilme = 8.1;
		String tipoPlano = "plus"; 
		
		if (anoLancamento >= 2022) {
			System.out.println("Lançamento que os clientes estão curtindo");
		}
		
		else {
			System.out.println("Filme retrô que vale a pena assistir");
		}
		
		if (incluidoPlano || tipoPlano.equals("plus")) {
			System.out.println("Filme liberado");
		}
		else {
			System.out.println("Precisa pagar o aluguel");			
		}
		
		

	}

}
