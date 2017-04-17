drop database if exists Practica2_buena;
create database Practica2_buena;
use Practica2_buena

CREATE TABLE Actores(
	ID_actor INT,
	nombre VARCHAR(100) NOT NULL,
	PRIMARY KEY (ID_actor),
	unicidad VARCHAR(9) NOT NULL,
	UNIQUE (unicidad),
	edad INT NOT NULL,
	CONSTRAINT chk CHECK (edad>0 AND edad<120),
	nacionalidad VARCHAR(100) NOT NULL
	);

CREATE TABLE Directores(
	ID_director INT,
	nombre VARCHAR(100) NOT NULL,
	PRIMARY KEY (ID_director),
	unicidad VARCHAR(9) NOT NULL,
	UNIQUE (unicidad),
	edad INT NOT NULL,
	CONSTRAINT chk CHECK (edad>0 AND edad<120),
	nacionalidad VARCHAR(100) NOT NULL
	);

CREATE TABLE Peliculas(
	ID_pelicula INT,
	nombre VARCHAR(100) NOT NULL,
	ID_director INT,
	unicidad VARCHAR(9) NOT NULL,
	UNIQUE (unicidad),
	PRIMARY KEY (ID_pelicula),
	FOREIGN KEY(ID_director) REFERENCES Directores(ID_director),
	nacionalidad VARCHAR(100) NOT NULL
);

CREATE TABLE Actores_Peliculas(
	ID_pelicula INT,
	ID_actor INT,
	CONSTRAINT pk_actor FOREIGN KEY(ID_actor) REFERENCES Actores(ID_actor),
	CONSTRAINT pk_peli FOREIGN KEY(ID_pelicula) REFERENCES Peliculas(ID_pelicula),
	CONSTRAINT pk PRIMARY KEY(ID_pelicula,ID_actor)
	);
