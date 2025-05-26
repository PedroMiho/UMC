<?php 
for ($i = 0; $i < 5; $i++) {
    echo "Valor de i: $i <br>";
}

echo "<br>";

$nomes = ["Ana", "Carlos", "Bruna"];

foreach ($nomes as $nome) {
    echo "Olá, $nome! <br>";
}
echo "<br>";
$idades = ["Ana" => 25, "Carlos" => 30, "Bruna" => 22];

foreach ($idades as $nome => $idade) {
    echo "$nome tem $idade anos <br>";
}
echo "<br>";

$pesos = ["Ana" => 60, "Carlos" => 85, "Bruna" => 65];
$alturas = ["Ana" => 1.65, "Carlos" => 1.70, "Bruna" => 1.60];

foreach ($pesos as $nome => $peso) {
    $altura = $alturas[$nome];
    $imc = $peso / ($altura * $altura);
    
    echo "$imc <br>";
}

?>

