package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUsuario {

    // Método que verifica se o login e senha informados existem no banco
    public Usuario verificarLogin(String loginDigitado, String senhaDigitada) {

        // SQL para buscar o usuário pelo login
        String sql = "SELECT * FROM usuario WHERE login = ?";

        try (Connection conn = ConexaoDB.conectar(); // Abre conexão com o banco
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepara o SQL

            stmt.setString(1, loginDigitado); // Define o parâmetro "?" com o login informado
            ResultSet rs = stmt.executeQuery(); // Executa a consulta

            if (!rs.next()) {
                // Se não encontrou nenhum resultado, o login não existe
                return null;
            }

            // Recupera a senha do usuário encontrado no banco
            String senhaCorreta = rs.getString("senha");

            // Compara a senha digitada com a do banco
            if (senhaCorreta.equals(senhaDigitada)) {
                // Se for igual, cria um objeto Usuario com os dados
            	Usuario usuario = new Usuario(rs.getString("nome"), rs.getString("login"), rs.getString("senha"));
                usuario.setId(rs.getInt("id")); // Define o ID do usuário
                return usuario; // Login bem-sucedido
            } else {
                return null; // Senha incorreta
            }

        } catch (SQLException e) {
            // Caso ocorra algum erro na conexão ou SQL
            e.printStackTrace();
            return null;
        }
    }
}
