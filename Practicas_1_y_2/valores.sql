

INSERT INTO Actores (ID_actor,nombre,ID_pelicula)
	VALUES(1,'Brad Pitt',1),
	(2,'Leonardo Diccaprio',2),
	(3,'Angelina Jolie',3),
	(4,'Penelope Cruz',4),
	(5,'Emma Watson'5);

INSERT INTO Directores(ID_director,nombre)
	VALUES
	(1,'Almodovar'),
	(2,'Alberto Rodriguez'),
	(3,'Bayona'),
	(4,'Sorogoyen'),
	(5,'Spielberg');	


INSERT INTO Peliculas(ID_pelicula,nombre)
	VALUES
	(1,'Un monstruo viene a verme',1),
	(2,'3MSC',2),
	(3,'El diario de Noah',3),
	(4,'La isla minima',4),
	(5,'Infiltrados',5);


UPDATE Actores SET ID_pelicula=1, ID_pelicula=3  WHERE ID_actor=1;
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
