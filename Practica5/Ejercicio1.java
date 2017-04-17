import java.sql.*;
import java.io.*;
public class Ejercicio1{
	public static void main(String[] args){

String nombre_imagen=null;
String id_actor=null;

nombre_imagen=args[0];
id_actor=args[1];

		try{
			Class.forName("com.mysql.jdbc.Driver");

			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/misPeliculas","mariamolgas","molgas2");

			Statement stmt = con.createStatement();
/*PARA AÑADIR EL NUEVO ATRIBUTO, DESCOMENTAR SI ES LA PRIMERA VEZ*/;

        int ra=stmt.executeUpdate("ALTER TABLE Actores ADD image longblob;");
       ra=stmt.executeUpdate("ALTER TABLE Directores ADD image longblob;");

//INSERTAR

				 File imgfile = new File(nombre_imagen);

					  FileInputStream fin = new FileInputStream(imgfile);

					   PreparedStatement pre =
					   con.prepareStatement("UPDATE Actores SET image=? WHERE ID_actor="+id_actor);
              pre.setBinaryStream(1,(InputStream)fin,(int)imgfile.length());
					   pre.executeUpdate();
					   System.out.println("Successfully inserted the file into the database!");







             ResultSet rs = stmt.executeQuery("select image from Actores where ID_actor="+id_actor);
             int i = 0;
             while (rs.next()) {
               InputStream in = rs.getBinaryStream(1);
               OutputStream f = new FileOutputStream(new File("actor"+id_actor+".jpg"));
               i++;
               int c = 0;
               while ((c = in.read()) > -1) {
                 f.write(c);
               }
               f.close();
               in.close();

}


pre.close();
con.close();

					}catch (Exception e1){
						System.out.println(e1.getMessage());
					}
	}
}
