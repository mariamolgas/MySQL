
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

//step4 execute query

int ra=stmt.executeUpdate("create table if not exists Actores(ID_actor INT,nombre VARCHAR(100) NOT NULL,PRIMARY KEY (ID_actor),unicidad VARCHAR(9) NOT NULL,	UNIQUE (unicidad),edad INT NOT NULL, CONSTRAINT chk CHECK (edad>0 AND edad<120),nacionalidad VARCHAR(100) NOT NULL	)");
ra=stmt.executeUpdate("CREATE TABLE if not exists Directores(ID_director INT,	nombre VARCHAR(100) NOT NULL, PRIMARY KEY (ID_director),unicidad VARCHAR(9) NOT NULL,	UNIQUE (unicidad),edad INT NOT NULL,CONSTRAINT chk CHECK (edad>0 AND edad<120),	nacionalidad VARCHAR(100) NOT NULL);");
ra=stmt.executeUpdate("CREATE TABLE if not exists Peliculas(ID_pelicula INT,nombre VARCHAR(100) NOT NULL,	ID_director INT,unicidad VARCHAR(9) NOT NULL,	UNIQUE (unicidad),PRIMARY KEY (ID_pelicula),FOREIGN KEY(ID_director) REFERENCES Directores(ID_director),nacionalidad VARCHAR(100) NOT NULL);");
ra=stmt.executeUpdate("CREATE TABLE if not exists Actores_Peliculas(ID_pelicula INT,ID_actor INT,	CONSTRAINT pk_actor FOREIGN KEY(ID_actor) REFERENCES Actores(ID_actor),	CONSTRAINT pk_peli FOREIGN KEY(ID_pelicula) REFERENCES Peliculas(ID_pelicula),CONSTRAINT pk PRIMARY KEY(ID_pelicula,ID_actor));");

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
