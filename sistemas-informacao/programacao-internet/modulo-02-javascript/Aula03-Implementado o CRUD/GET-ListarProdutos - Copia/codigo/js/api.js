const api = {
    async buscarProdutos(pagina = 1, produtosPorPagina = 5) {
        try {
            const response = await fetch(
                `http://localhost:3000/produtos?_page=${pagina}&_per_page=${produtosPorPagina}`
            )

            return await response.json()

        } catch (error) {
            alert("Erro ao buscar produtos")
            throw error
        }
    }
}

export default api