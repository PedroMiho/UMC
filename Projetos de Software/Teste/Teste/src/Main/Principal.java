package Main;

import dao.UsuarioDAO;
import entidades.Usuario;

public class Principal {

	public static void main(String[] args) {
		Usuario pedro = new Usuario();
		pedro.setId(0);
		pedro.setNome("Pedro");
		pedro.setEmail("pedromiho@gmail.com");
		pedro.setSenha("1234");
		
		new UsuarioDAO().cadastrarUsuario(pedro);
		
	}

}
