package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlterarTelaController {

	// Função para mudar a cena ao clicar no botão
	// Função global para mudar de tela
	public static void mudarTela(ActionEvent event, String telaFXML, String titulo) throws IOException {
		// Carregar o novo arquivo FXML (a nova tela que você deseja exibir)
		FXMLLoader loader = new FXMLLoader(AlterarTelaController.class.getResource(telaFXML));
		Parent root = loader.load();

		// Obter o 'Stage' atual (janela)
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

		// Definir a nova cena para o 'stage'
		Scene scene = new Scene(root);

		// Definir o título da janela (opcional)
		stage.setTitle(titulo);

		// Atualizar a cena e mostrar a janela com o novo conteúdo
		stage.setScene(scene);
		stage.show();
	}
}