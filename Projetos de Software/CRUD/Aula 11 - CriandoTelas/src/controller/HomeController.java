package controller;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class HomeController {

	@FXML
	void OnClickCadastrar(ActionEvent event) throws IOException {	
		AlterarTelaController.mudarTela(event, "/view/telaCadastro.fxml", "Tela de Cadastro");
		
	}

	@FXML
	void OnClickEntrar(ActionEvent event) throws IOException {
		AlterarTelaController.mudarTela(event, "/view/telaLogin.fxml", "Tela de Login");
	}

	// Método que exibe uma caixa de confirmação antes de fechar o sistema
	public boolean onCloseQuery() {

		// Cria um alerta do tipo CONFIRMATION (confirmação)
		Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);

		// Define o título da janela do alerta
		alerta.setTitle("Confirmação");

		// Define o texto do cabeçalho do alerta
		alerta.setHeaderText("Deseja sair do sistema");

		// Cria um botão "Não" usando o botão padrão do JavaFX
		ButtonType botaoNao = ButtonType.NO;

		// Cria um botão "Sim" usando o botão padrão do JavaFX
		ButtonType botaoSim = ButtonType.YES;

		// Define os botões que aparecerão na caixa de diálogo, na ordem desejada
		alerta.getButtonTypes().setAll(botaoSim, botaoNao);

		// Exibe o alerta e aguarda o usuário clicar em um dos botões
		Optional<ButtonType> opcaoClicada = alerta.showAndWait();

		// Retorna true se o botão clicado for o "Sim", caso contrário retorna false
		return opcaoClicada.get() == botaoSim ? true : false;
	}

}