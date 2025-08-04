// Selecionando elementos com diferentes seletores

// getElementsByTagName - Seleciona todos os parágrafos
let paragrafos = window.document.getElementsByTagName("p");
paragrafos[0].innerHTML = "Conteúdo alterado do primeiro parágrafo.";

// getElementById - Seleciona um único elemento pelo ID
let titulo = window.document.getElementById("titulo");
titulo.innerHTML = "Título Modificado com JS";

// getElementsByClassName - Seleciona todos os elementos com a classe 'caixa'
let caixas = window.document.getElementsByClassName("caixa");
caixas[1].style.backgroundColor = "lightblue";

// getElementsByName - Seleciona todos os elementos com o nome 'nome'
let nomeInput = window.document.getElementsByName("nome");
nomeInput[0].placeholder = "Digite seu nome aqui";

// querySelector - Seleciona o primeiro elemento com a classe 'paragrafo'
let primeiroParagrafo = window.document.querySelector(".paragrafo");
primeiroParagrafo.style.color = "purple";

// querySelectorAll - Seleciona todos os elementos com a classe 'caixa'
let todasCaixas = window.document.querySelectorAll(".caixa");
todasCaixas.forEach((caixa, index) => {
    caixa.innerHTML += " (Alterado com querySelectorAll)";
});

// Evento de clique no botão para alterar o conteúdo de todos os elementos
document.getElementById("botaoAlterar").onclick = function() {
    let titulo = document.querySelector("#titulo");
    titulo.innerHTML = "Você clicou no botão!";
};
