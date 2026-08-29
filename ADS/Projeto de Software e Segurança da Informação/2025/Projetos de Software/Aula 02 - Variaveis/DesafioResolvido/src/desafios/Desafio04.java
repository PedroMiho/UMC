package desafios;

import java.util.Scanner;

public class Desafio04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o capital inicial: ");
		double capitalInicial = sc.nextDouble();
		
		System.out.println("Informe a taxa de juros por mês");
		double taxaJuros = sc.nextDouble();
		
		System.out.println("Informe a quantidade de meses: ");
		int meses = sc.nextInt();
		sc.nextLine();
		
		double juros = capitalInicial * taxaJuros * meses;
		
		System.out.printf("O valor final a ser pago será de %.2f %n", juros);
		
		
		sc.close();

	}

}
