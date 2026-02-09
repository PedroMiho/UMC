package inserindoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroUsuario {

	// Método para realizar a conexão com o banco de dados
	public static Connection conectar() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/sistema"; // URL do banco de dados
		String usuario = "root"; // Usuário do banco de dados
		String senha = "admin"; // Senha do banco de dados
		return DriverManager.getConnection(url, usuario, senha); // Estabelece a conexão
	}

	// Método para cadastrar um usuário
	public static void cadastrarUsuario(Usuario usuario) throws SQLException {
		// Conectar ao banco de dados
		Connection conn = conectar();

		// SQL de inserção
		String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";

		// Preparar a consulta
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// Definir os parâmetros da consulta a partir do objeto usuario
		pstmt.setString(1, usuario.getNome()); // Definir o nome
		pstmt.setString(2, usuario.getEmail()); // Definir o email
		pstmt.setString(3, usuario.getSenha()); // Definir a senha

		// Executar a consulta
		pstmt.executeUpdate(); // Realiza a inserção no banco de dados

		// Fechar a conexão
		pstmt.close();
		conn.close();

		System.out.println("Usuário cadastrado com sucesso!");
	}
}
