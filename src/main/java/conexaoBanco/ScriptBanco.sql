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
  nome character varying(20) NOT NULL,
  sobrenome character varying(20) NOT NULL,
  email character varying(30) NOT NULL,
  senha character varying(20) NOT NULL,
  rg character varying(15) NOT NULL,
  cpf character varying(15) NOT NULL,
  endereco character varying(30) NOT NULL,
  ativo character(2) NOT NULL,
  CONSTRAINT pk_paciente_id PRIMARY KEY (id)
);


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

drop table agendamento;

select * from agendamento;