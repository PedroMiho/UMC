package org.example.model;


import org.example.entidades.Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PagamentoCreateDAO {
    public void inserir(Pagamento pagamento) {
        String sql = "INSERT INTO pagamentos (nomeCliente, valor, data) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pagamento.getNomeCliente());
            stmt.setDouble(2, pagamento.getValor());
            stmt.setString(3, pagamento.getData());

            stmt.executeUpdate();
            System.out.println("✅ Pagamento inserido com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
