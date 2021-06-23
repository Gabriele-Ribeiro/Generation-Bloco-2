CREATE DATABASE db_cidade_das_frutas;

 USE db_cidade_das_frutas;
 
 CREATE TABLE tb_categoria (
 id_categoria INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 tipo VARCHAR (100) NOT NULL,
 sabor VARCHAR (100)
 );
 
  CREATE TABLE tb_produto(
  id_produto INT NOT NULL AUTO_INCREMENT,
  nome INT NOT NULL,
  peso DECIMAL (10,2) NOT NULL,
  preco DECIMAL (10,2) NOT NULL,
  fk_categoria INT,
  PRIMARY KEY (id_produto),
  FOREIGN KEY (fk_categoria) REFERENCES tb_categoria (id_categoria)
  );
  
INSERT INTO tb_categoria (tipo, sabor) VALUES ("Legume", "Amargo");
INSERT INTO tb_categoria (tipo, sabor) VALUES ("Fruta", "Azedo");
INSERT INTO tb_categoria (tipo, sabor) VALUES ("Fruta", "Doce");
INSERT INTO tb_categoria (tipo, sabor) VALUES ("Legume" ,"Doce");

INSERT INTO tb_produto (nome, peso, preco, fk_categoria) VALUES ("Batata", 1.0, 7.00, 3);
INSERT INTO tb_produto (nome, peso, preco, fk_categoria) VALUES ("Morango", 3.0, 10.00, 2);
INSERT INTO tb_produto (nome, peso, preco, fk_categoria) VALUES ("Tomate", 3.0, 60.00, 3);
INSERT INTO tb_produto (nome, peso, preco, fk_categoria) VALUES ("Manga", 5.0, 55.00, 2);
INSERT INTO tb_produto (nome, peso, preco, fk_categoria) VALUES ("Amora", 1.0, 10.00, 1);
INSERT INTO tb_produto (nome, peso, preco, fk_categoria) VALUES ("Pepino", 1.0, 8.00, 3);
INSERT INTO tb_produto (nome, peso, preco, fk_categoria) VALUES ("Banana", 2.0, 5.00, 5);
INSERT INTO tb_produto (nome, peso, preco, fk_categoria) VALUES ("Laranja", 1.5, 9.00, 6);

SELECT * FROM tb_produto WHERE preco >50.00;

SELECT * FROM tb_produto WHERE preco > 3 AND  preco <60
ORDER BY tb_produto.nome DESC;

SELECT * FROM tb_produto WHERE nome LIKE "C%";

SELECT tb_produto.nome, tb_categoria.sabor
FROM tb_categoria 
INNER JOIN tb_produto
ON tb_categoria.id_categoria = tb_produto.fk_categoria;
	  

SELECT tb_produto.nome, tb_categoria.sabor 
FROM tb_categoria
INNER JOIN tb_produto 
ON tb_categoria.id_categoria = tb_produto.fk_categoria
WHERE tb_categoria.sabor LIKE "Doce"
ORDER BY tb_produto.nome ASC;
	  