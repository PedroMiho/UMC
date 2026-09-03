import api from "./api.js"


const consulta = {
    async mostrarProdutos() {
        try {
            const produtos = await api.buscarProdutos()
            console.log(produtos)
            verificarProdutosCadastrados(produtos)
            listarProdutos(produtos)
            
        } catch (error) {
            console.error(error)
        }
    }
}

function verificarProdutosCadastrados(produtos){
    let produtosCadastrados = produtos.length
    const removerNenhumProduto = document.querySelector("#verificaProduto")
    
    if (produtosCadastrados > 0){
        removerNenhumProduto.style.display = "none"
    } else {
        removerNenhumProduto.style.display = "table-cell"
    }
}

function listarProdutos(produtos){
     const tabela = document.querySelector("#mostrarProdutos")

    produtos.forEach(produto => {

        const tr = document.createElement("tr")

        const tdNome = document.createElement("td")
        const tdCategoria = document.createElement("td")
        const tdPreco = document.createElement("td")
        const tdEstoque = document.createElement("td")
        const tdStatus = document.createElement("td")
        const tdAcoes = document.createElement("td")


        tdNome.textContent = produto.nome

        tdCategoria.textContent = produto.categoria

        tdPreco.textContent = `R$ ${produto.preco.toFixed(2)}`

        tdEstoque.textContent = produto.estoque


        if (produto.estoque > 0) {

            tdStatus.textContent = "Disponível"

        } else {

            tdStatus.textContent = "Esgotado"

        }


        // BOTÃO EDITAR
        const botaoEditar = document.createElement("button")

        botaoEditar.textContent = "Editar"

        botaoEditar.classList.add("btn", "btn-warning", "btn-sm", "me-2")

        botaoEditar.addEventListener("click", async () => {
            await editarProduto(produto)
        })


        // BOTÃO EXCLUIR
        const botaoExcluir = document.createElement("button")

        botaoExcluir.textContent = "Excluir"

        botaoExcluir.classList.add("btn", "btn-danger", "btn-sm")


        botaoExcluir.addEventListener("click", async () => {
            await excluirProduto(produto.id)
        })


        tdAcoes.appendChild(botaoEditar)
        tdAcoes.appendChild(botaoExcluir)


        tr.appendChild(tdNome)
        tr.appendChild(tdCategoria)
        tr.appendChild(tdPreco)
        tr.appendChild(tdEstoque)
        tr.appendChild(tdStatus)
        tr.appendChild(tdAcoes)

        tabela.appendChild(tr)

    })
}



consulta.mostrarProdutos()

