package model;

// Importações necessárias para a conexão com o banco
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {

    // URL de conexão com o banco de dados MySQL. Inclui o nome do banco (sistema)
    private static final String URL = "jdbc:mysql://localhost:3306/sistema";

    // Nome de usuário e senha do banco
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método estático que retorna uma conexão com o banco de dados
    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
