package desafios;
import java.util.Scanner;

public class Desafio01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escreva a temperatura em graus celsius: ");
		double tempCelsius = sc.nextDouble();
		
		double tempFahr = (tempCelsius * 9/5) + 32;
		double tempKelvin = tempCelsius + 273.15;
		
		System.out.println("A temperatura em Fahrenheit é igual a " + tempFahr );
		System.out.println("A temperatura em Kelvin é igual a " + tempKelvin );
		
		sc.close();

	}

}
