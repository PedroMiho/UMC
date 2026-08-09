package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.Alert;

public class CadastrarUsuario {

	// Método responsável por registrar um novo usuário
	public void cadastrarUsuario(Usuario usuario) throws SQLException {

		// Comando SQL para inserir dados na tabela usuário
		String sql = "INSERT INTO usuario (id,login,nome,senha) VALUES (?,?,?,?)";

		// O bloco try-catch garante que erros de conexão ou execução sejam tratados
		// adequadamente.

		try (Connection conn = ConexaoDB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			// Substituir os ? pelos dados do objeto Usuario
			stmt.setInt(1, usuario.getId());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getNome());
			stmt.setString(4, usuario.getSenha());

			// Executa o comando SQL no banco de dados
			stmt.executeUpdate();

			// Cria uma tela caso o cadastro tenha sido feito com sucesso
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Cadastro Realizado");
			alert.setHeaderText("Usuário cadastrado com sucesso");
			alert.setContentText("O novo usuário foi inserido no sistema");
			alert.showAndWait();

		} catch (SQLException e) {
			// Cria uma tela caso o cadastro tenha dado algum erro
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erro Cadastro");
			alert.setHeaderText("Login já existente");
			alert.setContentText("Este login já está sendo utilizando tente outro");
			alert.showAndWait();
		}

	}

}
