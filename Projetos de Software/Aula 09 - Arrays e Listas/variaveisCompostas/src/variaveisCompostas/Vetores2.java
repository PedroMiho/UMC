package variaveisCompostas;

import java.util.Scanner;

public class Vetores2 {

	public static void main(String[] args) {
		
		double [] notasAlunos = new double [3];
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < notasAlunos.length; i++) {
			System.out.println("Digite uma nota entre 0 a 10");
			double nota = sc.nextDouble();
			if (nota >= 0 && nota <=10) {
				notasAlunos[i] = nota;
			}
			else {
				i--;
				System.out.println("Valor Inválido");
			}
		}
		
		for (double notas : notasAlunos ) {
			System.out.println(notas);
		}
		
		sc.close();
	}

}
