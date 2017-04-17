import java.sql.*;
import java.io.*;
public class prueba_ej1{
	public static void main(String[] args){


		try{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/prueba_p5","mariamolgas","molgas2");

			Statement stmt = con.createStatement();


			ResultSet rs = stmt.executeQuery("select image from Prueba");
			int i = 0;
			while (rs.next()) {
				InputStream in = rs.getBinaryStream(1);
				OutputStream f = new FileOutputStream(new File("test"+i+".jpg"));
				i++;
				int c = 0;
				while ((c = in.read()) > -1) {
					f.write(c);
				}
				f.close();
				in.close();
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
}
