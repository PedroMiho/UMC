package GerenciamentoLivros;

import java.util.Scanner;

import Entidades.Livro;

public class ProgramaLivro {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Informe os dados do livro: ");
		System.out.print("Livro: ");
		String nomeLivro = sc.nextLine();
		
		System.out.print("Autor: ");
		String autor = sc.nextLine();
			
		System.out.print("Valor: ");
		double valor = sc.nextDouble();
			
		Livro livro = new Livro(nomeLivro, autor, valor);
		
		System.out.println(livro);
		
		System.out.print("Informe a quantidade de livros que deseja devolver: ");
		int quantidade = sc.nextInt();
		livro.devolveLivro(quantidade);
		System.out.println("Dados atualizados: " + livro);
		
		System.out.print("Informe a quantidade de livros que deseja emprestar: ");
		quantidade = sc.nextInt();
		livro.emprestaLivro(quantidade);
		System.out.println("Dados atualizados: " + livro);
		
		
		
		sc.close();
	}

}
