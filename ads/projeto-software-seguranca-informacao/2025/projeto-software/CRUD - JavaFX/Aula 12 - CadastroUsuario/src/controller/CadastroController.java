package controller;

import java.io.IOException;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.CadastrarUsuario;
import model.Usuario;

public class CadastroController {

	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtNome;

	@FXML
	private PasswordField txtSenha;

	@FXML
	void OnClickCadastrar(ActionEvent event) {

		// Criando um bloco try-catch para tratamento de exceções
		try {
			int id = (int) (Math.random() * 100);
			String login = this.txtLogin.getText();
			String nome = this.txtNome.getText();
			String senha = this.txtSenha.getText();

			// Instancia o objeto usuario
			Usuario novoUsuario = new Usuario(id, login, nome, senha);
			
			// Instancia a classe cadastrarUsuario
			CadastrarUsuario cadastrarUsuario = new CadastrarUsuario();
			cadastrarUsuario.cadastrarUsuario(novoUsuario);

		} catch (Exception e) {
			System.out.println("Erro, tente novamente");
		}

	}

	@FXML
	void onClickVoltar(ActionEvent event) throws IOException {
		AlterarTelaController.mudarTela(event, "/view/telaHome.fxml", "Tela Home");
	}

}
