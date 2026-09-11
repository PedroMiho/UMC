package DesafioCondicoes;

import java.util.Scanner;

public class Desafio02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int velocidadeMax = 90;
		int valorKm = 10;
		
		System.out.println("Informe a velocidade do veiculo: ");
		int velocidadeUser = sc.nextInt();
		sc.nextLine();
		
		if (velocidadeUser > velocidadeMax) {
			int velocidadeExcedida = velocidadeUser - velocidadeMax;
			int multa = velocidadeExcedida * valorKm;
			System.out.println("A multa a ser paga para será de R$ " + multa);
		}
		else {
			System.out.println("Você não terá que pagar multa");
		}
		sc.close();
	}

}
