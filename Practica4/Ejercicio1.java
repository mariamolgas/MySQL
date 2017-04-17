
import java.sql.*;
import java.io.*;

class Ejercicio1{

public static void main(String args[]){

  System.out.println("Base de datos a la que desea acceder:");
  String base=new String();

    try{
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        base = bufferRead.readLine();
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }


try{
//step1 load the driver class
Class.forName("com.mysql.jdbc.Driver");

//step2 create  the connection object

Connection con=DriverManager.getConnection(
"jdbc:mysql://localhost:3306/"+base,"mariamolgas","molgas2");

//step3 create the statement object
Statement stmt=con.createStatement();

//step4 execute query
ResultSet rs=stmt.executeQuery("select * from Actores");
while(rs.next())
System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

//step5 close the connection object
con.close();

}
catch(SQLException ex){System.out.println("Usuario, Clave y/o Base de Datos incorrectos \n" + ex);}
catch(Exception e){ System.out.println(e);}

}
}
