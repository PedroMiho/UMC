package padrao;

import java.util.Scanner;

public class Leitura {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite seu filme favorito: ");
		String filme = sc.nextLine();
		System.out.println(filme);
		
		
		System.out.println("Digite o ano de lançamento: ");
		int anoLancamento = sc.nextInt();
		System.out.println(anoLancamento);
		sc.close();
	}

}
