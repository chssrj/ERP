CREATE TABLE CARGO(
  id bigint NOT NULL,
  descricao varchar(150),
  data_inclusao date,
  CONSTRAINT pk_cargo PRIMARY KEY (id)
);

CREATE SEQUENCE cargo_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

INSERT INTO CARGO VALUES (1,'PROGRAMADOR','2016-01-01');

CREATE TABLE DEPARTAMENTO(
  id bigint NOT NULL,
  descricao varchar(150),
  data_inclusao date,
  CONSTRAINT pk_departamento PRIMARY KEY(id)
);

CREATE SEQUENCE departamento_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;

CREATE TABLE FUNCIONARIO(
  id bigint NOT NULL,
  id_cargo bigint,
  id_departamento bigint,
  nome varchar(200) NOT NULL ,
  cpf varchar(15),
  telefone varchar(13),
  celular varchar(15),
  numero_cpts int,
  serie_cpts int,
  numero_nis varchar(200),
  data_emissao_ctps date,
  data_nascimento date,
  data_admissao date,
  data_demissao date,
  CONSTRAINT pk_funcionario PRIMARY KEY(id),
  CONSTRAINT fk_cargo FOREIGN KEY(id_cargo) REFERENCES CARGO (id),
  CONSTRAINT fk_departamento FOREIGN KEY(id_departamento) REFERENCES DEPARTAMENTO (id)
);

CREATE SEQUENCE funcionario_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 START 1 CACHE 1;
