package proyecto1.colecciones;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import proyecto1.Dni;

public class MainMapas {
	
	public static void main(String[] args) {
		
		
		Dni dnifrank = new Dni(6662884, 'Z',"Frank"); // 6924792N
		Dni dnivale = new Dni(53130984, 'H' ,"Vale"); // 6924792N
		
		
		//LIST --> ArrayList
		//MAP --> HashMap <Key, Value>
		
		Map<Integer, Dni> mapa = new HashMap<>();
		mapa.put(dnifrank.getNumero_dni(), dnifrank);
		mapa.put(dnivale.getNumero_dni(), dnivale);
		
		Dni dni= mapa.get(53130984);
		Dni dni2= mapa.get(6662884);
		Dni dni3= mapa.get(16546);
		
		System.out.println(dni.toString());
		System.out.println(dni2.toString());
		if (Objects.isNull(dni3))
		{
			System.out.println("EL DNI ES NULL");
		}
		
		
	}

}
