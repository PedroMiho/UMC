package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUsuario {

	// Criar um método que retornará o objeto usuário ou null

	public Usuario verificarLogin(String login, String senha) throws SQLException {

		// SQL para buscar o usuário pelo login
		String sql = "SELECT * FROM usuario WHERE login = ?";

		// O bloco try-catch garante que erros de conexão ou execução sejam tratados
		// adequadamente.
		try (Connection conn = ConexaoDB.conectar(); // Abre conexão com o banco
				PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepara a consulta SQL

			// Define o parâmetro "?" com o login informado
			stmt.setString(1, login);

			// Executa a consulta SQL e armazena o resultado na variável 'rs' para leitura
			// dos dados retornados do banco
			ResultSet rs = stmt.executeQuery();

			// A condição if verifica se a consulta SQL não retornou nenhum resultado.
			if (!rs.next()) {
				return null;
			}

			// Recupera a senha do usuário encontrado no banco
			String senhaDB = rs.getString("senha");

			// Compara a senha digitada com a do banco

			if (senha.equals(senhaDB)) {
				// Instancia o objeto Usuario com os dados retornados do banco de dados
				Usuario usuario = new Usuario(rs.getInt("id"), rs.getString("login"), rs.getString("nome"),
						rs.getString("senha"));
				return usuario;
			}else {
				return null;
			}

		} catch (SQLException e) {
			//Caso ocorra algum erro de conexão com o Banco de Dados
			e.getMessage();
			return null;
		}

	}

}
