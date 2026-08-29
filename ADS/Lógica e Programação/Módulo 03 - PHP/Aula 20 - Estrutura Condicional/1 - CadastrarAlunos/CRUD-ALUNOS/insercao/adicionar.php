<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Aluno</title>
    <link rel="stylesheet" href="../estilos/styleCadastrar.css">
</head>

<body>

    <header>
        <nav>
            <ul>
                <li><a href="../index.php">Início</a></li>
                <li><a href="adicionar.php">Cadastrar Usuário</a></li>
                <li><a href="verificarCadastro.php">Listar Usuários</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <form action="adicionar.php" method="POST">
            <h2>Cadastro de Usuário</h2>

            <label for="nome">Nome:</label>
            <input type="text" name="nome" required>

            <label for="sobrenome">Sobrenome:</label>
            <input type="text" name="sobrenome" required>

            <label for="email">E-mail:</label>
            <input type="email" name="email" required>

            <label for="curso">Selecione o curso:</label>
            <select id="curso" name="curso" class="estilo">
                <option value="analise_desenvolvimento_sistemas">Análise e Desenvolvimento de Sistemas</option>
                <option value="engenharia_software">Engenharia de Software</option>
                <option value="ciencias_computacao">Ciências da Computação</option>
                <option value="sistemas_informacao">Sistemas da Informação</option>
            </select>

            <input type="submit" value="Cadastrar">
        </form>

        <?php
        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            mysqli_report(MYSQLI_REPORT_ERROR | MYSQLI_REPORT_STRICT); // ativa exceções para erros do MySQL


                include("../conexao/conexao.php");
                $nome = $_POST["nome"];
                $sobrenome = $_POST["sobrenome"];
                $email = $_POST["email"];
                $curso = $_POST["curso"];
                

                $prefixo = "114"; // Pode ser um prefixo fixo
                $id = $prefixo . rand(100, 999); // Gera um número aleatório de 6 dígitos


                $sql = "INSERT INTO usuarios (id, nome, sobrenome, email, curso) VALUES (?, ?, ?, ?, ?)";
                $stmt = $conn->prepare($sql);
                $stmt->bind_param("sssss", $id, $nome, $sobrenome, $email, $curso);
                $stmt->execute();

                echo "<div class='mensagem sucesso'>Usuário cadastrado com sucesso</div>";

                $stmt->close();
                $conn->close();

        }
        ?>


    </main>



</body>

</html>