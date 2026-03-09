import entidades.Lanche;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lanche x_burgues = new Lanche("X-burguer", "Pão, hamburguer", 19.90, 10);
        Scanner sc = new Scanner(System.in);

        while (true){

            System.out.println("INFORME A OPÇÃO DESEJADA");
            System.out.println("1 - FAZER PEDIDO");
            System.out.println("2 - ADICIONAR LANCHE AO ESTOQUE");
            System.out.println("3 - VER INFORMAÇÕES DO LANCHE");
            System.out.println("4 - ALTERAR DESCRIÇÃO DO LANCHE: ");
            System.out.println("5 - ALTERAR VALOR DO LANCHE: ");
            System.out.println("6 - SAIR DO PROGRAMA");
            System.out.print("Informe a opção desejada: ");
            String opcao = sc.nextLine();

            switch (opcao) {

                case "1" :
                    System.out.print("Informe a quantidade desejada: ");
                    int quantidadePedida = sc.nextInt();
                    sc.nextLine();
                    x_burgues.decrementaQuantidade(quantidadePedida);

                break;

                case "2":
                    System.out.print("Informe a quantidade desejada: ");
                    int quantidadeEstoque = sc.nextInt();
                    sc.nextLine();
                    x_burgues.incrementarQuantiodade(quantidadeEstoque);
                    System.out.println("Valor Incrementado, estoque igual a " + x_burgues.getEstoque());
                    break;

                case "3":
                    System.out.println(x_burgues);
                    break;
            }




        }




    }
}
