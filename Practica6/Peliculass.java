public class Peliculass{

 private int ID;
 private String titulo;
 private String nacionalidad;
private float interes;

public Peliculas(){

}

public Peliculas(int ID, String titulo, String nacionalidad, float interes){
this.ID=ID;
this.titulo=titulo;
this.nacionalidad=nacionalidad;
this.interes=interes;
}

public int getID(){
return ID;
}

public String getTitulo(){
return titulo;
}

public String getNacionalidad(){
return nacionalidad;
}

public float getInteres(){
return interes;
}

public void setID(int value){
ID=value;
}

public void setTitulo(String value){
titulo=value;
}

public void setNacionalidad(String value){
nacionalidad=value;
}

public void setID(float value){
interes=value;
}

public String tosString() {

return " ";            
}

}
