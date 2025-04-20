package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

//Controller responsavel por verificar se o usuario quer criar uma conta ou acessar uma conta ja existente
public class TelaHomeController implements Initializable {

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnEntrar;

    @FXML
    void onClickCadastrar(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/TelaCadastro.fxml"));
        Pane pane = loader.load();

     // Obter o stage atual
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        
        // Definir a nova cena para o stage atual
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Tela de Cadastro");
        stage.show();
    }

    @FXML
    void onClickEntrar(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/TelaLogin.fxml"));
        Pane pane = loader.load();

        // Obter o stage atual
     // Obter o stage atual
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        
        // Definir a nova cena para o stage atual
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Tela de Login");
        stage.show();
    }
    
    public boolean onCloseQuery() {
 		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
 		alerta.setTitle("Pergunta");
 		alerta.setHeaderText("Deseja sair do sistema ?");
 		ButtonType botaoNao = ButtonType.NO;
 		ButtonType botaoSim = ButtonType.YES;
 		alerta.getButtonTypes().setAll(botaoSim, botaoNao);
 		Optional<ButtonType> opcaoClicada = alerta.showAndWait();
 		
 		return opcaoClicada.get() == botaoSim ? true : false;
 	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	

}
