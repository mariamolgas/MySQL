import java.io.*;
import java.util.Iterator;

import com.db4o.*;
import com.db4o.config.*;
import com.db4o.defragment.*;
import com.db4o.ext.*;
import com.db4o.foundation.*;
import com.db4o.foundation.io.*;

import db4ounit.*;
import db4ounit.extensions.*;
import db4ounit.extensions.fixtures.*;


public class database{

public static void main(String[] args) throws Exception{

EmbeddedConfiguration config= Db4oEmbedded.newConfiguration();
ObjectContainer db = Db4oEmbedded.openFile(config,"student.db4o");


Peliculas titanic = new Peliculas(1,"titanic","americana",4.2);
Peliculas rambo = new Peliculas(2,"rambo","españa", 3.1);
Peliculas cincuenta_sombras= new Peliculas(3,"50 sombras de Grey","inglaterra",2.1);

db.store(titanic);
db.store(rambo);
db.store(cincuenta_sombras);

while(1==1){
        try{

    System.out.println(" \n \nIntroduzca opción (número):");

    System.out.println("1. Añadir Peliculas.");
    System.out.println("2. Eliminar Peliculas.");
    System.out.println("3. Listar Peliculas.");
    System.out.println("4. Modificar valoraciones.");
    System.out.println("5. Salir. \n");


     String s=new String();

     try{
             BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
             s = bufferRead.readLine();
         }
         catch(IOException e)
         {
             e.printStackTrace();
         }


//HECHO PARA PELICULAS CONCRETAS, SIN PEDIR PARAMETROS
switch(s){
case "1":
Peliculas loq = new Peliculas(4,"lo que el viento se llevo","americana",2.2);
db.store(loq);
break;
case "2":
ObjectSet <Peliculas> peli = db.queryByExample(new Peliculas(1,null,null,0));
System.out.println("Eliminar: " +peli);
Iterator<Peliculas> iti = peli.iterator();
 	 		while (iti.hasNext()){
 	 			Peliculas aux = iti.next();
 	 			db.delete(aux);
 	 		}

break;
case "3":
System.out.println("Listar peliculas: ");

ObjectSet<Peliculas> pelis = db.queryByExample(Peliculas.class);

Iterator<Peliculas> it = pelis.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
break;

case "4":

System.out.println("Modificar valoraciones: ");
ObjectSet<Peliculas> pel = db.queryByExample(new Peliculas(2,null,null,0));

Iterator<Peliculas> i = pel.iterator();
		while (i.hasNext()){
Peliculas pe=i.next();

pe.setInteres(4.4);
db.store(pe);
System.out.println(pe);
		}

break;
case "5":
db.close();

return;

}


}
catch(Exception e){
           e.printStackTrace();
           System.out.println("\n\n\n");
       }

}

//ObjectSet peli = db.queryByExample(new Peliculas(0,null,"españa",0.0));



}
}
