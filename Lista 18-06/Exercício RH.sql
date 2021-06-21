CREATE DATABASE db_RH;

/*Crie um banco de dados para um serviço de RH de uma empresa, onde o sistema trabalhará com as informações dos funcionaries desta empresa. 
Crie uma tabela de funcionaries e utilizando a habilidade de abstração e determine 5 atributos relevantes dos funcionaries para se trabalhar com o serviço deste RH.
Popule esta tabela com até 5 dados;
Faça um select que retorne os funcionaries com o salário maior do que 2000.
Faça um select que retorne os funcionaries com o salário menor do que 2000.
Ao término atualize um dado desta tabela através de uma query de atualização.*/

USE db_RH;

CREATE TABLE funcionarios (
    id INT (5),
    nome VARCHAR (50) NOT NULL,
    sobrenome VARCHAR (50) NOT NULL,
    idade INT (30), 
	funcao VARCHAR (30) NOT NULL,
    salario DECIMAL (10, 2),
    PRIMARY KEY (id)
    );

INSERT INTO funcionarios VALUES (1, "Gabriele","Ribeiro", 21 , "Desenvolvedora java", 4500); 
INSERT INTO funcionarios VALUES (2, "Amelie","Ribeiro", 5 , "Cachorra", 10000); 
INSERT INTO funcionarios VALUES (3, "Aurora","Ribeiro", 4 , "Gata", 10000); 
INSERT INTO funcionarios VALUES (4, "Ademilson","Oliveira", 53 , "Aposentado", 3000); 
INSERT INTO funcionarios VALUES (5, "Gesebel","Ribeiro", 47 , "Enfermeira", 2500);

SELECT * FROM funcionarios WHERE salario > 3000;
SELECT * FROM funcionarios WHERE salario < 3000;

UPDATE funcionarios SET nome = "Gabrita" WHERE id= 1;