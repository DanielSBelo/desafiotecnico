CREATE DATABASE desafiotecnico;

CREATE TABLE IF NOT EXISTS pessoas (
  id_pessoas int NOT NULL AUTO_INCREMENT,
  nome varchar(45) NOT NULL,
  sexo varchar(15) DEFAULT NULL,
  endereco varchar(100) NOT NULL,
  email varchar(60) DEFAULT NULL,
  data_nascimento varchar(10) NOT NULL,
  naturalidade varchar(45) DEFAULT NULL,
  nacionalidade varchar(45) DEFAULT NULL,
  cpf varchar(14) NOT NULL,
  data_cadastro datetime DEFAULT NULL,
  data_atualizacao datetime DEFAULT NULL,
  PRIMARY KEY (id_pessoas)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci