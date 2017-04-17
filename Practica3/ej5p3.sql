DROP PROCEDURE IF EXISTS peliculas_PorNacionalidad;

delimiter //

CREATE PROCEDURE peliculas_PorNacionalidad(
IN pais VARCHAR(100),
OUT num INT)
BEGIN
  SELECT  COUNT(Peliculas.nombre)
  INTO num
  FROM Peliculas
  WHERE Peliculas.nacionalidad=pais;
END

//
DELIMITER ;
