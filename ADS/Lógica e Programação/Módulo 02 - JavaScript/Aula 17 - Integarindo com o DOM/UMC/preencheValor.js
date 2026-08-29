// Mapeia os produtos aos seus respectivos valores
const precos = {
    Cenoura: "40.00",
    Chocolate: "30.00",
    Aipim: "25.00",
    Coco: "25.00",
    Maracujá: "30.00"
};

// Seleciona os elementos do formulário
const produtoSelect = document.getElementById("produto");
const valorInput = document.getElementById("valor");

// Adiciona um evento sempre que o usuário trocar um produto
// O evento change é acionado quando um elemento de formulário 
// (como um <select>, <input> ou <textarea>) perde o foco após ter seu valor alterado.
//Mostrar o HTML
function alterar() {
    const produtoSelecionado = produtoSelect.value;
    console.log(precos[produtoSelecionado]);
    if (precos[produtoSelecionado]) {
        valorInput.value = `${precos[produtoSelecionado]}`;
    } else {
        valorInput.value = ""; // Limpa o campo caso não haja um valor associado
    }
}

