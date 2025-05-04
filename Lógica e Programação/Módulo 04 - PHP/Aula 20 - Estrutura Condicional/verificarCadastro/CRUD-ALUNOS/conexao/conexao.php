<?php
$servername = "localhost"; // ou o seu servidor de banco de dados
$username = "root"; // nome de usuário do banco
$password = ""; // senha do banco
$dbname = "faculdade"; // nome da sua base de dados

// Criando a conexão
$conn = new mysqli($servername, $username, $password, $dbname);

// Verificando a conexão
if ($conn->connect_error) {
    die("Conexão falhou: " . $conn->connect_error);
}
?>
