let pacientes = document.querySelectorAll(".produtos")

var botao = document.querySelector("#adicionar-produto");
//Mostrar o HTML
function Adicionar(){ 
    let linhas = document.querySelectorAll("tr")

    //Capturando os valores do input
    let form = document.querySelector("#form-adiciona")
    let produto = form.produto.value
    console.log(produto);
    
    let valor = form.valor.value
    console.log(valor);
    
    let quantidade = form.quantidade.value
    console.log(quantidade);
    
    if (!produto || !valor || !quantidade) {
        window.alert("Por favor, preencha todos os campos antes de adicionar.");
    }
    else {

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
        valorFinalTD.textContent = "R$ " + (valor * quantidade).toFixed(2)
        
        produtoTR.appendChild(codigoVendaTD)
        produtoTR.appendChild(nomeProdutoTD)
        produtoTR.appendChild(quantidadeTD)
        produtoTR.appendChild(valorTD)
        produtoTR.appendChild(valorFinalTD)
        
        let tabela = document.querySelector("#tabela-produtos")
        tabela.appendChild(produtoTR)
    }
        
}
