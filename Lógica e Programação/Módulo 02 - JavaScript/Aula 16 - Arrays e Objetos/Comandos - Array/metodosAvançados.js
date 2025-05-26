const produtos = [
    { nome: "Mouse", preco: 50 },
    { nome: "Teclado", preco: 150 },
    { nome: "Monitor", preco: 600 },
    { nome: "Cabo USB", preco: 30 }
];

// const total = produtos.reduce((soma, produto) => soma + produto.preco, 0);

// console.log(`Total: R$ ${total}`);


const produtosComDesconto = produtos.map(produto => ({
    nome: produto.nome,
    preco: produto.preco * 0.9  // Aplica 10% de desconto
}));

console.log(produtosComDesconto);


const produtosCaros = produtos.filter(produto => produto.preco > 100);

console.log(produtosCaros);

// Resultado: Total: R$ 830
