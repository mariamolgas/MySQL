
import java.util.Vector;

public class Directores{

 private int ID;
 private String nombre;
 private String nacionalidad;
private Vector<Peliculas> peliculas = new Vector<Peliculas>();
private int edad;

public Directores(){

}

public Directores(int ID, String nombre, String nacionalidad,int edad){
this.ID=ID;
this.nombre=nombre;
this.nacionalidad=nacionalidad;
this.edad=edad;

}


public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

public int getID(){
return this.ID;
}

public String getNombre(){
return this.nombre;
}

public String getNacionalidad(){
return this.nacionalidad;
}


public void setNombre (String Nombre){
		this.nombre = Nombre;
	}

	public void setNacionalidad(String Nacionalidad){
		this.nacionalidad = Nacionalidad;
	}

	public void setID(int ID){
		this.ID = ID;
	}


public void setPelicula(Peliculas pelicula){
  this.peliculas.add(pelicula);
}

public void setPeliculas(Vector<Peliculas> peliculas){
  this.peliculas.addAll(peliculas);
}

	public Vector<Peliculas> getPeliculas(){
		return this.peliculas;
	}


@Override
public String toString(){

		String aux = "\nDATOS SOBRE EL DIRECTOR CON ID '" + this.ID + "':\n";

		aux = aux + "Nombre: " + this.nombre + ".\n";
		aux = aux + "Nacionalidad: " + this.nacionalidad + ".\n";
		aux = aux + "Edad: " + this.edad + ".\n";

		return aux;
	}



}
