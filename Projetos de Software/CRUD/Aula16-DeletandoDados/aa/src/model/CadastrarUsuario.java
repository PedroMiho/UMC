package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Classe responsavel por cadastrar o usuario no Banco de dados
public class CadastrarUsuario {
	 public void cadastrarUsuario(Usuario usuario) {
	        String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, ?)";

	        try (Connection conn = ConexaoDB.conectar();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, usuario.getNome());
	            stmt.setString(2, usuario.getLogin());
	            stmt.setString(3, usuario.getSenha());

	            stmt.executeUpdate();

	        } catch (SQLException e) {
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
