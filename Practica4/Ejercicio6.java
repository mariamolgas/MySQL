
import java.sql.*;
import java.io.*;

class Ejercicio6{

public static void main(String args[]){


try{
//step1 load the driver class
Class.forName("com.mysql.jdbc.Driver");

//step2 create  the connection object

Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/misPeliculas","mariamolgas","molgas2");
String consulta= "SELECT * FROM ACTORES";
//step3 create the statement object
Statement stmt=con.createStatement();


ResultSet rs = stmt.executeQuery(consulta);
      while (rs.next()) {
          int ID_actor = rs.getInt("ID_actor");
          String nombre = rs.getString("nombre");
          String unicidad = rs.getString("unicidad");
          int edad = rs.getInt("edad");
          String nacionalidad = rs.getString("nacionalidad");
          System.out.println(ID_actor + "\t" + nombre +
                             "\t" + unicidad + "\t" + edad +
                             "\t" + nacionalidad);
      }
//step5 close the connection object
stmt.close();
con.close();

}
catch(SQLException ex){System.out.println("ERROR SQL:   \n" + ex);}
catch(Exception e){ System.out.println(e);}

}
}
