
import java.sql.*;
import java.io.*;
import java.lang.String;

class Ejercicio7{

public static void main(String args[]){

  Statement stmt= null;
try{
//step1 load the driver class
Class.forName("com.mysql.jdbc.Driver");

//step2 create  the connection object

Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/misPeliculas","mariamolgas","molgas2");
String consulta= "SELECT Peliculas.nombre from Peliculas";
//step3 create the statement object
stmt= con.createStatement();
stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                   ResultSet.CONCUR_UPDATABLE);

ResultSet rs = stmt.executeQuery(consulta);

      int concurr = rs.getConcurrency();
              if (concurr == java.sql.ResultSet.CONCUR_UPDATABLE){
                  System.out.println("ResultSet is CONCUR_UPDATABLE");
              } else if ( concurr == java.sql.ResultSet.CONCUR_READ_ONLY){
                  System.out.println("ResultSet is CONCUR_READ_ONLY");
              }
      while (rs.next()) {
        String nombre = rs.getString("nombre");
      String peli_may=nombre.toUpperCase();
      System.out.println(peli_may);

                  rs.updateString("nombre", peli_may);
                  rs.updateRow();
              }
//step5 close the connection object
con.close();

}
catch(SQLException ex){System.out.println("ERROR SQL:   \n" + ex);}
catch(Exception e){ System.out.println(e);}

}
}
