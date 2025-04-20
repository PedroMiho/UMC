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
import model.CadastrarUsuario;
import model.Usuario;

//Controller responsavel por comunicar com o model cadastrarUsuario e criar uma conta para o usuario
public class TelaCadastroController {
    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnVoltar;

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSenha;

    @FXML
    void OnClickCadastrar(ActionEvent event) {
    	try {
            String nome = this.txtNome.getText();
            String login = this.txtLogin.getText();
            String senha = this.txtSenha.getText();

            // Enviar para o banco
            Usuario novoUsuario = new Usuario(nome, login, senha);
            
            CadastrarUsuario cadastrarUsuario = new CadastrarUsuario();
            cadastrarUsuario.cadastrarUsuario(novoUsuario);

        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter número: " + e.getMessage());
        }
    }

    @FXML
	void OnClickVoltar(ActionEvent event) throws IOException {
	    	
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Home.fxml"));
        Pane pane = loader.load();
	
        // Obter o stage atual

        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
	
	        
        // Definir a nova cena para o stage atual
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Home");
        stage.show();
	
    }

}


