package com.somar.controller;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.somar.dao.SomarDAO;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;


public class SomarController implements Initializable {
	
    @FXML
    private Button btnLimpar;

    @FXML
    private Button btnSomar;

    @FXML
    private Label lblNum1;

    @FXML
    private Label lblNum2;

    @FXML
    private Label lblResultado;

    @FXML
    private Label lblResultadoSoma;

    @FXML
    private GridPane painelGrid;

    @FXML
    private AnchorPane painelPrincipal;

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    void onClickLimpar(ActionEvent event) {
    	this.txt1.setText(new String());
    	this.txt2.setText(new String());
    	this.lblResultadoSoma.setText(new String("0"));
    	this.txt1.requestFocus();
    }

    @FXML
    void onClickSomar(ActionEvent event) {
        try {
            double numero1 = Double.parseDouble(this.txt1.getText());
            double numero2 = Double.parseDouble(this.txt2.getText());
            double resultado = numero1 + numero2;

            lblResultadoSoma.setText(String.valueOf(resultado));

            // Enviar para o banco
            SomarDAO dao = new SomarDAO();
            dao.inserirSoma(numero1, numero2, resultado);

        } catch (NumberFormatException e) {
            System.out.println("Erro ao converter número: " + e.getMessage());
        }
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
		this.txt1.requestFocus();
		
	}

    
    
}


