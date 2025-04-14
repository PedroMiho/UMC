package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexao.Conexao;
import entidades.Usuario;

public class UsuarioDAO {
	
	public void cadastrarUsuario(Usuario Usuario) {
		String sql = "INSERT INTO USUARIO (id, nome, email, senha) VALUES (?,?,?,?)";
		
		PreparedStatement ps = null;
		
		try {
			ps = Conexao.getConexao().prepareStatement(sql);
			ps.setInt(1, Usuario.getId());
			ps.setString(2, Usuario.getNome());
			ps.setString(3, Usuario.getEmail());
			ps.setString(4, Usuario.getSenha());
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
