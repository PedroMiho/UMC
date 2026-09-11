package DesafioCondicoes;

import java.util.Scanner;

public class Desafio01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe a sua nota: ");
		double nota = sc.nextDouble();
		
		if (nota < 5) {
			System.out.println("Reprovado - Precisa melhorar muito");
		}
		
		else if (nota < 7) {
			System.out.println("Recuperação - Dedicacao e necessaria");
		}
		
		else if (nota < 9) {
			System.out.println("Aprovado -  Desempenho Satisfatorio");
		}
		
		else if (nota < 10) {
			System.out.println("Aprovado com Distinção - Excelente");
		}
		
		else {
			System.out.println("Informe uma nota menor que 10");
		}
		
		sc.close();

	}

}
