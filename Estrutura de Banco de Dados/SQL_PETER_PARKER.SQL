CREATE DATABASE PETER_PARKER;

USE PETER_PARKER;


CREATE TABLE IF NOT EXISTS CARRO(
  carro_id int(11) auto_increment not null,
  placa varchar(30),
  cor varchar(30),
  ativo bool,
  PRIMARY KEY(carro_id)
);

CREATE TABLE IF NOT EXISTS DISPOSITIVO(
  dispositivo_id int(11) auto_increment not null,
  localizacao varchar(80),
  descricao varchar(80),
  ativo bool,
  PRIMARY KEY(dispositivo_id)
);

CREATE TABLE IF NOT EXISTS TICKET(
  ticket_id int(11) auto_increment not null,
  carro_id int(11),
  hora_entrada DATETIME,
  hora_saida DATETIME,
  dispositivo_entrada int(11),
  dispositivo_saida int(11),
  PRIMARY KEY(ticket_id),
  FOREIGN KEY(carro_id) REFERENCES Carro(carro_id),
  FOREIGN KEY(dispositivo_entrada) REFERENCES Dispositivo(dispositivo_id),
  FOREIGN KEY(dispositivo_saida) REFERENCES Dispositivo(dispositivo_id)
);


