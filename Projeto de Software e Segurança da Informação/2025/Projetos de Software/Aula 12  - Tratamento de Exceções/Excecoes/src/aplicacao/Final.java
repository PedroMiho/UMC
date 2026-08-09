package aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Final {
	public static void main(String[] args) {
		try {
			conectarBanco();
		} catch (SQLException e) {
			System.out.println("Erro ao tentar se conectar ao banco: " + e.getMessage());
		}

		// A execução continua após o erro
		System.out.println("O código continua executando depois do erro!");
	}

	// O método conecta ao banco e pode lançar uma SQLException, então usamos
	// "throws"
	public static void conectarBanco() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/sistema";
		String usuario = "root";
		String senha = "admin";

		// Tentando conectar ao banco
		Connection conexao = DriverManager.getConnection(url, usuario, senha);

		// Se a conexão for bem-sucedida
		System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
	}
}