DROP PROCEDURE IF EXISTS ponerEnMayusculas_2;

delimiter //

CREATE PROCEDURE ponerEnMayusculas_2(
INOUT frase VARCHAR(100))
BEGIN
SELECT UCASE(frase) INTO frase;
END

//
DELIMITER ;
