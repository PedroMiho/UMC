package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUsuario {
    public Usuario verificarLogin(String loginDigitado, String senhaDigitada) {
        String sql = "SELECT * FROM usuario WHERE login = ?";

        try (Connection conn = ConexaoDB.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, loginDigitado);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                return null; // Login não encontrado
            }

            String senhaCorreta = rs.getString("senha");
            if (senhaCorreta.equals(senhaDigitada)) {
                // Cria o objeto Usuario
            	Usuario usuario = new Usuario(rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
                usuario.setId(rs.getInt("id"));
                return usuario;
            } else {
                return null; // Senha incorreta
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}