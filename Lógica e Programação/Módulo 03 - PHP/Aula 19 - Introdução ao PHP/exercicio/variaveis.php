<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meu primeiro programa</title>
</head>
<body>
    <h1>
        <?php 
            echo "Olá, mundo";
        ?>
    </h1>    
    
    <h2>Variáveis em PHP</h2>

    <p>    
        <?php
            $nome = "Pedro";
            $sobrenome = "Miho";
            
            echo "Nome: $nome <br>";
            echo "Idade: $sobrenome <br>";
        ?>
    </p>

    <h2>Constantes em PHP</h2>
    <p>
        <?php 
            const faculdade = "UMC";
            const cidade = "Mogi das Cruzes";
            
            echo "Faculdade " . faculdade . "<br>"; 
            echo "Cidade " . cidade . "<br>"; 
            ?>
    </p>
    
    <h2>Tipos primitivos em PHP</h2>

    <p>
        <?php 

            $inteiro = 10;
            $flutuante = 3.14;
            $string = "Texto";
            $booleanos = true;

            echo "Tipo número inteiro $inteiro <br>";
            echo "Tipo número ponto flutuante $flutuante <br>";
            echo "Tipo string $string <br>";
            echo "Tipo booleano $booleanos <br>";

        ?>
    </p>


</body>
</html>