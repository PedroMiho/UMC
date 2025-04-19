package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUsuario {
    public String verificarLogin(String loginDigitado, String senhaDigitada) {
        String sql = "SELECT senha FROM usuario WHERE login = ?";

        try (Connection conn = ConexaoDB.conectar();
            //Abre uma conexão com o banco de dados
    		PreparedStatement stmt = conn.prepareStatement(sql)) {
        	
        	//Substitui o ? da query pelo valor do login digitado.
            stmt.setString(1, loginDigitado);
            //Executa a consulta e guarda o resultado no ResultSet.
            ResultSet rs = stmt.executeQuery();
            
            //Verifica se o login existe, caso não exista retorna essa mensagem
            if (!rs.next()) {
                return "Login não encontrado.";
            }
            
            //Recupera a senha correspondente ao login digitado no banco
            String senhaCorreta = rs.getString("senha");
            
            
            // Verifica a senha salva no banco de dados com a senha digitada
            if (senhaCorreta.equals(senhaDigitada)) {
                return "sucesso"; // tudo certo
            } else {
                return "Senha inválida.";
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro ao acessar o banco.";
        }
    }
}
