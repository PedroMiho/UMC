<?php
$idade = 18;

if ($idade >= 18) {
    echo "Você é maior de idade.";
} else {
    echo "Você é menor de idade.";
}
?>

<?php
    $nota = 75;

    if ($nota >= 70) {
        echo "Aprovado!";
    } elseif ($nota >= 50) {
        echo "Recuperação";
    } else {
        echo "Reprovado";
    }
?>


<?php
    $condicao1 = true;
    $condicao2 = true;

    if ($condicao1 == "admin" and $condicao2 == "admin") {
        echo "Acesso liberado";
    } else {
        echo "Acesso negado";
    }
?>

