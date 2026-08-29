// Passo a passo para fazer com o aluno
// console.log(produtos);
// let valorTotal = produtos[0].querySelector(".info-valor-total")
// valorTotal.innerHTML = "100"

//Seleciona todos os produtos da tabela faturamento
// let produtos = document.querySelectorAll(".produto")
// console.log(produtos[0]);


// //Seleciona o valor da unidade da tabela produto
// let valorProduto = produtos[0].querySelector(".info-valor-unidade")

// //Tirando as informação como R$ e trocando , por .
// let valorLimpo = valorProduto.textContent.replace(/R\$\ /, "").replace("," , ".")
// let valorFinal = parseFloat(valorLimpo)

// //Seleciona o valor da quantidade da tabela produto
// let quantidade = produtos[0].querySelector(".info-quantidade").textContent
// let quantidadeFinal = parseFloat(quantidade)

// //Faz o calculo do valor total e retorna para a tabela
// let valorTotal = produtos[0].querySelector(".info-valor-total")
// valorTotal.innerHTML = "R$ " + (parseFloat(quantidadeFinal) * parseFloat(valorFinal)).toFixed(2).replace("." , ",")


let produtos = document.querySelectorAll(".produto")
console.log(produtos[0]);


for (i=0; i < produtos.length; i++) {
    //Seleciona o valor da unidade da tabela produto
    let valorProduto = produtos[i].querySelector(".info-valor-unidade")
    let quantidade = produtos[i].querySelector(".info-quantidade").textContent
    let valorTotal = produtos[i].querySelector(".info-valor-total")

    //Tirando as informação como R$ e trocando , por .
    let valorLimpo = valorProduto.textContent.replace(/R\$\ /, "")
    let valorFinal = parseFloat(valorLimpo)

    //Seleciona o valor da quantidade da tabela produto
    let quantidadeFinal = parseFloat(quantidade)
    
    //Faz o calculo do valor total e retorna para a tabela
    valorTotal.innerHTML = "R$ " + (parseFloat(quantidadeFinal) * parseFloat(valorFinal)).toFixed(2)

}







