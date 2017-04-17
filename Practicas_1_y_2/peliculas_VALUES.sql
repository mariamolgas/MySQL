
INSERT INTO Actores (ID_actor,nombre,unicidad,edad,nacionalidad)
	VALUES(1,'Brad Pitt','123456789',45,'España'),
	(2,'Leonardo Diccaprio','987654321',55,'Inglaterra'),
	(3,'Angelina Jolie','111111111',67,'España'),
	(4,'Penelope Cruz','222222222',33,'Francia'),
	(5,'Emma Watson','333333333',12,'Inglaterra');

INSERT INTO Directores(ID_director,nombre,unicidad,nacionalidad)
	VALUES
	(1,'Almodovar','333333333','España'),
	(2,'Alberto Rodriguez','222222222','Inglaterra'),
	(3,'Bayona','111111111','España'),
	(4,'Sorogoyen','987654321','España'),
	(5,'Spielberg','123456789','Francia');


INSERT INTO Peliculas(ID_pelicula,nombre,unicidad,ID_director,nacionalidad)
	VALUES
	(1,'Un monstruo viene a verme','123456789',2,'Inglaterra'),
	(2,'3MSC','987654321',1,'Francia'),
	(3,'El diario de Noah','111111111',2,'España'),
	(4,'La isla minima','222222222',4,'Inglaterra'),
	(5,'Infiltrados','333333333',5,'España');

INSERT INTO Actores_Peliculas(ID_pelicula,ID_actor)
	VALUES
	(1,2),
	(1,3),
	(1,4),
	(4,1),
	(3,1);
