
DROP PROCEDURE IF EXISTS contar_directores;

CREATE PROCEDURE contar_directores()

create table if not exists cuentaDirectores(
OrderDate DATETIME,
OrderHour DATETIME,
num_dire INT
);

INSERT INTO cuentaDirectores(num_dire,OrderHour,OrderDate)
values  ((SELECT count(distinct ID_director) from Directores),
        (SELECT CURTIME()),
        (SELECT CURDATE()));
