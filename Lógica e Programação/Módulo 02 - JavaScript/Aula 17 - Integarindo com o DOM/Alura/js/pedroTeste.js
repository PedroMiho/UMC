var pacientes = document.querySelectorAll(".paciente")

var botao = document.querySelector("#adicionar-paciente");

botao.addEventListener("click", (event) => {

    event.preventDefault();

    let form = document.querySelector("#form-adiciona")
    let nome = form.nome.value
    let peso = form.peso.value
    let altura = form.altura.value
    let percentual = form.percentual.value

    let pacienteTR = document.createElement("tr") 
    let nomeTD = document.createElement("td")
    let pesoTD = document.createElement("td")
    let alturaTD = document.createElement("td")
    let percentualTD = document.createElement("td")
    let imcTD = document.createElement("td")

    nomeTD.textContent = nome
    pesoTD.textContent = peso
    alturaTD.textContent = altura
    percentualTD.textContent = percentual
    imcTD.textContent = calculaIMC(peso, altura)

    pacienteTR.appendChild(nomeTD)
    pacienteTR.appendChild(pesoTD)
    pacienteTR.appendChild(alturaTD)
    pacienteTR.appendChild(percentualTD)
    pacienteTR.appendChild(imcTD)

    let tabela = document.querySelector("#tabela-pacientes")
    tabela.appendChild(pacienteTR)
})

