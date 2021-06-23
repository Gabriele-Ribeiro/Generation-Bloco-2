CREATE DATABASE e_commerce;

/*Crie um banco de dados para um e commerce, onde o sistema trabalhará com as informações dos produtos deste ecommerce. 
Crie uma tabela produtos e utilizando a habilidade de abstração e determine 5 atributos relevantes dos produtos para se trabalhar com o serviço deste ecommerce.
Popule esta tabela com até 8 dados;
Faça um select que retorne os produtos com o valor maior do que 500.
Faça um select que retorne os produtos com o valor menor do que 500.
Ao término atualize um dado desta tabela através de uma query de atualização.*/

USE e_commerce;

CREATE TABLE produto(
id INT (8),
objeto VARCHAR (30) NOT NULL,
quantidade INT NOT NULL,
preco DECIMAL (10, 2),
pagamento VARCHAR (30) NOT NULL,
PRIMARY KEY (id)
);

INSERT INTO produto VALUES (1, "Camiseta", 2, 200, "Cartão de crédito");
INSERT INTO produto VALUES (2, "Calça", 1, 300, "Cartão de débito");
INSERT INTO produto VALUES (3, "Sapato", 5, 580, "Dinheiro");
INSERT INTO produto VALUES (4, "Creme corporal", 2, 150, "Pix");
INSERT INTO produto VALUES (5, "Capa de chuva", 6, 600, "Cartão de débito");
INSERT INTO produto VALUES (6, "Blusa", 2, 550, "Pix");
INSERT INTO produto VALUES (7, "Short", 3, 210, "Dinheiro");
INSERT INTO produto VALUES (8, "Chápeu", 1, 150, "Cartão de crédito");

SELECT * FROM produto WHERE preco > 500;
SELECT * FROM produto WHERE preco < 500;

UPDATE produto SET objeto = "Boné" where id = 8;
select * from produto;
