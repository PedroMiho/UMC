create database sistemas;
use sistemas;

create table usuarios (
	id int auto_increment primary key,
    nome varchar (100),
    sobrenome varchar (100),
    email varchar (100),
    senha varchar (100)
);

select * from usuarios