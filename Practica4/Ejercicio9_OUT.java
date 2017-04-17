
import java.sql.*;
import java.io.*;
import java.lang.String;

class Ejercicio9_OUT{

public static void main(String args[]){

try{
//step1 load the driver class
Class.forName("com.mysql.jdbc.Driver");

//step2 create  the connection object

Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/misPeliculas","mariamolgas","molgas2");

CallableStatement stmt=con.prepareCall("{call peliculas_PorNacionalidad(?,?)}");

stmt.setString(1,"Italia");
stmt.registerOutParameter(2, java.sql.Types.VARCHAR);

stmt.execute(); //ME DEBERIA IMPRIMIR EL SELECT?
String num = stmt.getString(2);
System.out.println("Salida: " +num);
stmt.close();




//step5 close the connection object
con.close();

}
catch(SQLException ex){System.out.println("ERROR SQL:   \n" + ex);}
catch(Exception e){ System.out.println(e);}

}
}
