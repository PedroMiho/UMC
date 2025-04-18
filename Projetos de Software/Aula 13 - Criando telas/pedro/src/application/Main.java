package application;
	
import com.somar.controller.SomarController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class Main extends Application {
	

	@Override
	public void start(Stage primaryStage) {
		
		try {
			//Configurtando Dados da tela
			primaryStage.setTitle("Somar Números");
			primaryStage.resizableProperty().setValue(Boolean.FALSE);
			
			//Carregando a tela 
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/TelaCadastro.fxml"));
			Parent arquivoXML = loader.load();
			
			//Cena 
			Scene somarCena = new Scene(arquivoXML);
			primaryStage.setScene(somarCena);
			
			//Carregando o controller da cena
			SomarController somarController = loader.getController();
			
			//aTRIBUIR EVENTO DE FECHAR TELA
			primaryStage.setOnCloseRequest( e -> {
				if (somarController.onCloseQuery()) {
					System.exit(0);
				}
				else {
					e.consume();
				}
			});
			
			primaryStage.show();
			 
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
