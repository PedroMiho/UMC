let produtos = [
    { nome: "Teclado", categoria: "Periférico", preco: 100 },
    { nome: "Monitor", categoria: "Eletrônico", preco: 800 },
    { nome: "Mouse", categoria: "Periférico", preco: 50 }
];

produtos.forEach((produto) => {
    console.log(`${produto.nome} - R$ ${produto.preco}`);
});