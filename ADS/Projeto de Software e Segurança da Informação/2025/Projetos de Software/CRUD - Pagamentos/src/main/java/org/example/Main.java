package org.example;

import org.example.entidades.Pagamento;
import org.example.model.PagamentoCreateDAO;
import org.example.model.PagamentoReadDAO;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (true){

            System.out.println("INFORME O QUE DESEJA FAZER ?");
            System.out.println("1 - Registrar pagamentos");
            System.out.println("2 - Consultar Pagamentos");
            System.out.println("3 - Para sair ");
            String opcao = sc.nextLine();

            if (opcao.equals("1")){
                System.out.print("Digite o nome do cliente: ");
                String nomeCliente = sc.nextLine();
                System.out.print("Digite a data de pagamento (AAAA-MM-DD): ");
                String dataPagamento = sc.nextLine();
                System.out.print("Digite o valor de pagamento: ");
                double valor = sc.nextDouble();
                sc.nextLine(); // limpar buffer

                Pagamento p1 = new Pagamento(nomeCliente, valor, dataPagamento);
                PagamentoCreateDAO dao = new PagamentoCreateDAO();
                dao.inserir(p1);
            }

            else if (opcao.equals("2")){
                PagamentoReadDAO dao = new PagamentoReadDAO();
                List<Pagamento> pagamentos = dao.listarPagamentos();

                if (pagamentos.isEmpty()) {
                    System.out.println("⚠️ Nenhum pagamento encontrado.");
                } else {
                    System.out.println("=== LISTA DE PAGAMENTOS ===");
                    for (Pagamento p : pagamentos) {
                        System.out.println("ID: " + p.getId() +
                                " | Cliente: " + p.getNomeCliente() +
                                " | Valor: " + p.getValor() +
                                " | Data: " + p.getData());
                    }
                }
            }


            else if (opcao.equals("3")){
                break;
            }
        }
        sc.close();
    }
}
