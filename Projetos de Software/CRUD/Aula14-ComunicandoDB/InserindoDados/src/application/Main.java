package application;

import Controller.TelaHomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Home");
			primaryStage.resizableProperty().setValue(Boolean.FALSE);

			// Carregar tela
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Home.fxml"));
			Parent arquivoXML = loader.load();

			// Cena
			Scene home = new Scene(arquivoXML);
			primaryStage.setScene(home);

			TelaHomeController homeController = loader.getController();

			primaryStage.setOnCloseRequest(e -> {
				if (homeController.onCloseQuery()) {
					System.exit(0);
				} else {
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
