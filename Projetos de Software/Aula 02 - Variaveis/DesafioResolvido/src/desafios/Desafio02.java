package desafios;
import java.util.Scanner;

public class Desafio02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o capital inicial: ");
		double capitalInicial = sc.nextDouble();
		
		System.out.println("Informe a taxa de juros por mês: ");
		double taxaJuros = sc.nextDouble()/100;
		
		System.out.println("Informe o tempo em meses: ");
		int tempo = sc.nextInt();
		sc.nextLine();    
		
		double juros = Math.pow(1 + taxaJuros, tempo);
		
		double montante = capitalInicial * juros;
		
		System.out.printf("O valor do montante é de R$ %.2f %n", montante);
		
		sc.close();
	}

}
