package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletarUsuario {

    public boolean deletarUsuario(String login) {
        String sql = "DELETE FROM usuario WHERE login = ?";
        
        try (Connection conn = ConexaoDB.conectar(); 
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, login);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
