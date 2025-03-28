const express = require('express');
const connection = require('./db');
const app = express();
const port = 3000;

app.use(express.urlencoded({ extended: true }));
app.use(express.static('public'));

app.get('/', (req, res) => {
    res.sendFile(__dirname + '/public/index.html');
});

// Rota vulnerável a SQL Injection
app.post('/login', (req, res) => {
    const { username, password } = req.body;
    const query = `SELECT * FROM users WHERE username = '${username}' AND password = '${password}'`;

    connection.query(query, (err, results) => {
        if (err) {
            res.status(500).send('Erro no servidor.');
            return;
        }

        if (results.length > 0) {
            res.send('Login bem-sucedido! Bem-vindo(a), ' + results[0].username);
        } else {
            res.send('Falha no login. Verifique suas credenciais.');
        }
    });
});

app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}`);
});
