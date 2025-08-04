//Mudando a cor da tela de fundo 
window.document.body.style.background = "black";

//Mudando a cor da fonte 
window.document.body.style.color = "white";

//Modificando um elemento dentro do HTML
window.document.getElementsByTagName("div")[0].innerHTML = "Novo Título";

//Criando um elemento dentro do HTML
window.document.body.innerHTML += "<h1>Título da Página</h1>";

//Exibindo um alerta na tela
// window.alert("Olá, mundo!"); 

//Exibindo uma tela de confirmação
var resposta = window.confirm("Você deseja continuar?");
window.alert("Resultado: " + resposta); 

//Exibindo uma tela para o usuário digitar um valor
var nome = window.prompt("Qual é o seu nome?");
window.alert("Olá, " + nome + "!");

//Fazendo contas
var n1 = window.prompt("Digite um número: ");
var n2 = window.prompt("Digite um número: ");
var soma = n1 + n2
window.alert("Resultado " + soma);


