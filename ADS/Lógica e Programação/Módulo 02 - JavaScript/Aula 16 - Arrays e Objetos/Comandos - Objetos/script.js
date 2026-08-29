const produto = {
    chave: "Valor",
    nome: "Notebook",
    preco: 3500,
    emEstoque: true
};

console.log(produto.nome);   // Resultado: Notebook
console.log(produto.preco);  // Resultado: 3500

console.log(produto["nome"]); // Resultado: Notebook


produto.fabricante = "Dell"
produto["fabricante"] = "Dell"

delete produto.fabricante

delete produto["fabricante"];

console.log(produto);