
import java.sql.*;
import java.io.*;
import java.lang.String;

class ejproc{

public static void main(String args[]){

try{
//step1 load the driver class
Class.forName("com.mysql.jdbc.Driver");

//step2 create  the connection object

Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/misPeliculas","mariamolgas","molgas2");

//CallableStatement stmt=con.prepareCall("listar_directores_peliculas"); //ASI DA ERROR!!!
CallableStatement stmt=con.prepareCall("call listar_directores_peliculas"); //ASI NO DA ERROR!!!!


ResultSet rs = stmt.executeQuery(); //PARA VER RESULTADO DEL SELECT
      while (rs.next()) {

          String nombre = rs.getString("nombre");
          System.out.println(nombre);
      }

//step5 close the connection object
con.close();

}
catch(SQLException ex){System.out.println("ERROR SQL:   \n" + ex);}
catch(Exception e){ System.out.println(e);}

}
}
