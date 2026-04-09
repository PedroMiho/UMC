create database loja;

use loja;

CREATE TABLE roupa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_produto VARCHAR(255),
    marca VARCHAR(255),
    tamanho VARCHAR(50),
    preco DOUBLE,
    quantidade INT
);

select * from roupa;	
