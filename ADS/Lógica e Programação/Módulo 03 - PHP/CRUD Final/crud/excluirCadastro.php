<?php
    // Verifica se o ID foi passado pelo formulário
    if (isset($_POST['id'])) {
        // Inclui a conexão com o banco de dados
        include("../conexao/conexao.php");

        // Obtém o ID do usuário a ser excluído
        $id = $_POST['id'];

        // Prepara o comando SQL para excluir o registro
        $sql = "DELETE FROM usuarios WHERE ID = ?";
        $stmt = $conn->prepare($sql);

        if ($stmt) {
            // Vincula o parâmetro
            $stmt->bind_param("i", $id);

            // Executa a query
            if ($stmt->execute()) {
                // Você pode redirecionar para outra página ou mostrar a tabela novamente
                header("Location: verificarCadastro.php"); // Substitua pelo nome da página onde você lista os registros
                echo "<div class='mensagem sucesso'>Registro excluído com sucesso.</div>";
                exit();
            } else {
                echo "<div class='mensagem erro'>Erro ao excluir o registro.</div>";
            }
        } else {
            echo "<div class='mensagem erro'>Erro na consulta: " . $conn->error . "</div>";
        }

        // Fecha a conexão
        $stmt->close();
        $conn->close();
    } else {
        echo "<div class='mensagem erro'>ID não fornecido.</div>";
    }
?>
