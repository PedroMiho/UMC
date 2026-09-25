import api from "./api.js"

// A lista completa é recebida uma vez pelo GET.
let produtos = []
let paginaAtual = 1
const produtosPorPagina = 5
const busca = document.querySelector("#search")

const consulta = {
    async mostrarProdutos() {
        try {
            produtos = await api.buscarProdutos()
            preencherCards()
            atualizarListagem()
        } catch (error) {
            console.error(error)
        }
    }
}

// Os cards consideram todos os produtos, mesmo durante uma busca.
function preencherCards() {
    document.querySelector("#totalProdutos").textContent = produtos.length

    const categorias = []
    let somaPrecos = 0

    produtos.forEach(produto => {
        somaPrecos = somaPrecos + produto.preco

        if (!categorias.includes(produto.categoria)) {
            categorias.push(produto.categoria)
        }
    })

    let media = 0
    if (produtos.length > 0) {
        media = somaPrecos / produtos.length
    }

    document.querySelector("#totalCategorias").textContent = categorias.length
    document.querySelector("#valorMedio").textContent = "R$ " + media.toFixed(2).replace("." , ",")
}

function atualizarListagem() {
    // 1. Filtra pelo nome, ignorando letras maiúsculas e minúsculas.
    const nomeBuscado = busca.value.trim().toLowerCase()
    const produtosFiltrados = produtos.filter(produto => {
        return produto.nome.toLowerCase().includes(nomeBuscado)
    })

    // 2. Calcula quantas páginas são necessárias.
    let totalPaginas = Math.ceil(produtosFiltrados.length / produtosPorPagina)
    if (totalPaginas === 0) {
        totalPaginas = 1
    }
    if (paginaAtual > totalPaginas) {
        paginaAtual = totalPaginas
    }

    // 3. Seleciona somente os produtos da página atual.
    // Página 1: slice(0, 5). Página 2: slice(5, 10).
    const inicio = (paginaAtual - 1) * produtosPorPagina
    const fim = inicio + produtosPorPagina
    const produtosDaPagina = produtosFiltrados.slice(inicio, fim)

    listarProdutos(produtosDaPagina)

    // 4. Atualiza o texto e bloqueia as setas nos limites.
    document.querySelector("#paginaAtual").textContent = `Página ${paginaAtual} de ${totalPaginas}`
    document.querySelector("#anterior").disabled = paginaAtual === 1
    document.querySelector("#proxima").disabled = paginaAtual === totalPaginas
}

function listarProdutos(produtos){
    const tabela = document.querySelector("#mostrarProdutos")
    tabela.innerHTML = ""

    if (produtos.length === 0) {
        const tr = document.createElement("tr")
        const td = document.createElement("td")
        td.colSpan = 6
        td.textContent = "Nenhum produto encontrado."
        tr.appendChild(td)
        tabela.appendChild(tr)
        return
    }

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


// Ao mudar a busca, começamos novamente na primeira página.
busca.addEventListener("input", () => {
    paginaAtual = 1
    atualizarListagem()
})

document.querySelector("#anterior").addEventListener("click", () => {
    paginaAtual--
    atualizarListagem()
})

document.querySelector("#proxima").addEventListener("click", () => {
    paginaAtual++
    atualizarListagem()
})

consulta.mostrarProdutos()
