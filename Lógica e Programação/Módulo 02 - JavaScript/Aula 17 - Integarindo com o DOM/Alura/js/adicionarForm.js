var pacientes = document.querySelectorAll(".paciente")

var botaoAdicionar = document.querySelector("#adicionar-paciente");

botaoAdicionar.addEventListener("click", (event) => {
    event.preventDefault();

    let form = document.querySelector("#form-adiciona")
    let nome = form.nome.value
    let peso = form.peso.value
    let altura = form.altura.value
    let gordura = form.gordura.value

    let pacienteTR = document.createElement("tr")
    let nomeTD = document.createElement("td")
    let alturaTD = document.createElement("td")
    let pesoTD = document.createElement("td")
    let gorduraTD = document.createElement("td")
    let imcTD = document.createElement("td")
    
    nomeTD.textContent = nome
    alturaTD.textContent = altura
    pesoTD.textContent = peso
    gorduraTD.textContent = gordura
    imcTD.textContent = calculoIMC(peso,altura)
        
    pacienteTR.appendChild(nomeTD)
    pacienteTR.appendChild(alturaTD)
    pacienteTR.appendChild(pesoTD)
    pacienteTR.appendChild(gorduraTD)
    pacienteTR.appendChild(imcTD)

    let tabela = document.querySelector("#tabela-pacientes")
    tabela.appendChild(pacienteTR)
});