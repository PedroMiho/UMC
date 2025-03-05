package repeticoes;

import java.util.Scanner;

public class RepeticaoWhile {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int maquina = (int) (10 * Math.random());
		int usuario;
		
		System.out.println((maquina));
		
		do {
			System.out.print("Informe um número entre 0 a 9: " );
			usuario = sc.nextInt();
		} while (maquina != usuario);
		
		System.out.println("Parabens você venceu");

		
		
		sc.close();
	}

}
