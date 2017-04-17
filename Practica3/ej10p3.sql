DROP PROCEDURE IF EXISTS introducir_pelicula;

delimiter //

CREATE PROCEDURE introducir_pelicula(
IN Id_pelicula INT,
IN nombre VARCHAR(100),
IN id_director INT,
IN unicidad VARCHAR(100),
IN nacionalidad VARCHAR(100)
)
BEGIN
DECLARE `_rollback` BOOL DEFAULT 0;
DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
START TRANSACTION;
INSERT INTO Peliculas (Id_pelicula,nombre,unicidad,id_director,nacionalidad)
VALUES(Id_pelicula,nombre,unicidad,id_director,nacionalidad);
SET `_rollback` = 1;
IF `_rollback` THEN ROLLBACK;
ELSE COMMIT;
END IF;

END

//
DELIMITER ;
