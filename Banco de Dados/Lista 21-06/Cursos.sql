CREATE DATABASE db_cursoDaMinhaVida;

USE db_cursoDaMinhaVida;

CREATE TABLE tb_categoria (
id_categ INT AUTO_INCREMENT,
curso VARCHAR (50) NOT NULL,
PRIMARY KEY (id_categ)
);

CREATE TABLE tb_curso (
id_curso INT AUTO_INCREMENT,
nome VARCHAR (50) NOT NULL,
duracao INT NOT NULL,
preco INT NOT NULL,
fk_curso INT,
	PRIMARY KEY (id_curso),
	FOREIGN KEY (fk_curso) REFERENCES tb_categoria(id_categ)
);

INSERT INTO tb_categoria (curso) VALUES ("Costura");
INSERT INTO tb_categoria (curso) VALUES ("Pintura");
INSERT INTO tb_categoria (curso) VALUES ("Arte Digital");

INSERT INTO tb_curso (nome, duracao, preco, fk_curso) VALUES ("Gabriele", 300, 1005, 1);
INSERT INTO tb_curso (nome, duracao, preco, fk_curso) VALUES ("Amelie", 150, 300, 2);
INSERT INTO tb_curso (nome, duracao, preco, fk_curso) VALUES ("Aurora", 350, 2000, 3);
INSERT INTO tb_curso (nome, duracao, preco, fk_curso) VALUES ("Maria", 200, 250, 3);
INSERT INTO tb_curso (nome, duracao, preco, fk_curso) VALUES ("Lúcia", 350, 4500, 1);
INSERT INTO tb_curso (nome, duracao, preco, fk_curso) VALUES ("Joana", 110, 500, 1);
INSERT INTO tb_curso (nome, duracao, preco, fk_curso) VALUES ("Paulo", 120, 150, 2);
INSERT INTO tb_curso (nome, duracao, preco, fk_curso) VALUES ("André", 365, 5000, 2);

SELECT * FROM tb_curso WHERE preco > 50;

SELECT * FROM tb_curso WHERE preco > 3 AND preco < 60;

SELECT * FROM tb_curso WHERE nome LIKE "L%";

SELECT tb_curso.nome, tb_curso.duracao, tb_curso.preco, tb_categoria.curso
FROM tb_curso
INNER JOIN tb_categoria
ON tb_categoria.id_categ = tb_curso.fk_curso
ORDER BY tb_categoria.curso ASC;

SELECT tb_curso.nome, tb_curso.duracao, tb_curso.preco, tb_categoria.curso
FROM tb_curso
INNER JOIN tb_categoria
ON tb_categoria.id_categ = tb_curso.fk_curso
WHERE tb_categoria.curso LIKE "Costura"
ORDER BY tb_categoria.curso ASC;
