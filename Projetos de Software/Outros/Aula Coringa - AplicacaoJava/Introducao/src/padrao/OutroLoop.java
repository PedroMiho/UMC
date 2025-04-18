package padrao;

import java.util.Scanner;

public class OutroLoop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double mediaAvaliacao = 0;
		double nota = 0;
		int totalNotas = 0;
		
		while (nota != -1) {
			System.out.println("Digite uma nota e -1 para parar: ");
			nota = sc.nextDouble();
			if (nota != -1) {
				mediaAvaliacao += nota;
				totalNotas++;				
			}
		}
			
		System.out.println("Média de avaliações " + mediaAvaliacao/totalNotas);


	}

}
