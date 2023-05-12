package cl.desafiolatam;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileWriter; 

class EscrituraLectura {

	public static void main(String[] args) {
		
		crearArchivo("test", "datos");
		int contador = buscarTexto("test/datos", "Camila");
		System.out.printf("La cantidad de repeticiones es -> %d", contador);
	}
	
	public static void crearArchivo(String directorio, String fichero) {
		
	
		File dir = new File(directorio);
		
		if(!dir.exists()) {
			try {
				dir.mkdir();
				System.out.println("El Directorio fue creado con exito.");
			}catch(Exception e){
				System.out.println("Ha ocurrio un error al crear el directorio");
			}
		}else{
			System.out.println("El Directorio ya existe");
		}
		
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Perro");
		lista.add("Gato");
		lista.add("Juan");
		lista.add("Daniel");
		lista.add("Juan");
		lista.add("Gato");
		lista.add("Perro");
		lista.add("Camila");
		lista.add("Daniel");
		lista.add("Camila");
		lista.add("Juan");
		lista.add("Carlos");
		lista.add("Maria");
		
		Iterator<String> iterator = lista.iterator();
		
		File archivo = new File(directorio + "/"+ fichero + ".txt");
		
		try {
			if(archivo.createNewFile()) {
				System.out.println("Archivo creado exitosamente.");
			}else {
				System.out.println("Archivo ya existe.");
			}
			
			System.out.println(archivo.getAbsolutePath());
			FileWriter writer = new FileWriter(archivo.getAbsolutePath());
			while(iterator.hasNext()){
				writer.write(iterator.next());
				writer.write("\n");
			}
			writer.close();
			
		}catch(Exception e) {
			System.out.println("Error al crear el archivo");
		}
		
		
	}
	
	public static int buscarTexto(String nombreFichero, String texto) {
		int contador = 0;
		
		
		File archivo = new File(nombreFichero + ".txt");
		
		if(!archivo.exists()) {
			System.out.println("Archivo no existe");
			return 0;
		}
		
		try {
			Scanner lector = new Scanner(archivo);
			while(lector.hasNext()){
				String data = lector.next();
				if(data.equals(texto)) {
					contador += 1;
				}
			}
			lector.close();
		}catch(Exception e) {
			System.out.println("Error al leer archivo");
			return 0;
		}
		
		
		return contador;
	}

}
