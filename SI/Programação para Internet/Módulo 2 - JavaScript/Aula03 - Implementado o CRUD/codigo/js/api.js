const api = {
    async buscarProdutos() {
        try {
            const response = await fetch("http://localhost:3000/produtos")
            return await response.json()
        } catch (error) {
            alert("Erro ao buscar produtos")
            throw error
        }
    }
}

export default api