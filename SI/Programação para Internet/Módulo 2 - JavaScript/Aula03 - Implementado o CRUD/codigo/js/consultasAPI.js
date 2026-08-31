import api from "./api.js"

const consulta = {
    async mostrarProdutos() {

        try {

            const produtos = await api.buscarProdutos()

            console.log(produtos)

            const listaProdutos = document.querySelector("#mostrarProdutos")

            produtos.forEach(produto => {

                // =========================
                // LINHA
                // =========================

                const tr = document.createElement("tr")


                // =========================
                // CÉLULAS
                // =========================

                const tdNome = document.createElement("td")
                const tdCategoria = document.createElement("td")
                const tdPreco = document.createElement("td")
                const tdEstoque = document.createElement("td")
                const tdStatus = document.createElement("td")
                const tdAcoes = document.createElement("td")


                // =========================
                // DADOS
                // =========================

                tdNome.textContent = produto.nome

                tdCategoria.textContent = produto.categoria

                tdPreco.textContent = `R$ ${produto.preco.toFixed(2)}`

                tdEstoque.textContent = produto.estoque


                // =========================
                // STATUS
                // =========================

                if (produto.estoque > 0) {

                    tdStatus.textContent = "Disponível"

                } else {

                    tdStatus.textContent = "Esgotado"

                }


                // =========================
                // BOTÃO EDITAR
                // =========================

                const btnEditar = document.createElement("button")

                btnEditar.textContent = "Editar"

                btnEditar.classList.add(
                    "btn",
                    "btn-primary",
                    "btn-sm",
                    "me-2"
                )

                btnEditar.addEventListener("click", () => {

                    console.log("Editar:", produto.id)

                })


                // =========================
                // BOTÃO EXCLUIR
                // =========================

                const btnExcluir = document.createElement("button")

                btnExcluir.textContent = "Excluir"

                btnExcluir.classList.add(
                    "btn",
                    "btn-danger",
                    "btn-sm"
                )

                btnExcluir.addEventListener("click", () => {

                    console.log("Excluir:", produto.id)

                })


                // =========================
                // ADICIONA BOTÕES
                // =========================

                tdAcoes.appendChild(btnEditar)

                tdAcoes.appendChild(btnExcluir)


                // =========================
                // ADICIONA CÉLULAS
                // =========================

                tr.appendChild(tdNome)

                tr.appendChild(tdCategoria)

                tr.appendChild(tdPreco)

                tr.appendChild(tdEstoque)

                tr.appendChild(tdStatus)

                tr.appendChild(tdAcoes)


                // =========================
                // ADICIONA LINHA NA TABELA
                // =========================

                listaProdutos.appendChild(tr)

            })

        } catch (error) {

            console.error(error)

        }
    }
}

consulta.mostrarProdutos()