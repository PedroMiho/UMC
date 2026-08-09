package repeticoes;

import java.util.Scanner;

public class RepeticoesFor {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Digite um número: ");
		int numero = sc.nextInt();
		
		for (int i = 1; i <= 10; i++) {
			System.out.println(numero + "*" + i + "=" + i*numero);
		}
		
		//Descobrindo numeros impares e multiplos de 3 de 0 a 500
		int soma = 0;
		
		for (int i = 0; i<=500; i++) {
			if (i % 2 == 1 && i % 3 == 0) {
				System.out.println(i);
				soma += i;
			}
		}
		System.out.println(soma);
		sc.close();
	}
	
}
