package principal;
import java.util.Scanner;

import entidades.Livro;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe os dados do livro");
		System.out.print("Livro: ");
		String livro = sc.nextLine();
		System.out.print("Autor: ");
		String autor = sc.nextLine();

		Livro harry = new Livro(livro, autor);
		System.out.println(harry.toString());

		
		System.out.print("Valor: ");
		double valor = sc.nextDouble();
		harry.setValor(valor);		
		System.out.println(harry.toString());
		harry.devolveLivro(10);
		System.out.println("Quantidade: " + harry.getQuantidade());
		
		harry.emprestaLivro(50);
		System.out.println("Quantidade: " + harry.getQuantidade());
		
		
		
		sc.close();

	}

}
