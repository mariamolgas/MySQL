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


public class ejercicio2{

public static void main(String[] args) throws Exception{

Configuration config= Db4o.configure();
ObjectContainer db = Db4o.openFile(config,"student.db4o");


ObjectSet<Peliculas> peli = db.queryByExample(Peliculas.class);

Iterator<Peliculas> it = peli.iterator();
		while (it.hasNext()){
			System.out.println(it.next());
		}
db.close();

}
}
