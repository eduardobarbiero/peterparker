CREATE DATABASE PETER_PARKER;

USE PETER_PARKER;


CREATE TABLE IF NOT EXISTS CARROS(
  carro_id int(11) auto_increment not null,
  placa varchar(30),
  cor varchar(30),
  PRIMARY KEY(carro_id)
);

CREATE TABLE IF NOT EXISTS TICKETS(
  ticket_id int(11) auto_increment not null,
  carro_id int(11),
  PRIMARY KEY(ticket_id),
  FOREIGN KEY(carro_id) REFERENCES Carros(carro_id)  
);

CREATE TABLE IF NOT EXISTS DISPOSITIVOS(
  dispositivo_id int(11) auto_increment not null,
  localizacao varchar(80),
  descricao varchar(80),
  PRIMARY KEY(dispositivo_id)  
);

CREATE TABLE IF NOT EXISTS TICKET_DISPOSITIVOS(
  id int(11) auto_increment not null,
  dispositivo_id int(11),
  ticket_id int(11),
  data datetime,
  PRIMARY KEY(id),
  FOREIGN KEY(dispositivo_id) REFERENCES Dispositivos(dispositivo_id),
  FOREIGN KEY(ticket_id) REFERENCES Tickets(ticket_id)
);