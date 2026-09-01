import api from "./api.js"
const consulta = {
    async mostrarProdutos() {
        try {
            const produtos = await api.buscarProdutos()
            console.log(produtos)
            verificarProdutosCadastrados(produtos)

        } catch (error) {
            console.error(error)
        }
    }
}

function verificarProdutosCadastrados(produtos){

    let produtosCadastrados = produtos.length
    
    if (produtosCadastrados > 0){
        
    }

}

consulta.mostrarProdutos()