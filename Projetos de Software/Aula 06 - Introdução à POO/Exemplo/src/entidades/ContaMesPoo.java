package entidades;

import java.util.Scanner;

public class ContaMesPoo {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ContaMes jan, fev;
		
		jan = new ContaMes();
		fev = new ContaMes();
		
		System.out.println("Digite as contas de Janeiro");
		jan.agua = sc.nextDouble();
		jan.alimentacao = sc.nextDouble();
		jan.energia = sc.nextDouble();
		
		System.out.println("Digite as contas de Fevereiro");
		fev.agua = sc.nextDouble();
		fev.alimentacao = sc.nextDouble();
		fev.energia = sc.nextDouble();
		
		double contaJan = jan.somaConta();
		double contaFev = fev.somaConta();
		
		if (contaJan > contaFev) {
			System.out.println("A conta de Janeiro é maior do que a de Fevereiro");
		}
		
		else if (contaFev > contaJan) {
			System.out.println("A conta de Fevereiro é maior do que a de Janeiro");
		}
		else {
			System.out.println("Ambas as contas possuem o mesmo valor");
		}
		
		sc.close();

	}

}

		
		
