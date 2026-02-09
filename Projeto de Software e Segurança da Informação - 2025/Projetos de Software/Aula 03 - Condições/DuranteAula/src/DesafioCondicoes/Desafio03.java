package DesafioCondicoes;

import java.util.Scanner;

public class Desafio03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int numMaq = (int) Math.random() * 10;
		System.out.println(numMaq);
		
		
		System.out.println("Informe um número entre 0 a 10: ");
		int numUser = sc.nextInt();
		sc.nextLine();
		
		
		if (numMaq == numUser) {
			System.out.println("Você acertou parabens");
		}
		else {
			System.out.println("Tente novamente");
		}
		
		sc.close();
	}

}
