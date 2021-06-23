CREATE DATABASE escola;

/*Crie um banco de dados para um registro de uma escola, onde o sistema trabalhará com as informações dos estudantes deste registro dessa escola. 
Crie uma tabela estudantes e utilizando a habilidade de abstração e determine 5 atributos relevantes dos estudantes para se trabalhar com o serviço dessa escola.
Popule esta tabela com até 8 dados;
Faça um select que retorne o/as estudantes  com a nota maior do que 7.
Faça um select que retorne o/as estudantes  com a nota menor do que 7.
Ao término atualize um dado desta tabela através de uma query de atualização.*/

USE escola;

CREATE TABLE estudante(
id INT (8),
nome VARCHAR (30) NOT NULL,
serie VARCHAR (30) NOT NULL,
professora VARCHAR (30) NOT NULL,
nota INT NOT NULL, 
PRIMARY KEY (id)
);

INSERT INTO estudante VALUES (1, "Gabriele", "5 serie", "Silvia", 6);
INSERT INTO estudante VALUES (2, "Joana", "6 serie", "Paola", 5);
INSERT INTO estudante VALUES (3, "Amelie", "1 serie", "Carol", 10);
INSERT INTO estudante VALUES (4, "Julia", "8 serie", "Tula", 7);
INSERT INTO estudante VALUES (5, "Letícia", "2 serie", "Malu", 8);
INSERT INTO estudante VALUES (6, "Beatriz", "6 serie", "Paola", 4);
INSERT INTO estudante VALUES (7, "Talu", "1 serie", "Carol", 8);
INSERT INTO estudante VALUES (8, "Junior", "7 serie", "Lucia", 6);

SELECT * FROM estudante WHERE nota > 7;
SELECT * FROM estudante WHERE nota < 7;

UPDATE estudante SET nota = 8 where id = 2;
select * from estudante;
