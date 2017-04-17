import java.sql.*;
import java.io.*;
public class prueba_ej1_insertar_imagen{
	public static void main(String[] args){


		try{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/prueba_p5","mariamolgas","molgas2");

			Statement st = con.createStatement();

					   File imgfile = new File("mario.jpg");

					  FileInputStream fin = new FileInputStream(imgfile);

					   PreparedStatement pre =
					   con.prepareStatement("insert into Prueba values(?,?,?)");

					   pre.setString(1,"test");
					   pre.setInt(2,3);
					   pre.setBinaryStream(3,(InputStream)fin,(int)imgfile.length());
					   pre.executeUpdate();
					   System.out.println("Successfully inserted the file into the database!");

					   pre.close();
					   con.close();
					}catch (Exception e1){
						System.out.println(e1.getMessage());
					}
	}
}
