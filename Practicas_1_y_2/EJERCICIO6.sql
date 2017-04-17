CREATE TABLE Actores(
	ID_actor INT NULL,
	nombre VARCHAR(100) NOT NULL,
	PRIMARY KEY (ID_actor),
	unicidad VARCHAR(9) NOT NULL,
	UNIQUE (unicidad),
	edad INT NOT NULL,
	CONSTRAINT chk CHECK (edad>0 AND edad<120)
	);

CREATE TABLE Directores(
	ID_director INT NULL,
	nombre VARCHAR(100) NOT NULL,
	PRIMARY KEY (ID_director),
	unicidad VARCHAR(9) NOT NULL,
	UNIQUE (unicidad),
	edad INT NOT NULL,
	CONSTRAINT chk CHECK (edad>0 AND edad<120)
	);

CREATE TABLE Peliculas(
	ID_pelicula INT  NULL,
	nombre VARCHAR(100) NOT NULL,
	ID_actor INT NULL,
	ID_director INT NULL,
	unicidad VARCHAR(9) NOT NULL,
	UNIQUE (unicidad),
	PRIMARY KEY (ID_pelicula),
	FOREIGN KEY(ID_director) REFERENCES Directores(ID_director) NULL,
	CONSTRAINT rela FOREIGN KEY(ID_actor) REFERENCES Actores(ID_actor)
	);

ALTER TABLE Actores ADD	ID_pelicula INT NULL;
ALTER TABLE Directores ADD ID_pelicula INT NULL;
ALTER TABLE Actores ADD CONSTRAINT rel FOREIGN KEY(ID_pelicula) REFERENCES Peliculas(ID_pelicula);



INSERT INTO Actores (ID_actor,nombre,unicidad)
	VALUES(1,'Brad Pitt','123456789'),
	(2,'Leonardo Diccaprio','987654321'),
	(3,'Angelina Jolie','111111111'),
	(4,'Penelope Cruz','222222222'),
	(5,'Emma Watson','333333333');

INSERT INTO Directores(ID_director,nombre,unicidad)
	VALUES
	(1,'Almodovar','333333333'),
	(2,'Alberto Rodriguez','222222222'),
	(3,'Bayona','111111111'),
	(4,'Sorogoyen','987654321'),
	(5,'Spielberg','123456789');	


INSERT INTO Peliculas(ID_pelicula,nombre,unicidad)
	VALUES
	(1,'Un monstruo viene a verme','123456789'),
	(2,'3MSC','987654321'),
	(3,'El diario de Noah','111111111'),
	(4,'La isla minima','222222222'),
	(5,'Infiltrados','333333333');


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





