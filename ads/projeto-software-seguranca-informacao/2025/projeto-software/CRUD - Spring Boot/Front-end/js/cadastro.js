const form = document.getElementById('cadastroForm');

form.addEventListener('submit', function(event) {
    event.preventDefault();

    const nome = document.getElementById('nome').value;
    const sobrenome = document.getElementById('sobrenome').value;
    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    const dados = {
        nome: nome,
        sobrenome: sobrenome,
        email: email,
        senha: senha
    };

    fetch('http://localhost:8080/usuarios', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dados)
    })
    .then(response => {
        const mensagem = document.getElementById('mensagem');
        if (response.ok) {
            mensagem.innerText = "✅ Usuário cadastrado com sucesso!";
            mensagem.classList.remove('text-danger');
            mensagem.classList.add('text-success');
            form.reset();
        }
        else if (response.status === 409) {  // conflito: email já existe
            mensagem.innerText = "❌ E-mail já cadastrado!";
            mensagem.classList.remove('text-success');
            mensagem.classList.add('text-danger');
        } else {
            mensagem.innerText = "❌ Erro ao cadastrar usuário.";
            mensagem.classList.remove('text-success');
            mensagem.classList.add('text-danger');
        }
    })
    .catch(error => {
        const mensagem = document.getElementById('mensagem');
        mensagem.innerText = "❌ Erro na requisição: " + error.message;
        mensagem.classList.remove('text-success');
        mensagem.classList.add('text-danger');
    });
});
