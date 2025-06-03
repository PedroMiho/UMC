package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.scene.control.Alert;

public class AtualizaDados {
	
	public boolean AtualizarDados(Usuario usuario, String login) {
		
		// SQL para atualizar os dados do usuário
		
		String sql = "UPDATE usuario SET nome = ?, login = ?, senha = ? WHERE login = ?";
		
		try (Connection conn = ConexaoDB.conectar()){
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getLogin());
			stmt.setString(3, usuario.getSenha());
			stmt.setString(4, login);
			
			
			int linhas = stmt.executeUpdate();
			return linhas > 0;
			
		} catch (SQLException e) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erro atualizar os Dados");
			alert.setHeaderText("O login já existe no banco de dados");
			alert.setContentText("Por favor, verifique suas credenciais e tente novamente.");
			alert.showAndWait();
			return false;
		}
		
	}
	
}
