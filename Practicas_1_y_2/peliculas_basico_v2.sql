CREATE TABLE Actores(
	ID_actor INT,
	nombre VARCHAR(100) NOT NULL,
	PRIMARY KEY (ID_actor)NOT NULL,
	ID_pelicula INT NOT NULL,
	CONSTRAINT rel FOREIGN KEY(ID_pelicula) REFERENCES Peliculas(ID_pelicula) NOT NULL
	)ENGINE=INNODB;

CREATE TABLE Directores(
	ID_director INT,
	nombre VARCHAR(100) NOT NULL,
	PRIMARY KEY (ID_director)
	)ENGINE=INNODB;

CREATE TABLE Peliculas(
	ID_pelicula INT,
	nombre VARCHAR(100),
	ID_actor INT,
	ID_director INT,
	PRIMARY KEY (ID_pelicula),
	FOREIGN KEY(ID_director) REFERENCES Directores(ID_director),
	CONSTRAINT rela FOREIGN KEY(ID_actor) REFERENCES Actores(ID_actor)
	)ENGINE=INNODB;



