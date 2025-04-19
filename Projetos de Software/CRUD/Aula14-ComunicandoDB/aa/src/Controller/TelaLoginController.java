package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.LoginUsuario;

public class TelaLoginController {

	@FXML
    private Button btnEntrar;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    void OnClickEntrar(ActionEvent event) {
    	try {
            String login = this.txtLogin.getText();
            String senha = this.txtSenha.getText();

            // Enviar para o banco
            LoginUsuario loginUsuario = new LoginUsuario();
            String resultado = loginUsuario.verificarLogin(login, senha);
          
            
            if (resultado.equals("sucesso")) {
                System.out.println("✅ Login realizado com sucesso! Bem-vindo, " + login + "!");
                
            } else {
                System.out.println("⚠️ " + resultado); // Exibe erro como "Senha inválida" ou "Login não encontrado"
            }

        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter número: " + e.getMessage());
        }
    }

    @FXML
    void OnClickVoltar(ActionEvent event) throws IOException {
    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Home.fxml"));
        Pane pane = loader.load();

        // Obter o stage atual
     // Obter o stage atual
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        
        // Definir a nova cena para o stage atual
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();

    }
}


