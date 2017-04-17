package Objetos;
import java.util.Vector;

public class Peliculas{

 private int ID;
 private String titulo;
 private String nacionalidad;
private double interes;
private Directores director;
private Vector<Actores> actores = new Vector<Actores>();

public Peliculas(){

}

public Peliculas(int ID, String titulo, String nacionalidad, double interes){
this.ID=ID;
this.titulo=titulo;
this.nacionalidad=nacionalidad;
this.interes=interes;
}


public Peliculas(int ID, String titulo, String nacionalidad, double interes, Directores director, Vector<Actores> actores){
this.ID=ID;
this.titulo=titulo;
this.nacionalidad=nacionalidad;
this.interes=interes;
this.director=director;
this.actores=actores;
}

public Peliculas(int ID, String titulo, String nacionalidad, double interes, Directores director, Actores actor){
this.ID=ID;
this.titulo=titulo;
this.nacionalidad=nacionalidad;
this.interes=interes;
this.director=director;
this.actores.add(actor);
}

public int getID(){
return this.ID;
}

public String getTitulo(){
return this.titulo;
}

public String getNacionalidad(){
return this.nacionalidad;
}

public double getInteres(){
return this.interes;
}

public void setTitulo(String Titulo){
		this.titulo = Titulo;
	}

	public void setNacionalidad(String Nacionalidad){
		this.nacionalidad = Nacionalidad;
	}

	public void setID(int ID){
		this.ID = ID;
	}
public void setInteres(double interes){
this.interes=interes;
}

public void setDirector(Directores director){
  this.director = director;
}

public void setActor(Actores actor){
  this.actores.add(actor);
}

public void setActores(Vector<Actores> actores){
  this.actores.addAll(actores);
}

public Directores getDirector(){
		return this.director;
	}

	public Vector<Actores> getActores(){
		return this.actores;
	}


public String toString(){
  String aux = "\nDATOS SOBRE LA PELÍCULA CON ID '" + this.ID + "':\n";

    aux = aux + "Título: " + this.titulo + ".\n";
    aux = aux + "Nacionalidad: " + this.nacionalidad + ".\n";
    aux = aux + "Interes" + this.interes +  ".\n";
if(this.director!=null)
aux = aux + "Director: " + this.director.toString() + ".\n";
   aux = aux + "Actores: " + this.actores.size() + ".\n";

  return aux;
}



}
