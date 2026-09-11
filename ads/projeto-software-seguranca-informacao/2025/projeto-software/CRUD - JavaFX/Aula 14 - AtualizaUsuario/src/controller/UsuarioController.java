package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.AtualizaDados;
import model.ExcluirUsuario;
import model.Usuario;

public class UsuarioController {

	@FXML
	private TextField txtLogin;

	@FXML
	private TextField txtNome;

	@FXML
	private PasswordField txtSenha;

	private Usuario usuarioAtual;

	public void receberUsuario(Usuario usuario) {
		this.usuarioAtual = usuario;
		txtLogin.setText(usuario.getLogin());
		txtNome.setText(usuario.getNome());
		txtSenha.setText(usuario.getSenha());
	}

	@FXML
	void OnClickAtualizar(ActionEvent event) {

		// Capturando os novos dados do usuário
		String novoNome = txtNome.getText();
		String novoLogin = txtLogin.getText();
		String novaSenha = txtSenha.getText();

		// Capturando os dados antigos do usuario
		String loginAntigo = usuarioAtual.getLogin();

		// Atualizando os Dados do Usuario
		usuarioAtual.setLogin(novoLogin);
		usuarioAtual.setNome(novoNome);
		usuarioAtual.setSenha(novaSenha);

		// Chamar a classe para salvar no banco
		AtualizaDados dadosAtualizados = new AtualizaDados();
		boolean sucesso = dadosAtualizados.AtualizarDados(usuarioAtual, loginAntigo);

		if (sucesso) {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Sucesso");
			alert.setContentText("Dados atualizados com sucesso!");
			alert.showAndWait();

		}
	}

	@FXML
	void OnClickExcluir(ActionEvent event) throws IOException {
		String loginAntigo = usuarioAtual.getLogin();

		ExcluirUsuario excluir = new ExcluirUsuario();
		boolean sucesso = excluir.deletarUsuario(loginAntigo);

		if (sucesso) {
			// Cria uma tela caso o cadastro tenha sido feito com sucesso
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Cadastro Excluído");
			alert.setHeaderText("O cadastro do usuário foi excluído com sucesso");
			alert.showAndWait();
			AlterarTelaController.mudarTela(event, "/view/TelaHome.fxml", "Tela Home");
		} else {
			System.out.println("Erro ao excluir o cadastro");
		}

	}

	@FXML
	void onClickVoltar(ActionEvent event) throws IOException {
		AlterarTelaController.mudarTela(event, "/view/TelaLogin.fxml", "Tela Login");
	}

}
