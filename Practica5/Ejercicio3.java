
import java.sql.*;
import java.io.*;

class Ejercicio3{

public static void main(String args[]){

  /*System.out.println("Base de datos a la que desea acceder:");
  String base=new String();

    try{
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        base = bufferRead.readLine();
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }*/


try{
//step1 load the driver class
Class.forName("com.mysql.jdbc.Driver");

//step2 create  the connection object

Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/misPeliculas","mariamolgas","molgas2");

//step3 create the statement object
Statement stmt=con.createStatement();
int ra;
//step4 execute query

 ra=stmt.executeUpdate("Drop TABLE if exists Actores_Peliculas");
ra=stmt.executeUpdate("Drop TABLE if exists Actores");
ra=stmt.executeUpdate("Drop TABLE if exists Peliculas");

ra=stmt.executeUpdate("Drop TABLE if exists Directores");


 ra=stmt.executeUpdate("create table if not exists Actores(ID_actor INT,nombre VARCHAR(100) NOT NULL,PRIMARY KEY (ID_actor),unicidad VARCHAR(9) NOT NULL,	UNIQUE (unicidad),edad INT NOT NULL, CONSTRAINT chk CHECK (edad>0 AND edad<120),nacionalidad VARCHAR(100) NOT NULL	)");
 ra=stmt.executeUpdate("CREATE TABLE if not exists Directores(ID_director INT,	nombre VARCHAR(100) NOT NULL, PRIMARY KEY (ID_director),unicidad VARCHAR(9) NOT NULL,	UNIQUE (unicidad),edad INT NOT NULL,CONSTRAINT chk CHECK (edad>0 AND edad<120),	nacionalidad VARCHAR(100) DEFAULT 'Estadounidense');");
ra=stmt.executeUpdate("CREATE TABLE if not exists Peliculas(ID_pelicula INT,nombre VARCHAR(100) NOT NULL,	PRIMARY KEY (ID_pelicula),ID_director INT,unicidad VARCHAR(9) NOT NULL,	UNIQUE (unicidad),FOREIGN KEY(ID_director) REFERENCES Directores(ID_director),nacionalidad VARCHAR(100) NOT NULL);");
ra=stmt.executeUpdate("CREATE TABLE if not exists Actores_Peliculas(ID_pelicula INT,ID_actor INT,	CONSTRAINT pk_actor FOREIGN KEY(ID_actor) REFERENCES Actores(ID_actor),	CONSTRAINT pk_peli FOREIGN KEY(ID_pelicula) REFERENCES Peliculas(ID_pelicula),CONSTRAINT pk PRIMARY KEY(ID_pelicula,ID_actor));");

ra=stmt.executeUpdate("INSERT INTO Actores (ID_actor,nombre,unicidad,edad,nacionalidad)	VALUES(1,'Brad Pitt','123456789',45,'España'),(2,'Leonardo Diccaprio','987654321',55,'Inglaterra'),	(3,'Angelina Jolie','111111111',67,'España'),	(4,'Penelope Cruz','222222222',33,'Francia'),	(5,'Emma Watson','333333333',12,'Inglaterra');");
ra=stmt.executeUpdate("INSERT INTO Directores(ID_director,nombre,unicidad,edad) VALUES(1,'Almodovar','333333333',44),	(2,'Alberto Rodriguez','222222222',34),(3,'Bayona','111111111',22),(4,'Sorogoyen','987654321',43),	(5,'Spielberg','123456789',55);");
ra=stmt.executeUpdate("INSERT INTO Peliculas(ID_pelicula,nombre,unicidad,ID_director,nacionalidad)	VALUES	(1,'Un monstruo viene a verme','123456789',2,'Inglaterra'),	(2,'3MSC','987654321',1,'Francia'),	(3,'El diario de Noah','111111111',2,'España'),	(4,'La isla minima','222222222',4,'Inglaterra'),(5,'Infiltrados','333333333',5,'España');");
ra=stmt.executeUpdate("INSERT INTO Actores_Peliculas(ID_pelicula,ID_actor)VALUES(1,2),(1,3),(1,4),(4,1),(3,1);");

ra=stmt.executeUpdate("UPDATE Directores SET nacionalidad='España' WHERE ID_director=1");

/*ResultSet rs=stmt.executeQuery("select * from Actores");
while(rs.next())
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
*/
//step5 close the connection object
con.close();

}
catch(SQLException ex){System.out.println("ERROR SQL:   \n" + ex);}
catch(Exception e){ System.out.println(e);}

}
}
