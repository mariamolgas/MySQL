DROP PROCEDURE IF EXISTS contar_directores;
SET @num_invocaciones=0;
DELIMITER //

CREATE PROCEDURE contar_directores()
BEGIN
DECLARE i iNT;
SET @num_invocaciones:=@num_invocaciones + 1;

create table if not exists cuentaDirectores(
OrderDate DATETIME,
num_dire INT
);

SELECT IF(@num_invocaciones>10,1,0) INTO i;
SELECT i;
SELECT @num_invocaciones;
DELETE FROM cuentaDirectores LIMIT i;

INSERT INTO cuentaDirectores(num_dire,OrderDate)
values  ((SELECT count(distinct ID_director) from Directores),
        (SELECT NOW()));




END;
//
DELIMITER ;
