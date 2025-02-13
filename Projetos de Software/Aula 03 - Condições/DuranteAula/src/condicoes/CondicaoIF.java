package condicoes;

import java.util.Scanner;

public class CondicaoIF {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("Informe a sua idade: ");
		//int idade2 = sc.nextInt();
		//sc.nextLine();
		
		int idade = 18;
		
		if (idade >= 18) {
		    System.out.println("Você é maior de idade.");
		}
		
		else {
			System.out.println("Você é menor de idade.");
		}
		
		sc.close();

	}

}
