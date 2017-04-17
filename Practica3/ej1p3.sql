
DROP PROCEDURE IF EXISTS listar_directores_peliculas;

CREATE PROCEDURE listar_directores_peliculas()

SELECT Peliculas.nombre, Directores.nombre FROM Peliculas,Directores WHERE Peliculas.ID_director=Directores.id_director;
