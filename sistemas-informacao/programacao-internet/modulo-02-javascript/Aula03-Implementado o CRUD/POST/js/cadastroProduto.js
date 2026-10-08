// Seleciona o formulário pela classe "product-form".
const formulario = document.querySelector(".product-form")

// Seleciona o botão de envio dentro do formulário.
const botaoCadastrar = formulario.querySelector('button[type="submit"]')

// Seleciona a área de mensagens pelo ID "mensagemCadastro".
// O símbolo # indica que estamos procurando um ID.
const mensagemCadastro = document.querySelector("#mensagemCadastro")

// "evento" é o objeto passado automaticamente pelo navegador.
// Ele permite consultar e controlar o evento de envio.
formulario.addEventListener("submit", async (evento) => {
    // Usa o objeto recebido para impedir o comportamento padrão:
    // enviar o formulário e recarregar a página.
    evento.preventDefault()

    // Se o botão estiver desabilitado OU o formulário estiver inválido,
    // encerra a função.
    if (botaoCadastrar.disabled || !formulario.reportValidity()) return

    const produto = {
        nome: document.querySelector("#nome").value.trim(),
        categoria: document.querySelector("#categoria").value,
        preco: Number(document.querySelector("#preco").value),
        estoque: Number(document.querySelector("#estoque").value),
        descricao: document.querySelector("#descricao").value.trim()
    }

    // Se o nome estiver vazio, entra no bloco.
    // O ! significa "não": aqui, verifica se não há nome.
    if (!produto.nome) {

        // Mostra a mensagem com a aparência de erro do Bootstrap.
        mensagemCadastro.className = "alert alert-danger"

        // Define o texto que aparece para o usuário.
        mensagemCadastro.textContent = "Informe o nome do produto."

        // Encerra a função antes de enviar o cadastro.
        return
    }

    botaoCadastrar.disabled = true
    mensagemCadastro.className = "alert d-none"

    try {
        // Recebe o produto cadastrado, incluindo o ID gerado.
        const produtoCadastrado = await cadastrarProduto(produto)

        console.log("Produto cadastrado:", produtoCadastrado)
        console.log("ID gerado:", produtoCadastrado.id)

        formulario.reset()

    } catch (erro) {
        console.error(erro)

        mensagemCadastro.className = "alert alert-danger"
        mensagemCadastro.textContent =
            "Não foi possível cadastrar. Verifique se o JSON Server está em execução."

    } finally {
        botaoCadastrar.disabled = false
    }




})

// Envia os dados do formulário para cadastrar um novo produto.
async function cadastrarProduto(produto){
    const response = await fetch("http://localhost:3000/produtos", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(produto)
    })

    if (!response.ok){
        throw new Error("Erro ao cadastrar produto")
    }

    return await response.json()
}