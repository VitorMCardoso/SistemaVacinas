/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  vitor
 * Created: Mar 24, 2017
 */

CREATE TABLE `paciente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `sobrenome` varchar(20) NOT NULL,
  `login` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `endereco` varchar(30) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;


 CREATE TABLE `agendamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataDose` date NOT NULL,
  `quantidadeVac` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `idVacinas` int(11) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_paciente_id` (`idPaciente`),
  KEY `fk_vacinas_id` (`idVacinas`),
  CONSTRAINT `fk_paciente_id` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_vacinas_id` FOREIGN KEY (`idVacinas`) REFERENCES `vacinas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
SELECT * FROM sgv.usuario;

select * from agendamento;


CREATE TABLE `vacinas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataValidade` date NOT NULL,
  `dataFabricacao` date NOT NULL,
  `nome` varchar(100) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `quantidade` int(5) NOT NULL,
  `lote` varchar(25) NOT NULL,
  `idLaboratorio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vacinasLab_id` (`idLaboratorio`),
  CONSTRAINT `fk_vacinasLab_id` FOREIGN KEY (`idLaboratorio`) REFERENCES `laboratorio` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


CREATE TABLE virtualizacao
(
id int auto_increment,
dataCriacao date NOT NULL,
dataAtualizacao date NOT NULL,
idPaciente int NOT NULL,
CONSTRAINT pk_virtualizacao_id PRIMARY KEY (id),
CONSTRAINT fk_pacienteVirt_id FOREIGN KEY (idPaciente) REFERENCES paciente (id) on delete cascade on update cascade
);


CREATE TABLE `laboratorio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `razaoSocial` varchar(100) NOT NULL,
  `cnpj` varchar(25) NOT NULL,
  `registroEstadual` varchar(25) NOT NULL,
  `nomeFantasia` varchar(100) NOT NULL,
  `telefone` varchar(25) NOT NULL,
  `site` varchar(50) DEFAULT NULL,
  `cep` varchar(15) NOT NULL,
  `logradouro` varchar(50) NOT NULL,
  `numero` varchar(6) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `sobrenome` varchar(20) NOT NULL,
  `login` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `senha` varchar(16) NOT NULL,
  `cargo` varchar(25) NOT NULL,
  `rg` varchar(25) NOT NULL,
  `cpf` varchar(25) NOT NULL,
  `endereco` varchar(50) NOT NULL,
  `bairro` varchar(50) NOT NULL,
  `cidade` varchar(50) NOT NULL,
  `estado` varchar(50) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  `perfil` varchar(25) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


CREATE TABLE novosPedidos
(
  id int auto_increment,
  quantidade varchar (100)NOT NULL,
  dataPedido date NOT NULL,
  idLaboratorio int NOT NULL,
  idUsuario int NOT NULL,
  idVacinas int NOT NULL,
  CONSTRAINT pk_novosPedidos_id PRIMARY KEY (id),
  CONSTRAINT fk_laboratorioPed_id FOREIGN KEY (idLaboratorio) REFERENCES laboratorio (id) on delete cascade on update cascade,
  CONSTRAINT fk_usuarioPed_id FOREIGN KEY (idUsuario) REFERENCES usuario (id) on delete cascade on update cascade,
  CONSTRAINT fk_vacinasPed_id FOREIGN KEY (idVacinas) REFERENCES vacinas (id) on delete cascade on update cascade
);

