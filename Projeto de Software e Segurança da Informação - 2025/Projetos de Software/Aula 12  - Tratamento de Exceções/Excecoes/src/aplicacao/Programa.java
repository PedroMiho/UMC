package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {			
			System.out.println("Digite nomes e separe ele com espaço: ");
			String[] vetor = sc.nextLine().split(" ");
			System.out.println("Informe a posição que deseja buscar: ");
			int posicao = sc.nextInt();
			System.out.println(vetor[posicao]);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Posição Inválida");
			e.printStackTrace();
			sc.next();
		}
		catch (InputMismatchException e) {
			System.out.println("Entrada inválida");
			e.printStackTrace();
			sc.next();
		}
		
		System.out.println("FIM DO PROGRAMA");
		
		sc.close();

	}

}
