
import java.sql.*;
import java.io.*;

class Ejercicio6{

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

 ra=stmt.executeUpdate("CREATE VIEW peli_naci_con AS SELECT Peliculas.nacionalidad ,Peliculas.nombre FROM PELICULAS WHERE ID_director=1");
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
