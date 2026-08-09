package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CadastroController {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void OnClickCadastrar(ActionEvent event) {

    }

    @FXML
    void onClickVoltar(ActionEvent event) throws IOException {
    	AlterarTelaController.mudarTela(event, "/view/telaHome.fxml", "Tela Home");
    }


}

