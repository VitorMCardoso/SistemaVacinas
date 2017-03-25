/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  vitor
 * Created: Mar 24, 2017
 */

CREATE TABLE paciente
(
  id int auto_increment,
  nome character varying (20) NOT NULL,
  sobrenome character varying (20) NOT NULL,
  email character varying (30) NOT NULL,
  senha character varying (20) NOT NULL,
  rg character varying (15) NOT NULL,
  cpf character varying (15) NOT NULL,
  endereco character varying (30) NOT NULL,
  ativo character (2) NOT NULL,
  CONSTRAINT pk_paciente_id PRIMARY KEY (id)
);

CREATE TABLE agendamento
(
  id int auto_increment,
  datadose date NOT NULL,
  idpaciente int NOT NULL,
  idvacinas int NOT NULL,
  ativo boolean not null,
  CONSTRAINT pk_agendamento_id PRIMARY KEY (id),
  CONSTRAINT fk_paciente_id FOREIGN KEY (idpaciente) REFERENCES paciente (id) on delete cascade on update cascade,
  CONSTRAINT fk_vacinas_id FOREIGN KEY (idvacinas) REFERENCES vacinas (id) on delete cascade on update cascade
);

select * from agendamento;


CREATE TABLE vacinas
(
  id int auto_increment,
  datavalidade date NOT NULL,
  datafabricacao date NOT NULL,
  nome character varying(100) NOT NULL,
  tipo character varying(20) NOT NULL,
  quantidade numeric(5,0) NOT NULL,
  lote character varying(25) NOT NULL,
  idlaboratorio numeric(5,0) NOT NULL,
  ativo character(2) NOT NULL,
  CONSTRAINT pk_vacinas_id PRIMARY KEY (id)
);

CREATE TABLE virtualizacao
(
id int auto_increment,
dataCriacao date NOT NULL,
dataAtualizacao date NOT NULL,
idPaciente int NOT NULL,
CONSTRAINT pk_virtualizacao_id PRIMARY KEY (id),
CONSTRAINT fk_pacienteVirt_id FOREIGN KEY (idPaciente) REFERENCES paciente (id) on delete cascade on update cascade
);


CREATE TABLE laboratorio
(
  id int auto_increment,
  razaoSocial varchar (100)NOT NULL,
  cnpj varchar (25)NOT NULL,
  registroEstadual varchar (25) NOT NULL,
  nomeFantasia varchar (100) NOT NULL,
  telefone varchar (25) NOT NULL,
  site varchar (50),
  cep varchar (15) NOT NULL,
  logradouro varchar (50) NOT NULL,
  numero varchar (6) NOT NULL,
  bairro varchar (50) NOT NULL,
  cidade varchar (50) NOT NULL,
  estado varchar (50) NOT NULL,
  ativo boolean NOT NULL,
  CONSTRAINT pk_laboratorio_id PRIMARY KEY (id)
);

CREATE table usuario
(
  id int auto_increment,
  nome varchar (50) NOT NULL,
  email varchar (50) NOT NULL,
  login varchar (50) NOT NULL,
  senha varchar (16) NOT NULL,
  cargo varchar (50) NOT NULL,
  rg varchar (25) NOT NULL,
  cpf varchar (25) NOT NULL,
  endereco varchar (50) NOT NULL,
  ativo boolean NOT NULL,
  CONSTRAINT pk_usuario_id PRIMARY KEY (id)
);

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

