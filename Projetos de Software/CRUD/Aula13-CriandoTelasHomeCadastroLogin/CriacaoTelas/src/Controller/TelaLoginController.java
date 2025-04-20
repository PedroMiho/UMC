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


