package application;

import controller.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Titulo Tela
			primaryStage.setTitle("TELA HOME");
			// Definir se a tela pode crescer
			primaryStage.resizableProperty().setValue(Boolean.FALSE);

			// Carregar a tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/TelaHome.fxml"));
			Parent arquivoFxml = loader.load();

			HomeController homeController = loader.getController();

			// Carregar a cena
			Scene home = new Scene(arquivoFxml);
			primaryStage.setScene(home);
			// Define o comportamento quando a janela principal (primaryStage) for fechada
			primaryStage.setOnCloseRequest(e -> {

				// Chama o método onCloseQuery() do controlador (homeController)
				// Se retornar true, significa que o usuário confirmou o fechamento
				if (homeController.onCloseQuery()) {

					// Encerra o programa completamente
					System.exit(0);
				} else {

					// Impede o fechamento da janela (cancela o evento de fechar)
					e.consume();
				}

			});

			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
