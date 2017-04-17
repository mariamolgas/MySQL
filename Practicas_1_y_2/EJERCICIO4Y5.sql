CREATE TABLE Actores(
	ID_actor INT NULL,
	nombre VARCHAR(100) NOT NULL,
	PRIMARY KEY (ID_actor)
	);

CREATE TABLE Directores(
	ID_director INT NULL,
	nombre VARCHAR(100) NOT NULL,
	PRIMARY KEY (ID_director)
	);

CREATE TABLE Peliculas(
	ID_pelicula INT  NULL,
	nombre VARCHAR(100) NOT NULL,
	ID_actor INT NULL,
	ID_director INT NULL,
	PRIMARY KEY (ID_pelicula),
	FOREIGN KEY(ID_director) REFERENCES Directores(ID_director),
	CONSTRAINT rela FOREIGN KEY(ID_actor) REFERENCES Actores(ID_actor)
	);

ALTER TABLE Actores ADD	ID_pelicula INT NULL;
ALTER TABLE Directores ADD ID_pelicula INT NULL;
ALTER TABLE Actores ADD CONSTRAINT rel FOREIGN KEY(ID_pelicula) REFERENCES Peliculas(ID_pelicula);



INSERT INTO Actores (ID_actor,nombre)
	VALUES(1,'Brad Pitt'),
	(2,'Leonardo Diccaprio'),
	(3,'Angelina Jolie'),
	(4,'Penelope Cruz'),
	(5,'Emma Watson');

INSERT INTO Directores(ID_director,nombre)
	VALUES
	(1,'Almodovar'),
	(2,'Alberto Rodriguez'),
	(3,'Bayona'),
	(4,'Sorogoyen'),
	(5,'Spielberg');	


INSERT INTO Peliculas(ID_pelicula,nombre)
	VALUES
	(1,'Un monstruo viene a verme'),
	(2,'3MSC'),
	(3,'El diario de Noah'),
	(4,'La isla minima'),
	(5,'Infiltrados');


UPDATE Actores SET ID_pelicula=1  WHERE ID_actor=1;
UPDATE Actores SET ID_pelicula=2  WHERE ID_actor=2;
UPDATE Actores SET ID_pelicula=3  WHERE ID_actor=3;
UPDATE Actores SET ID_pelicula=4  WHERE ID_actor=4;
UPDATE Actores SET ID_pelicula=5  WHERE ID_actor=5;

UPDATE Directores SET ID_pelicula=5  WHERE ID_director=1;
UPDATE Directores SET ID_pelicula=4  WHERE ID_director=2;
UPDATE Directores SET ID_pelicula=3  WHERE ID_director=3;
UPDATE Directores SET ID_pelicula=2  WHERE ID_director=4;
UPDATE Directores SET ID_pelicula=1  WHERE ID_director=5;



UPDATE Peliculas SET ID_actor=1, ID_director=5 WHERE ID_pelicula=1;
UPDATE Peliculas SET ID_actor=2, ID_director=4 WHERE ID_pelicula=2;
UPDATE Peliculas SET ID_actor=3, ID_director=3 WHERE ID_pelicula=3;
UPDATE Peliculas SET ID_actor=4, ID_director=2 WHERE ID_pelicula=4;
UPDATE Peliculas SET ID_actor=5, ID_director=1 WHERE ID_pelicula=5;





