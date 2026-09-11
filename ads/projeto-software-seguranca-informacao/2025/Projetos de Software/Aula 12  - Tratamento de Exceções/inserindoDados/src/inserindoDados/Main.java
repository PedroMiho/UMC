
//CREATE DATABASE sistema;
//USE sistema;
//
//CREATE TABLE usuario (
//    nome varchar (50),
//    email varchar (50) unique,
//    senha varchar (10)
//);
//
//DROP TABLE usuario;
//
//SELECT * FROM usuario;

package inserindoDados;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            // Criar um novo objeto Usuario
            Usuario usuario = new Usuario("João Silva", "joao.silva@email.com", "12345");

            // Chama o método para cadastrar o usuário
            CadastroUsuario.cadastrarUsuario(usuario);
        } catch (SQLException e) {
            // Tratar exceções caso ocorram erros durante a conexão ou inserção
            System.out.println("Erro ao cadastrar o usuário: " + e.getMessage());
        }
    }
}
