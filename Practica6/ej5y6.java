import java.io.*;

import com.db4o.*;
import com.db4o.config.*;
import com.db4o.defragment.*;
import com.db4o.ext.*;
import com.db4o.foundation.*;
import com.db4o.foundation.io.*;

import db4ounit.*;
import db4ounit.extensions.*;
import db4ounit.extensions.fixtures.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.Configuration;
import com.db4o.query.Predicate;
import com.db4o.query.Query;

public class ej5y6{

public static void main(String[] args) throws Exception{

EmbeddedConfiguration config= Db4oEmbedded.newConfiguration();
ObjectContainer db = Db4oEmbedded.openFile(config,"database2.db4o");


Peliculas rambo = new Peliculas(22,"rambo","españa", 3.1);
Peliculas cincuenta_sombras= new Peliculas(23,"50 sombras de Grey","inglaterra",2.1);

db.store(rambo);
db.store(cincuenta_sombras);



Directores director = new Directores(1, "Tim Burton", "Estadounidense", 69);
		db.store(director);


		Vector<Actores> lista = new Vector<Actores>();

		Actores actor = new Actores(3, "Hugh Jackman", "Australiano", 48);
		db.store(actor);
		lista.add(actor);

		actor = new Actores(7, "Chris Pratt", "Irlandes", 37);
		db.store(actor);
		lista.add(actor);

		actor = new Actores(4, "Susan Sarandon", "Estadounidense", 62);
		db.store(actor);
		lista.add(actor);

		actor = new Actores(6, "Emma Stone", "Estadounidense", 32);
		db.store(actor);
		lista.add(actor);

		Peliculas pelicula = new Peliculas(1,"Pulp Fiction", "Estadounidense", 2.2, director, lista);
		db.store(pelicula);

		actor = new Actores(2, "Gerard Butler", "Estadounidense", 38);
		db.store(actor);

		pelicula = new Peliculas(7,"La novia cadaver", "Alemana", 3.4, director, actor);
		db.store(pelicula);

		director = new Directores(2, "Peter Jackson", "Neozelandes",  54);
		db.store(director);

		actor = new Actores(1, "Leonardo DiCaprio", "Estadounidense",  44);
		db.store(actor);

		pelicula = new Peliculas(2,"Titanic", "Estadounidense", 3.2, director, actor);
		db.store(pelicula);

		director = new Directores(4, "Quentin Tarantino", "Estadounidense", 57);
		db.store(director);

		pelicula = new Peliculas(4,"Les Miserables", "Francesa", 1.4,director, new Vector<Actores>());
		db.store(pelicula);

		director = new Directores(5, "Martin Scorsese", "Italiano", 81);
		db.store(director);

		actor = new Actores(5, "Emma Watson", "Britanica", 28);
		db.store(actor);

		pelicula = new Peliculas(5,"El orfanato", "Española", 3.5, director, actor);
		db.store(pelicula);

		director = new Directores(3, "Stankey Kubrick", "Polaco", 45);
		db.store(director);






  /*  ObjectSet<Actores> peli = db.queryByExample(Actores.class);

    Iterator<Actores> it = peli.iterator();
    		while (it.hasNext()){
    			System.out.println(it.next());
    		}


        ObjectSet<Directores> dire = db.queryByExample(Directores.class);

        Iterator<Directores> ite = dire.iterator();
            while (ite.hasNext()){
              System.out.println(ite.next());
            }

            ObjectSet<Peliculas> pelis = db.queryByExample(Peliculas.class);

            Iterator<Peliculas> itp = pelis.iterator();
                while (itp.hasNext()){
                  System.out.println(itp.next());
                }
*/



System.out.println(" Obtener todas las películas estadounidenses con más de 3 actores y cuyo título tenga más de 10 caracteres.");
ObjectSet<Peliculas> peli = db.query(new Predicate<Peliculas>() {
@Override
public boolean match(Peliculas p) {
return (p.getActores().size()>3) && (p.getTitulo().length()>10) && (p.getNacionalidad()).equals("Estadounidense") ;
}
}
);

System.out.println(peli.size());


Iterator<Peliculas> itp = peli.iterator();
    while (itp.hasNext()){
      System.out.println(itp.next().toString());
}

db.close();
}

}
