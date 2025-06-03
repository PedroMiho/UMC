const form = document.getElementById('loginForm');

form.addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    const dados = {
        email: email,
        senha: senha
    };

    fetch('http://localhost:8080/usuarios/login', {  // Substituir pela sua rota de autenticação
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(dados)
    })
    .then(response => {
        const mensagem = document.getElementById('mensagem');
        if (response.ok) {
            mensagem.innerText = "✅ Login realizado com sucesso!";
            mensagem.classList.remove('text-danger');
            mensagem.classList.add('text-success');

        } else {
            mensagem.innerText = "❌ Email ou senha inválidos!";
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
