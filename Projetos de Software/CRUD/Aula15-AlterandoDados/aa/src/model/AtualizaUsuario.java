package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AtualizaUsuario {
	
	public boolean atualizarUsuario(Usuario usuario) {
	    String sql = "UPDATE usuario SET nome = ?, senha = ? WHERE login = ?";

	    try (Connection conn = ConexaoDB.conectar();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, usuario.getNome());
	        stmt.setString(2, usuario.getSenha());
	        stmt.setString(3, usuario.getLogin());

	        int linhas = stmt.executeUpdate();
	        return linhas > 0;

	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

}
