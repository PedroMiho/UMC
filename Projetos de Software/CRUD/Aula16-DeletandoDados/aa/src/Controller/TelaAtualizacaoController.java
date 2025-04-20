package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.AtualizaUsuario;
import model.Usuario;

//Tela que tem os campos permitindo os dados a serem atualizados
public class TelaAtualizacaoController {
	@FXML
    private Button btnAtualizar;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label lblInicio;

    @FXML
    private Label txtLoginUsuario;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSenha;
    
    private Usuario usuarioAtual;
    
    public void receberUsuario(Usuario usuario) {
        this.usuarioAtual = usuario;
        txtLoginUsuario.setText(usuario.getLogin()); 
        txtNome.setText(usuario.getNome());   
        txtSenha.setText(usuario.getSenha()); 
    }
    
    @FXML
    void OnClickAtualizar(ActionEvent event) {
    	String novoNome = txtNome.getText();
        String novaSenha = txtSenha.getText();

        // Atualiza os dados no objeto
        usuarioAtual.setNome(novoNome);
        usuarioAtual.setSenha(novaSenha);

        // Salva no banco
        AtualizaUsuario usuarioDAO = new AtualizaUsuario();
        boolean sucesso = usuarioDAO.atualizarUsuario(usuarioAtual);
        
        if (sucesso) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setContentText("Dados atualizados com sucesso!");
            alert.showAndWait();

            
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setContentText("Erro ao atualizar os dados.");
            alert.showAndWait();
        }
    }

    @FXML
    void OnClickVoltar(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/TelaUsuario.fxml"));
        Pane pane = loader.load();

        TelaUsuarioController controller = loader.getController();
        controller.preencherDadosUsuario(usuarioAtual);

        // Obter o stage atual
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();

        
        // Definir a nova cena para o stage atual
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Tela de Login");
        stage.show();
    }

}
