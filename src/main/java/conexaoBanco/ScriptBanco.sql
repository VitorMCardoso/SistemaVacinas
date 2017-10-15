/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  vitor
 * Created: Mar 24, 2017
 */

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
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=latin1

CREATE TABLE `dataValFab` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dataValidade` date DEFAULT NULL,
  `dataFabricacao` varchar(45) DEFAULT NULL,
  `idLote` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dataValFab___fkLote` (`idLote`),
  CONSTRAINT `dataValFab___fkLote` FOREIGN KEY (`idLote`) REFERENCES `loteVacinas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1

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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1

CREATE TABLE `loteVacinas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quantidadeVac` int(11) DEFAULT NULL,
  `idLaboratorio` int(11) DEFAULT NULL,
  `idVacinas` int(11) DEFAULT NULL,
  `ativo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idLaboratorio` (`idLaboratorio`),
  KEY `fk_Vacinas_1_idx` (`idVacinas`),
  CONSTRAINT `fk_Vacinas_1` FOREIGN KEY (`idVacinas`) REFERENCES `vacinas` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `loteVacinas_ibfk_1` FOREIGN KEY (`idLaboratorio`) REFERENCES `laboratorio` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1

CREATE TABLE `pedidoCompra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `quantidadeVac` int(11) NOT NULL,
  `idLaboratorio` int(11) NOT NULL,
  `idVacinas` int(11) NOT NULL,
  `ativo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idLaboratorio` (`idLaboratorio`),
  KEY `idVacinas` (`idVacinas`),
  CONSTRAINT `pedidoCompra_ibfk_1` FOREIGN KEY (`idLaboratorio`) REFERENCES `laboratorio` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `pedidoCompra_ibfk_2` FOREIGN KEY (`idVacinas`) REFERENCES `vacinas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1

CREATE TABLE `vacinas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1

