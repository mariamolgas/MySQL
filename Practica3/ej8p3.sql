DROP PROCEDURE IF EXISTS extraer_imdbs;
set @aux='nueva_tabla';
delimiter //

CREATE PROCEDURE extraer_imdbs(IN pais VARCHAR(100))
BEGIN
DECLARE cods VARCHAR(100);
DECLARE finished INT DEFAULT 0;
DECLARE curs CURSOR FOR
SELECT unicidad FROM Peliculas WHERE Peliculas.nacionalidad=pais
UNION
SELECT unicidad FROM Actores WHERE Actores.nacionalidad=pais
UNION
SELECT unicidad FROM Directores WHERE Directores.nacionalidad=pais;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = 1;
set @aux=pais;


DROP  table if exists aux;
CREATE TABLE if not exists aux(
imdb VARCHAR(100)
);






OPEN curs;

get_nacionalidad: LOOP
FETCH curs INTO cods;
IF finished THEN LEAVE get_nacionalidad;
END IF;
INSERT INTO aux(imdb) VALUES(cods);
END LOOP get_nacionalidad;
CLOSE curs;

END

//
DELIMITER ;
