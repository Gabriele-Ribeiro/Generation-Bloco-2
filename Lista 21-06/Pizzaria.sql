CREATE DATABASE db_pizzaria_legal;

USE db_pizzaria_legal;

CREATE TABLE tb_pizza(
	id_pizza INT AUTO_INCREMENT NOT NULL,
    tipo VARCHAR(10) NOT NULL,
    borda VARCHAR (10) NOT NULL,
    PRIMARY KEY (id_pizza)
);

CREATE TABLE tb_categoria(
	id_categoria INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(100) NOT NULL,
    sabor VARCHAR(50) NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    fk_pizza INT,
    PRIMARY KEY (id_categoria),
    FOREIGN KEY (fk_pizza) REFERENCES tb_pizza(id_pizza)
);

INSERT INTO tb_pizza(tipo, borda) VALUES ("Doce", "Salgada");
INSERT INTO tb_pizza(tipo, borda) VALUES ("Salgada", "Salgada");
INSERT INTO tb_pizza(tipo, borda) VALUES ("Salgada", "Doce");
INSERT INTO tb_pizza(tipo, borda) VALUES ("Doce", "Doce");
INSERT INTO tb_pizza(tipo, borda) VALUES ("Salgada", "Salgada");

INSERT INTO tb_categoria(nome, sabor, preco, fk_pizza) VALUES ("Gabriele", "Chocolate com banana", 45.0, 4);
INSERT INTO tb_categoria(nome, sabor, preco, fk_pizza) VALUES ("Amelie", "Margerita", 50.0, 2);
INSERT INTO tb_categoria(nome, sabor, preco, fk_pizza) VALUES ("Lucia", "4 queijos", 65.5, 4);
INSERT INTO tb_categoria(nome, sabor, preco, fk_pizza) VALUES ("Maria", "Romeu e Julieta", 30.0, 2);
INSERT INTO tb_categoria(nome, sabor, preco, fk_pizza) VALUES ("Aurora", "Portuguesa", 55.0, 4);
INSERT INTO tb_categoria(nome, sabor, preco, fk_pizza) VALUES ("Amanda", "Calabresa", 70.0, 3);
INSERT INTO tb_categoria(nome, sabor, preco, fk_pizza) VALUES ("Charles", "Bacon", 60.5, 1);
INSERT INTO tb_categoria(nome, sabor, preco, fk_pizza) VALUES ("Paulo", "Batata palha", 85.0, 2);

SELECT * FROM tb_categoria WHERE preco > 45.0;

SELECT * FROM tb_categoria WHERE preco > 29.0 AND preco < 60.0;

SELECT * FROM tb_categoria WHERE sabor LIKE 'c%';

SELECT * FROM tb_categoria 
	INNER JOIN tb_pizza on tb_pizza.id_pizza = tb_categoria.fk_pizza;
    
SELECT tb_categoria.sabor FROM tb_categoria
		INNER JOIN tb_pizza on tb_pizza.id_pizza = tb_categoria.fk_pizza
        WHERE tb_pizza.tipo LIKE "Salgada"