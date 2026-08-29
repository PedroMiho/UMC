const valor1 = document.getElementById("valor1");
const valor2 = document.getElementById("valor2");
const valor3 = document.getElementById("valor3");

const botao = document.getElementById("btnSomar");
const resultado = document.getElementById("resultado");

botao.addEventListener("click", function() {

    let numero1 = Number(valor1.value);
    let numero2 = Number(valor2.value);
    let numero3 = Number(valor3.value);

    let soma = numero1 + numero2 + numero3;

    resultado.textContent = "Resultado: " + soma;

});