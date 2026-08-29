package desafios;

import java.util.Scanner;

public class Desafio03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a nota 01: ");
		double n1 = sc.nextDouble();
		
		System.out.println("Digite a nota 02: ");
		double n2 = sc.nextDouble();
		
		System.out.println("Digite a nota 03: ");
		double n3 = sc.nextDouble();
		
		double media = (n1 + n2 + n3) / 3;
		
		System.out.println("A media do aluno foi " + media);
		
		sc.close();
	}

}
