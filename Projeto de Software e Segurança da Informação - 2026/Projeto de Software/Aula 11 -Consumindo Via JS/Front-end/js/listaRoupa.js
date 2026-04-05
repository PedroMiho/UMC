async function carregarProdutos() {

    try {

        let resposta = await fetch("http://localhost:8080/roupa");

        let produtos = await resposta.json();

        let tabela = document.getElementById("tabelaProdutos");

        tabela.innerHTML = "";

        produtos.forEach((produto) => {

            let valorEstoque = produto.preco * produto.quantidade;



            tabela.innerHTML += `
            <tr>
                <td>${produto.id}</td>
                <td>${produto.nomeProduto}</td>
                <td>${produto.marca}</td>
                <td>${produto.tamanho}</td>
                <td>R$ ${produto.preco.toFixed(2)}</td>
                <td>${produto.quantidade}</td>
                <td>R$ ${valorEstoque.toFixed(2)}</td>
                <td>
                    <button class="btn btn-danger btn-sm" onclick="excluir(${produto.id})" title="Excluir produto">
                        <i class="bi bi-trash"></i>
                    </button>
                </td>
            </tr>
            `;

        });

    } catch (erro) {
        console.error("Erro ao buscar produtos:", erro);
        alert("Erro ao carregar produtos!");
    }

}

function excluir(id) {
    
    fetch(`http://localhost:8080/roupa/${id}` , {
        method: 'DELETE'
    })

    .then(response => {
        if(response.ok) {
            Swal.fire({
                title: "ROUPA EXCLUÍDO COM SUCESSO",
                text: "ROUPA EXCLUÍDA",
                icon: "success"
            });
            carregarProdutos();
        } else {
            cSwal.fire({
                icon: 'error',
                title: 'Erro',
                text: 'Não foi possível deletar'
            });
        }
    })

    .catch(error => {
        console.error('Erro na requisição:', error);
    });

}

// chama a função ao carregar a página
carregarProdutos();