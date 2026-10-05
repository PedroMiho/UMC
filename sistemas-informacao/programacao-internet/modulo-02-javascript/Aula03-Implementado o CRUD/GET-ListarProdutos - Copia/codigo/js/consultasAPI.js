import api from "./api.js"

let paginaAtual = 1
const produtosPorPagina = 2

const botaoAnterior = document.querySelector("#anterior")
const botaoProxima = document.querySelector("#proxima")
const numeroPagina = document.querySelector("#paginaAtual")

const consulta = {
    async mostrarProdutos(paginaDesejada = paginaAtual) {
        // Guarda o estado dos botões antes da consulta.
        const anteriorEstavaDesabilitado = botaoAnterior.disabled
        const proximaEstavaDesabilitada = botaoProxima.disabled

        // Evita novos cliques durante a requisição.
        botaoAnterior.disabled = true
        botaoProxima.disabled = true

        try {
            const resposta = await api.buscarProdutos(
                paginaDesejada,
                produtosPorPagina
            )

            listarProdutos(resposta.data)

            // Confirma a mudança de página após o carregamento.
            paginaAtual = paginaDesejada
            numeroPagina.textContent = paginaAtual

            botaoAnterior.disabled = paginaAtual === 1
            botaoProxima.disabled = paginaAtual >= resposta.pages

        } catch (error) {
            // Restaura os controles se a consulta falhar.
            botaoAnterior.disabled = anteriorEstavaDesabilitado
            botaoProxima.disabled = proximaEstavaDesabilitada

            console.error(error)
        }
    }
}

botaoAnterior.addEventListener("click", () => {
    consulta.mostrarProdutos(paginaAtual - 1)
})

botaoProxima.addEventListener("click", () => {
    consulta.mostrarProdutos(paginaAtual + 1)
})

function verificarProdutosCadastrados(produtos) {
    const produtosCadastrados = produtos.length
    const mensagem = document.querySelector("#verificaProduto")

    if (produtosCadastrados > 0) {
        mensagem.style.display = "none"
    } else {
        mensagem.style.display = "table-cell"
    }
}



function listarProdutos(produtos) {
    const tabela = document.querySelector("#mostrarProdutos")

    // Controla a mensagem que já existe no HTML.
    verificarProdutosCadastrados(produtos)

    // Remove somente as linhas dos produtos anteriores.
    tabela.querySelectorAll(".linha-produto").forEach(linha => {
        linha.remove()
    })

    produtos.forEach(produto => {
        const tr = document.createElement("tr")
        tr.classList.add("linha-produto")

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
        botaoEditar.type = "button"
        botaoEditar.textContent = "Editar"

        botaoEditar.classList.add(
            "btn", "btn-warning", "btn-sm", "me-2"
        )

        botaoEditar.addEventListener("click", async () => {
            await editarProduto(produto)
        })

        // BOTÃO EXCLUIR
        const botaoExcluir = document.createElement("button")
        botaoExcluir.type = "button"
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

// Carrega a primeira página uma única vez.
consulta.mostrarProdutos()