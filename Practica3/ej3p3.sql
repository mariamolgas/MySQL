DROP PROCEDURE IF EXISTS contar_directores;
SET @num_invocaciones=0;

CREATE PROCEDURE contar_directores()
set @num_invocaciones:=@num_invocaciones + 1;

create table if not exists cuentaDirectores(
OrderDate DATETIME,
OrderHour DATETIME,
num_dire INT
);

INSERT INTO cuentaDirectores(num_dire,OrderHour,OrderDate)
values  ((SELECT count(distinct ID_director) from Directores),
        (SELECT CURTIME()),
        (SELECT CURDATE()));
