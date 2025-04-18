CREATE DATABASE sistema;
USE sistema;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    senha VARCHAR(100)
);

DROP database sistema;

SELECT * FROM usuario;