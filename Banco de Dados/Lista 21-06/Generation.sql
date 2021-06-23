CREATE DATABASE db_generation_game_online;

USE db_generation_game_online;

CREATE TABLE tb_classe(
id_classe INT AUTO_INCREMENT,
tribo VARCHAR (20) NOT NULL,
PRIMARY KEY (id_classe)
);

CREATE TABLE tb_personagem(
id_personagem INT AUTO_INCREMENT,
nome VARCHAR (20) NOT NULL,
poder VARCHAR (100),
ataque INT NOT NULL,
defesa INT NOT NULL,
nivel INT NOT NULL,
fk_personagem INT,
PRIMARY KEY (id_personagem),
FOREIGN KEY (fk_personagem) REFERENCES tb_classe(id_classe)
);

INSERT INTO tb_classe (tribo) VALUES ("Terra");
INSERT INTO tb_classe (tribo) VALUES ("Água");
INSERT INTO tb_classe (tribo) VALUES ("Água");
INSERT INTO tb_classe (tribo) VALUES ("Ar");
INSERT INTO tb_classe (tribo) VALUES ("Terra");
INSERT INTO tb_classe (tribo) VALUES ("Fogo");
INSERT INTO tb_classe (tribo) VALUES ("Fogo");

INSERT INTO tb_personagem (nome, poder, ataque, defesa, nivel, fk_personagem) VALUES ("Toph","Criar blocos de terra", 5000, 3500, 7, 2);
INSERT INTO tb_personagem (nome, poder, ataque, defesa, nivel, fk_personagem) VALUES ("Katara","Curar", 2000, 5000, 7, 1);
INSERT INTO tb_personagem (nome, poder, ataque, defesa, nivel, fk_personagem) VALUES ("Korra","Congelar", 4500, 3000, 5, 5);
INSERT INTO tb_personagem (nome, poder, ataque, defesa, nivel, fk_personagem) VALUES ("Aang","Criar moinho de vento",5000, 5000, 8, 6);
INSERT INTO tb_personagem (nome, poder, ataque, defesa, nivel, fk_personagem) VALUES ("Kuei","Firmar-se na terra", 2000, 8000, 7, 7);
INSERT INTO tb_personagem (nome, poder, ataque, defesa, nivel, fk_personagem) VALUES ("Tio","Dobrar fogo", 6000, 7000, 9, 3);
INSERT INTO tb_personagem (nome, poder, ataque, defesa, nivel, fk_personagem) VALUES ("Zuko","Criar fogo", 6500, 6000, 8, 4);

SELECT * FROM tb_personagem WHERE ataque > 2000;

SELECT * FROM tb_personagem WHERE ataque > 1000 AND ataque < 2000;

SELECT * FROM tb_personagem WHERE nome like "C%";

SELECT * FROM tb_classe;

SELECT * FROM tb_personagem;

SELECT nome, poder "Curar" FROM tb_personagem;

SELECT tb_personagem.nome, tb_personagem.poder, tb_classe.tribo 
FROM tb_personagem 
INNER JOIN tb_classe
ON tb_classe.id_classe = tb_personagem.fk_personagem
ORDER BY tb_classe.tribo ASC;

SELECT tb_personagem.nome, tb_personagem.poder, tb_classe.tribo 
FROM tb_personagem 
INNER JOIN tb_classe
ON tb_classe.id_classe = tb_personagem.fk_personagem
WHERE tb_classe.tribo LIKE "Terra" 
ORDER BY tb_personagem.nome ASC;