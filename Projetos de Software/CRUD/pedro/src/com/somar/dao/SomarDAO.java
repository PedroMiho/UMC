package com.somar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SomarDAO {

    public void inserirSoma(double valor1, double valor2, double resultado) {
        String sql = "INSERT INTO usuario (n1, n2, resultado) VALUES (?, ?, ?)";

        try (Connection conn = ConexaoBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, valor1);
            stmt.setDouble(2, valor2);
            stmt.setDouble(3, resultado);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
