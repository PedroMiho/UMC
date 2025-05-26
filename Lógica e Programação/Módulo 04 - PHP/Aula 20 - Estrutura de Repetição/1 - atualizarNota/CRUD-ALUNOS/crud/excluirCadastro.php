<?php
    if (isset($_POST['id'])) {
        include("../conexao/conexao.php");
        $id = $_POST['id'];

        // Prepara o comando SQL para excluir o registro
        $sql = "DELETE FROM usuarios WHERE ID = ?";
        $stmt = $conn->prepare($sql);

        if ($stmt) {
            $stmt->bind_param("i", $id);

            // Executa a query
            $stmt->execute();

            header("Location: verificarCadastro.php"); 
            $stmt->close();

        } else {
            echo "<div class='mensagem erro'>Erro na consulta: " . $conn->error . "</div>";
        }

        // Fecha a conexão
        $conn->close();
    } else {
        echo "<div class='mensagem erro'>ID não fornecido.</div>";
    }
?>