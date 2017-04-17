
import java.sql.*;
import java.io.*;
import java.lang.String;

class Ejercicio9{

public static void main(String args[]){

try{
//step1 load the driver class
Class.forName("com.mysql.jdbc.Driver");

//step2 create  the connection object

Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/misPeliculas","mariamolgas","molgas2");

CallableStatement stmt=con.prepareCall("{call consultaPorNacionalidad(?)}");

stmt.setString(1,"Inglaterra");
stmt.execute(); //ME DEBERIA IMPRIMIR EL SELECT?

ResultSet rs = stmt.executeQuery(); //PARA VER RESULTADO DEL SELECT
      while (rs.next()) {

          String nombre = rs.getString("resultado");
          System.out.println(nombre);
      }

//step5 close the connection object
con.close();

}
catch(SQLException ex){System.out.println("ERROR SQL:   \n" + ex);}
catch(Exception e){ System.out.println(e);}

}
}
