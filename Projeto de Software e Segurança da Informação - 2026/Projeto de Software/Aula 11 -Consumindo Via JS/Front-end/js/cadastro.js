const form = document.querySelector("#formProduto");


// O form addEventListener está dizendo quando o formulário for enviado execute essa função
// O Function event recebe o evento de envio do formulário
form.addEventListener('submit' , function(event) {
    // Impede o comportamente padrão da página, que seria:
    // Recarregar a página
    // Enviar os dados para o action definido no HTML
    event.preventDefault() 

    const nomeProduto = document.querySelector("#nome").value
    const marca = document.querySelector("#marca").value
    const tamanho = document.querySelector("#tamanho").value
    const preco = parseFloat(document.querySelector("#preco").value)
    const quantidade = parseInt(document.querySelector("#quantidade").value)

    const dados = {
        nomeProduto: nomeProduto,
        marca: marca,
        tamanho: tamanho,
        preco: preco,
        quantidade: quantidade
    }

    const mensagem = document.getElementById('mensagem');

    
    fetch('http://localhost:8080/roupa', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json' 
        },
        body: JSON.stringify(dados)
    })
    
    .then(response => {
        console.log(dados)
        
        
        if (response.ok){
            mensagem.innerHTML = 
                `
                <div class="alert alert-success">
                    Produto cadastrado com sucesso!
                </div>
                `;
        } else {
            // ❌ Erro da API
            mensagem.innerHTML = `
                <div class="alert alert-danger">
                    Erro ao cadastrar produto (Status: ${response.status}) ❌
                </div>
            `;
        }
            
    })
    .catch(erro => {

         mensagem.innerHTML = `
            <div class="alert alert-danger">
               Falha na comunicação com o servidor ${erro}
            </div>
        `;

    })

    form.reset()

        


})