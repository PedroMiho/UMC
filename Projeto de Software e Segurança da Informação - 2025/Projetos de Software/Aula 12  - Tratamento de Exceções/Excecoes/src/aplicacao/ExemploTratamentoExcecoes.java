package aplicacao;

import java.io.*;
import java.sql.*;

public class ExemploTratamentoExcecoes {

    public static void main(String[] args) {
        // Exemplo NullPointerException
        try {
            String str = null;
            System.out.println(str.length());  // Lança NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Erro: Tentativa de acessar um objeto nulo.");
        }

        // Exemplo ArrayIndexOutOfBoundsException
        try {
            int[] arr = new int[5];
            System.out.println(arr[10]);  // Lança ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: Índice fora do limite do array.");
        }

        // Exemplo ArithmeticException
        try {
            int resultado = 10 / 0;  // Lança ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Erro: Não é possível dividir por zero.");
        }

        // Exemplo ClassNotFoundException
        try {
            Class.forName("com.exemplo.MinhaClasse");  // Lança ClassNotFoundException se a classe não for encontrada
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Classe não encontrada.");
        }

        // Exemplo FileNotFoundException
        try {
            File file = new File("arquivo_inexistente.txt");
            FileReader fr = new FileReader(file);  // Lança FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo não encontrado.");
        }

        // Exemplo IOException
        try {
            BufferedReader reader = new BufferedReader(new FileReader("arquivo.txt"));
            String linha = reader.readLine();  // Pode lançar IOException
        } catch (IOException e) {
            System.out.println("Erro: Falha na operação de entrada/saída.");
        }

        // Exemplo SQLException
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/meubanco", "root", "senha");
            // Pode lançar SQLException se houver erro de conexão
        } catch (SQLException e) {
            System.out.println("Erro: Problema de conexão com o banco de dados.");
        }

        // Exemplo NumberFormatException
        try {
            String numero = "abc";
            int num = Integer.parseInt(numero);  // Lança NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("Erro: Formato de número inválido.");
        }finally {
			System.out.println("FIM");
		}
        
     
        
        

    }
}
