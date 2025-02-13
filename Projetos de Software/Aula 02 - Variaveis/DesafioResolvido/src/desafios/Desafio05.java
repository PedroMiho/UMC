package desafios;

import java.util.Scanner;

public class Desafio05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o raio do circulo em metros: ");
		double raio = sc.nextDouble();
		
		double perimetro = 2 * Math.PI * raio;
		double area = Math.PI * Math.pow(raio, 2);
		
		System.out.printf("O perimetro do circulo é igual a %.2f m %n", perimetro);
		System.out.printf("A area do circulos é igual a %.2f m² %n", area);
		
		sc.close();

	}

}
