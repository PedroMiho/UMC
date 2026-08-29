const readline = require('readline-sync');

let valorCompra = prompt("Digite o valor total da compra:");
let formaPagamento = prompt("Escolha a forma de pagamento:\n1 - Dinheiro/PIX (10% de desconto)\n2 - Débito (5% de desconto)\n3 - Crédito (Sem desconto)");

let valorFinal;

switch (formaPagamento) {
    case 1:
        valorFinal = valorCompra * 0.90; // 10% de desconto
        console.log(`Pagamento no Dinheiro/PIX. Valor final: R$ ${valorFinal.toFixed(2)}`);
        break;
    case 2:
        valorFinal = valorCompra * 0.95; // 5% de desconto
        console.log(`Pagamento no Débito. Valor final: R$ ${valorFinal.toFixed(2)}`);
        break;
    case 3:
        valorFinal = valorCompra; // Sem desconto
        console.log(`Pagamento no Crédito. Valor final: R$ ${valorFinal.toFixed(2)}`);
        break;
    default:
        console.log("Opção inválida. Escolha entre 1, 2 ou 3.");
}
