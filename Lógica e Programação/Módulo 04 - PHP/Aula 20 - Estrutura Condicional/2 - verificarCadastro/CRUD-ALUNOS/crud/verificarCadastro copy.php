<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar Aluno</title>
    <link rel="stylesheet" href="../estilos/styleVerificar.css">
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

        <section id="containerSection">
            <form action="verificarCadastro.php" method="post">
                <input type="email" placeholder="Informe o seu E-mail" name="email" id="email">
                <input type="submit" value="Buscar">
            </form>

        </section>
        <section>

<?php
if (isset($_POST['email'])) {
include("../conexao/conexao.php");
$email = $_POST['email'];

$sql = "SELECT * FROM usuarios WHERE email = ?";
$stmt = $conn->prepare($sql);

if ($stmt) {
    $stmt->bind_param("s", $email);
    $stmt->execute();
    $resultado = $stmt->get_result();

if ($resultado->num_rows > 0) {
$row = $resultado->fetch_assoc();
echo "
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>E-mail</th>
            <th>Excluir</th>
        </tr>
    </thead>
<tbody>
    <tr>
        <td>{$row['ID']}</td>
        <td>{$row['NOME']}</td>
        <td>{$row['SOBRENOME']}</td>
        <td>{$row['EMAIL']}</td>
        <td>
            <form action='excluirCadastro.php' method='POST'>
                <input type='hidden' name='id' value='{$row['ID']}'>
                <input type='submit' id='btn-excluir' value='Excluir'>
            </form>
        </td>
    </tr>
</tbody>
</table>";
} else {
echo "<div class='mensagem erro'>E-mail <strong>$email</strong> não encontrado.</div>";
}

$stmt->close();
} else {
echo "<div class='mensagem erro'>Erro na consulta: " . $conn->error . "</div>";
}

$conn->close();
}
?>
        </section>

    </main>

</body>

</html>