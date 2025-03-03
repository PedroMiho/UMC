let pacientes = document.querySelectorAll(".produtos")

var botao = document.querySelector("#adicionar-produto");

botao.addEventListener("click", (event) => {
    let linhas = document.querySelectorAll("tr")
    event.preventDefault();

    //Capturando os valores do input
    let form = document.querySelector("#form-adiciona")
    let produto = form.produto.value
    console.log(produto);
    
    let valor = form.valor.value
    console.log(valor);
    
    let quantidade = form.quantidade.value
    console.log(quantidade);
    
    //Criando novas tag dentro do nosso documentos HTML
    let produtoTR = document.createElement("tr") 
    let codigoVendaTD = document.createElement("td")
    let nomeProdutoTD = document.createElement("td")
    let valorTD = document.createElement("td")
    let quantidadeTD = document.createElement("td")
    let valorFinalTD = document.createElement("td")
    
    //Inserindo os valores as tags
    codigoVendaTD.textContent = linhas.length
    nomeProdutoTD.textContent =  `Bolo de ${produto}`
    quantidadeTD.textContent = quantidade
    valorTD.textContent = "R$ " + parseFloat(valor).toFixed(2)
    valorFinalTD.textContent = calculaValorFinal(valor, quantidade)

    produtoTR.appendChild(codigoVendaTD)
    produtoTR.appendChild(nomeProdutoTD)
    produtoTR.appendChild(quantidadeTD)
    produtoTR.appendChild(valorTD)
    produtoTR.appendChild(valorFinalTD)

    let tabela = document.querySelector("#tabela-produtos")
    tabela.appendChild(produtoTR)

})


function calculaValorFinal (valor, quantidade) {
    let verValor = true
    let verquantidade = true

    let quantidadeFinal = parseFloat(quantidade)
    let valorFinal = parseFloat(valor)
    
    // if (valorFinal < 0)  {
    //     verValor = false
    //     return "Valor Inválido"
    // }

    if (quantidadeFinal < 0){
        verquantidade = false
        return "Quantidade Inválida"

    }

    if (verquantidade && verValor){
        let valor =  quantidadeFinal * valorFinal
        return "R$ " + valor.toFixed(2)
    }
}
