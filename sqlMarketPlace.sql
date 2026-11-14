CREATE DATABASE marketPlace;
USE marketPlace;

CREATE TABLE vendedor (
    id_vendedor INT PRIMARY KEY,
    nome_vendedor VARCHAR(50),
    avaliacao INT
);

CREATE TABLE produto (
    id_produto INT PRIMARY KEY,
    nome_produto VARCHAR(50),
    quantidade INT,
    preco DECIMAL(10,2)
);