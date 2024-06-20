CREATE DATABASE db_clinica_a3;
USE db_clinica_a3;

CREATE TABLE Administradores (
    ID_adm VARCHAR(50) PRIMARY KEY NOT NULL,
    Senha VARCHAR(50) NOT NULL,
	is_admin BOOLEAN NOT NULL
);
-- drop table Administradores;
INSERT INTO Administradores (ID_adm, is_admin, Senha) VALUES("adm" , 1,"Egv&2w6w2");
select*from Administradores;


-- Tabela Medicos
CREATE TABLE Medicos (
    ID_med INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(100) not null,
    Senha VARCHAR(50) not null,
    Especialidade VARCHAR(100) not null,
    is_medico BOOLEAN NOT NULL
);

-- drop table Medicos;	
select * from Medicos;

-- Tabela Pacientes
CREATE TABLE Pacientes (
    ID_pac INT PRIMARY KEY AUTO_INCREMENT,
    Senha VARCHAR(50) NOT NULL,
    Nome VARCHAR(100) NOT NULL,
    Idade INT NOT NULL,
    Telefone VARCHAR(20) NOT NULL,
    CPF VARCHAR(14) NOT NULL,
    is_paciente BOOLEAN NOT NULL
);

-- drop table Pacientes;
select * from Pacientes;

-- Tabela Consultas
CREATE TABLE `db_clinica_a3`.`consulta` (
  `ID_con` INT NOT NULL AUTO_INCREMENT,
  `Data` VARCHAR(45) NOT NULL,
  `Hora` VARCHAR(45) NOT NULL,
  `fk_id_med` INT NOT NULL,
  `fk_id_pac` INT NOT NULL,
  PRIMARY KEY (`ID_con`),
  INDEX `fk_id_pac_idx` (`fk_id_pac` ASC) VISIBLE,
  INDEX `fk_id_med_idx` (`fk_id_med` ASC) VISIBLE,
  CONSTRAINT `fk_id_pac`
    FOREIGN KEY (`fk_id_pac`)
    REFERENCES `db_clinica_a3`.`pacientes` (`ID_pac`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_med`
    FOREIGN KEY (`fk_id_med`)
    REFERENCES `db_clinica_a3`.`medicos` (`ID_med`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- drop table consulta;
select * from consulta;

-- Tabela Exames
CREATE TABLE Exames (
	ID_exam INT NOT NULL AUTO_INCREMENT,
    fk_id_pac INT NOT NULL,
    fk_id_med INT NOT NULL,
    tipo_exame VARCHAR(50),
    Data VARCHAR(50),
	FOREIGN KEY (fk_id_pac) REFERENCES Pacientes(ID_pac),
    FOREIGN KEY (fk_id_med) REFERENCES Medicos(ID_med),
    PRIMARY KEY (ID_exam)
);

-- drop table Exames;
select * from Exames;
