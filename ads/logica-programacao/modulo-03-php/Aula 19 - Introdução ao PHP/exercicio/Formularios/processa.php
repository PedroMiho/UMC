<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Resultado</title>
    <link rel="stylesheet" href="stylePhp.css">
</head>
<body>
    
    <main class="container">
        <h1>Dados Enviados</h1>

        <?php 
            // var_dump($_POST);

            $nome = $_POST["nome"];
            $sobreNome = $_POST["sobreNome"];
            $email = $_POST["email"];
            $senha = $_POST["senha"];

            echo "<p><strong>O seu nome:</strong> $nome</p>";
            echo "<p><strong>O seu sobrenome:</strong> $sobreNome</p>";
            echo "<p><strong>O seu e-mail:</strong> $email</p>";
            echo "<p><strong>A sua senha:</strong> $senha</p>";
        ?>

        <a href="index.html">Voltar ao cadastro</a>
    </main>

</body>
</html>