// // Selecionando elementos com diferentes seletores

// getElementsByTagName - Seleciona todos os parágrafos
let paragrafos = window.document.getElementsByTagName("p");
paragrafos[0].innerHTML = "Conteúdo alterado do primeiro parágrafo.";

// getElementById - Seleciona um único elemento pelo ID
let titulo = window.document.getElementById("titulo");
titulo.innerHTML = "Título Modificado com JS";

// getElementsByClassName - Seleciona todos os elementos com a classe 'caixa'
let caixas = window.document.getElementsByClassName("caixa");
caixas[0].style.backgroundColor = "red";
caixas[1].style.backgroundColor = "blue";

// getElementsByName - Seleciona todos os elementos com o nome 'nome'
let nomeInput = window.document.getElementsByName("nome");
nomeInput[0].placeholder = "Digite seu nome aqui";

// querySelector - Seleciona o primeiro elemento com a classe 'paragrafo'
let ParagrafoQuery = window.document.querySelector("#paragrafoQuery");
ParagrafoQuery.style.backgroundColor = "green";
ParagrafoQuery.style.padding = "10px";
ParagrafoQuery.style.margin = "5px";

// querySelectorAll - Seleciona todos os elementos com a classe 'caixa'
let todasCaixas = window.document.querySelectorAll(".caixaQuery");
todasCaixas[0].style.backgroundColor = "purple"
todasCaixas[1].style.backgroundColor = "yellow"


