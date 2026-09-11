package controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.LoginUsuario;
import model.Usuario;

public class LoginController {

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void OnClickEntrar(ActionEvent event) throws SQLException, IOException {
    	
    	String login = this.txtLogin.getText();
    	String senha = this.txtSenha.getText();
    	
    	LoginUsuario loginUsuario = new LoginUsuario();
    	Usuario usuario = loginUsuario.verificarLogin(login, senha);
    	
    	if (usuario != null) {
    		AlterarTelaController.mudarTela(event, "/view/TelaUsuario.fxml", "Tela Usuário");
    	} else {
    		// Cria uma tela caso o cadastro tenha dado algum erro
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Erro de Login");
			alert.setHeaderText("Login ou Senha Incorretos");
			alert.setContentText("Por favor, verifique suas credenciais e tente novamente.");
			alert.showAndWait();
    		
    	}
    	
    }

    @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
    	AlterarTelaController.mudarTela(event, "/view/TelaHome.fxml", "Tela Home");
    }

}
