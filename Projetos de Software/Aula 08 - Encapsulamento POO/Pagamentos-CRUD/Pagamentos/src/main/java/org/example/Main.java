package org.example;

import org.example.Model.Pagamento;
import org.example.Model.PagamentoCreateDAO;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true){

            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = sc.nextLine();
            System.out.print("Digite a data de pagamento: ");
            String dataPagamento = sc.nextLine();
            System.out.print("Digite o valor de pagamento: ");
            double valor = sc.nextDouble();
            sc.nextLine();

            Pagamento p1 = new Pagamento(nomeCliente, valor, dataPagamento);
            PagamentoCreateDAO dao = new PagamentoCreateDAO();
            dao.inserir(p1);

            System.out.print("Deseja Continuar [S/N]: ");
            String continuar = sc.nextLine();
            if (continuar.equalsIgnoreCase("N")){
                break;
            }

        }

    }
}
