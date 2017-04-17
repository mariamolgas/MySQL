
import java.sql.*;
import java.io.*;

class Ejercicio2{

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
//int ra=stmt.executeUpdate("ALTER TABLE Peliculas DROP puntuacion;");


//SOLO LA PRIMERA VEZ:
int ra=stmt.executeUpdate("ALTER TABLE Peliculas ADD puntuacion DECIMAL(3,2);"); 
ra=stmt.executeUpdate("UPDATE Peliculas SET puntuacion=9.99 WHERE ID_pelicula=1");
ra=stmt.executeUpdate("UPDATE Peliculas SET puntuacion=4.49 WHERE ID_pelicula=2");
ra=stmt.executeUpdate("UPDATE Peliculas SET puntuacion=5.69 WHERE ID_pelicula=3");
ra=stmt.executeUpdate("UPDATE Peliculas SET puntuacion=0.09 WHERE ID_pelicula=4");
ra=stmt.executeUpdate("UPDATE Peliculas SET puntuacion=0.10 WHERE ID_pelicula=5");

//step5 close the connection object
con.close();

}
catch(SQLException ex){System.out.println("ERROR SQL:   \n" + ex);}
catch(Exception e){ System.out.println(e);}

}
}
