CREATE TABLE Alumnos_new(
	codigo INT, 
	nombre VARCHAR(100),
	dni VARCHAR(9), 
	CONSTRAINT claves PRIMARY KEY(codigo, dni));

CREATE TABLE Profesores_new(
	codigo INT PRIMARY KEY,
	nombre VARCHAR(100));

INSERT INTO Alumnos_new (codigo, nombre,dni)
	VALUES (1,'Maria','123456789');

INSERT INTO Alumnos_new (codigo, nombre,dni)
	VALUES (1,'Maria','113456789');


INSERT INTO Profesores_new (codigo, nombre)
	VALUES (1,'Ramos');



INSERT INTO Profesores_new (codigo, nombre)
	VALUES (2,'Pazos');