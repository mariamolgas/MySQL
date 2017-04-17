DROP PROCEDURE IF EXISTS consultaPorNacionalidad;

delimiter //

CREATE PROCEDURE consultaPorNacionalidad(IN pais VARCHAR(100))
BEGIN
(SELECT Directores.nombre AS resultado
FROM Directores
WHERE Directores.nacionalidad=pais
) UNION
(SELECT Actores.nombre  AS resultado
FROM Actores
WHERE Actores.nacionalidad=pais)
UNION
(SELECT Peliculas.nombre  AS resultado
FROM Peliculas
WHERE Peliculas.nacionalidad=pais)
;
END

//
DELIMITER ;
