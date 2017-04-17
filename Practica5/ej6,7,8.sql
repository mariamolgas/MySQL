EJ6

CREATE VIEW EJ6 AS SELECT Peliculas.nacionalidad ,Peliculas.nombre FROM Peliculas;



EJ7


CREATE VIEW EJ7 AS SELECT Peliculas.nombre AS Peli, Peliculas.nacionalidad, Directores.nombre as dire, Actores.nombre  as actor FROM (Peliculas)
INNER JOIN
Directores ON Peliculas.ID_Director=Directores.id_director
INNER JOIN
Actores_Peliculas On Actores_Peliculas.ID_pelicula=Peliculas.ID_pelicula
INNER JOIN
Actores  ON  actores_peliculas.id_actor=actores.id_actor;

CREATE VIEW EJ7_OTRA AS (SELECT Peliculas.nombre AS Peli, Peliculas.nacionalidad, Directores.nombre  FROM (Peliculas,Directores)
WHERE (Peliculas.ID_Director=Directores.id_director ))
UNION
(SELECT Peliculas.nombre AS Peli, Peliculas.nacionalidad, Actores.nombre   FROM (Peliculas,Actores,Actores_Peliculas)
WHERE(Actores_Peliculas.ID_pelicula=Peliculas.ID_pelicula AND actores_peliculas.id_actor=actores.id_actor));






EJ8

CREATE VIEW EJ8 AS (SELECT * FROM Directores WHERE (creacion<'2000-01-01 00:00:00' and creacion>'1900-01-01 00:00:00'));

//suponiendo q se que estas son del siglo XX


EJ9


Insert INTO  EJ6 (nacionalidad) VALUES ('fines'); //Añade la palabra fines a nacionalidad
update ej6 set nombre='maria' where nacionalidad='fines';

mysqltutorial ... create-sql-updatable-views.apsx
dev.mysql view-updatability.html

EJ11

create user 'mlousada' identified by 'psswd';
create user 'mlousada'@'localhost' identified by 'psswd';
set password for 'mlousada'@'localhost'=password('molgas2');
grant select on misPeliculas.ej6 to 'mlousada'@'localhost'; //mlousada solo podra acceder a mi bd a traves de la vista de
Nacionalidad y Pelicula. Permitiendo solo el uso de SELECT, si intento ejecutar otro comando:
/*CREATE table oli;
ERROR 1142 (42000): CREATE command denied to user 'mlousada'@'localhost' for table 'oli'*/



ej12

CREATE TABLE relacion(numero INT, cadena VARCHAR(100));
CREATE INDEX cad on relacion(cadena);
CREATE INDEX num on relacion(numero);

desde -u root:
LOAD DATA LOCAL INFILE '/Users/mariamolgas/SINF_mysql/Practica5/fichero.txt' INTO TABLE Indice_1.relacion_2  FIELDS TERMINATED BY ',';

ej13
????
select * from relacion as a force index(num) join relacion_1 as b  on a.numero=2 where b.cadena='oli';
