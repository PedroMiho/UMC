package org.example.model;

import org.example.entidades.Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PagamentoReadDAO {

    public List<Pagamento> listarPagamentos() {
        List<Pagamento> lista = new ArrayList<>();

        String sql = "SELECT * FROM pagamentos";

        try {
            Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pagamento pagamento = new Pagamento(
                        rs.getInt("id"),
                        rs.getDouble("valor"),
                        rs.getString("nomeCliente"),
                        rs.getString("data")
                );

                lista.add(pagamento);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}
