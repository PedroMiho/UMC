import entidades.GerenciarProdutos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GerenciarProdutos gerenciarProdutos = new GerenciarProdutos();

        while (true) {
            System.out.println("-----LISTA DE OPÇÕES-----");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Excluir Produto");
            System.out.println("5 - Sair do Programa");
            System.out.print("Digite a opção desejada: ");
            String opcao = sc.nextLine();

            switch (opcao) {
                case "1" -> {

                }


            }


        }

    }
}
