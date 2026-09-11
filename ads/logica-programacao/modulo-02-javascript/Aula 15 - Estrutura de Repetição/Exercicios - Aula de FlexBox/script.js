function filtrarProdutos() {
    const pesquisa = document.querySelector("#pesquisa-produto").value.toLowerCase();

    // Seleciona todos os elementos de categoria
    const categorias = document.querySelectorAll(".card-produto");

    // Loop para verificar e mostrar ou esconder os produtos com base na pesquisa
    categorias.forEach((categoria) => {
        const produto = categoria.parentElement; // Pega o produto inteiro (div)

        // Verifica se o valor da pesquisa está contido na categoria
        if (categoria.textContent.toLowerCase().includes(pesquisa)) {
            produto.style.display = "block"; // Exibe o produto
        } else {
            produto.style.display = "none"; // Oculta o produto
        }
    });
}