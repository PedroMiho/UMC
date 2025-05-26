<?php 
    $hotsname = 'localhost';
    $bancodedados = 'faculdade';
    $usuario = 'root';
    $senha = '';

    $conn = new mysqli($hotsname, $usuario, $senha, $bancodedados);

    if ($conn->connect_errno) {
        echo "Falha ao conectar: (". $conn->connect_errno. ")" ;
    }

?>