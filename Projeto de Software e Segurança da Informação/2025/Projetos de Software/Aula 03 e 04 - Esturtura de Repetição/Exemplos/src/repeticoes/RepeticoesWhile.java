package repeticoes;

import java.util.Scanner;

public class RepeticoesWhile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String loginSalvo = "admin";
		String senhaSalva = "1234";
		String login = "";
		String senha = "";
		
		
		while (!login.toLowerCase().equals(loginSalvo) && !senha.equals(senhaSalva) ) {
			
			System.out.print("Informe o seu login: ");
			login = sc.nextLine();
			
			System.out.print("Informe a sua senha: ");
			senha = sc.nextLine();
			
		}
		
		System.out.println("Acesso Liberado");
		
		sc.close();

	}

}
