package Controller;


import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.DeletarUsuario;
import model.Usuario;

//Tela que mostra as informações do usuario e o pergunta se ele deseja atualizar os dados
public class TelaUsuarioController{
	
    @FXML
    private Button btnExcluirConta;
    
    @FXML
    private Button btnAtualizarDados;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private Label lblInicio;
    
    @FXML
    private Label lblLoginUsuario;

    @FXML
    private Label lblNomeUsuario;

    @FXML
    private Label lblSenhaUsuario;
    
    private Usuario usuarioAtual; 
        
    public void preencherDadosUsuario(Usuario usuario) {
        this.usuarioAtual = usuario;
    	lblInicio.setText("Olá, " + usuario.getNome());
        lblNomeUsuario.setText(usuario.getNome());
        lblLoginUsuario.setText(usuario.getLogin());
        lblSenhaUsuario.setText(usuario.getSenha());
    }
    
    @FXML
    void OnClickAtualizarDados(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/TelaAtualizacao.fxml"));
        Pane pane = loader.load();       
        
        // Pegando o controller da nova tela
        TelaAtualizacaoController controller = loader.getController();
        controller.receberUsuario(usuarioAtual);
        
        // Obter o stage atual
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        
        // Definir a nova cena para o stage atual
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Tela de Atualização");
        stage.show();
    }
    
    private void voltarParaTelaLogin() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/Home.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) lblNomeUsuario.getScene().getWindow(); // ou qualquer elemento da sua tela
            stage.setScene(new Scene(root));
            stage.setTitle("Tela de Login");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OnClickExluirConta(ActionEvent event) {
        if (usuarioAtual != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Excluir Conta");
            alert.setHeaderText("Tem certeza que deseja excluir sua conta?");
            alert.setContentText("Essa ação não poderá ser desfeita.");

            Optional<ButtonType> resultado = alert.showAndWait();
            if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
                DeletarUsuario deletarUsuario = new DeletarUsuario();
                boolean sucesso = deletarUsuario.deletarUsuario(usuarioAtual.getLogin());

                if (sucesso) {
                    Alert sucessoAlert = new Alert(Alert.AlertType.INFORMATION);
                    sucessoAlert.setTitle("Conta Excluída");
                    sucessoAlert.setHeaderText(null);
                    sucessoAlert.setContentText("Sua conta foi excluída com sucesso.");
                    sucessoAlert.showAndWait();

                    voltarParaTelaLogin();
                } else {
                    Alert erroAlert = new Alert(Alert.AlertType.ERROR);
                    erroAlert.setTitle("Erro");
                    erroAlert.setHeaderText("Erro ao excluir conta");
                    erroAlert.setContentText("Tente novamente mais tarde.");
                    erroAlert.showAndWait();
                }
            }
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


