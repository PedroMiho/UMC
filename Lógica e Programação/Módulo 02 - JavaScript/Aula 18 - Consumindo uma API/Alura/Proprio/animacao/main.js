// Função assíncrona para buscar o endereço a partir do CEP informado
async function buscaEndereço(cep) {

    // Seleciona o elemento HTML que exibirá mensagens de erro
    var mensagemErro = document.querySelector("#erro");
    // Limpa qualquer mensagem de erro anterior
    mensagemErro.innerHTML = '';

    try {
        // Faz uma requisição à API ViaCEP para buscar os dados do CEP informado
        let consultaCEP = await fetch(`https://viacep.com.br/ws/${cep}/json/`);
        // Converte a resposta da API para um objeto JSON
        let consultaCEPJSON = await consultaCEP.json();

        // Se a API retornar um erro (CEP inexistente), lança um erro
        if (consultaCEPJSON.erro) {
            throw Error('CEP inexistente');
        }

        // Chama a função para preencher os campos do formulário com os dados do CEP
        validacoesDeCampos(consultaCEPJSON);

        // Retorna os dados do CEP
        return consultaCEPJSON;

    }   
    catch (erro) { 
        // Exibe uma mensagem de erro no HTML caso o CEP seja inválido
        mensagemErro.innerHTML = `<p> CEP Inválido, Tente Novamente !! </p>`;
        // Exibe o erro no console para depuração
        console.log(erro);
    }
}

// Seleciona o campo de entrada do CEP no formulário
const cep = document.querySelector("#cep");

// Adiciona um evento que escuta quando o usuário sai do campo de CEP (focusout)
cep.addEventListener("focusout", (evento) => {
    // Obtém o valor do CEP digitado pelo usuário
    let cep = evento.target;
    // Chama a função para buscar o endereço com base no CEP digitado
    buscaEndereço(cep.value);
});

// Função para preencher os campos do formulário com os dados do endereço obtidos da API
function validacoesDeCampos(cepDigitado) {
    // Seleciona os campos do formulário onde os dados do endereço serão inseridos
    const endereco = document.querySelector("#endereco");
    const numero = document.querySelector("#numero"); // Este campo não é preenchido pela API
    const bairro = document.querySelector("#bairro");
    const cidade = document.querySelector("#cidade");
    const estado = document.querySelector("#estado");

    // Preenche os campos com os dados obtidos da API
    endereco.value = cepDigitado.logradouro;
    bairro.value = cepDigitado.bairro;
    cidade.value = cepDigitado.localidade;
    estado.value = cepDigitado.uf;
}
