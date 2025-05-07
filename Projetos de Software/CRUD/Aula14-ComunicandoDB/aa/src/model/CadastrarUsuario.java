package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastrarUsuario {

    // Método que insere um novo usuário no banco de dados
	public void cadastrarUsuario(Usuario usuario) {
        
        // SQL para inserir dados na tabela usuario
        String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";

        // Bloco try-with-resources para garantir que a conexão será fechada
        try (Connection conn = ConexaoDB.conectar(); // Abre a conexão
             PreparedStatement stmt = conn.prepareStatement(sql)) { // Prepara a instrução SQL

            // Substitui os "?" pelos dados do objeto Usuario
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getLogin());
            stmt.setString(3, usuario.getSenha());

            // Executa o comando SQL no banco de dados
            stmt.executeUpdate();

        } catch (SQLException e) {
            // Em caso de erro, imprime a exceção
            e.printStackTrace();
        }
    }
}

//String checkLoginSql = "SELECT COUNT(*) FROM usuario WHERE login = ?";
//String insertSql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";
//
//try (Connection conn = ConexaoDB.conectar()) {
//    // Verifica se o login já está em uso
//    try (PreparedStatement checkStmt = conn.prepareStatement(checkLoginSql)) {
//        checkStmt.setString(1, login);
//        try (ResultSet rs = checkStmt.executeQuery()) {
//            if (rs.next() && rs.getInt(1) > 0) {
//                System.out.println("Erro: Login já está em uso.");
//                return; // Aborta o cadastro caso o login já exista
//            }
//        }
//    }
//
//    // Se o login não existe, insere o novo usuário
//    try (PreparedStatement stmt = conn.prepareStatement(insertSql)) {
//        stmt.setString(1, nome);
//        stmt.setString(2, login);
//        stmt.setString(3, senha);
//
//        int rowsAffected = stmt.executeUpdate();
//        if (rowsAffected > 0) {
//            System.out.println("Usuário cadastrado com sucesso!");
//        } else {
//            System.out.println("Erro ao cadastrar o usuário.");
//        }
//    }
