package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utilidad para manejar operaciones con archivos, como escribir y leer contenidos de archivos.
 * Esta clase proporciona métodos para escribir un archivo con un contenido dado y leer el contenido de un archivo.
 */
public class FileUtils {

    /**
     * Escribe el contenido en un archivo especificado por la ruta proporcionada.
     * Si el directorio donde se encuentra el archivo no existe, se crea automáticamente.
     * 
     * @param ruta La ruta del archivo donde se desea escribir el contenido.
     * @param contenido El contenido que se desea escribir en el archivo.
     */
    public static void escribirArchivo(String ruta, String contenido) {
    	
    	System.out.println("Ruta del archivo: " + ruta);
    	    
	    // Crear directorio si no existe
	    java.io.File archivo = new java.io.File(ruta);
	    java.io.File directorio = archivo.getParentFile();
	    
    	// Mostrar información sobre el directorio
    	System.out.println("Existe el directorio: " + directorio.exists());
    	System.out.println("Es un directorio: " + directorio.isDirectory());
    	System.out.println("¿Se puede escribir?: " + directorio.canWrite());
	    
	    // Si el directorio no existe, lo creamos
	    if (directorio != null && !directorio.exists()) {
	        directorio.mkdirs();
	    }
	    
	    // Intentamos escribir el contenido en el archivo
	    try (FileWriter writer = new FileWriter(ruta)) {
	        writer.write(contenido);
	        System.out.println("Archivo escrito correctamente en: " + ruta);
	    } catch (IOException e) {
	        // Imprimir traza completa del error si ocurre una excepción
	        e.printStackTrace();
	    }
    }
    
    /**
     * Lee el contenido de un archivo y lo devuelve como una cadena de texto.
     * 
     * @param filename El nombre del archivo que se va a leer.
     * @return El contenido del archivo como una cadena de texto.
     */
    public static String readFile(String filename) {
        StringBuilder content = new StringBuilder();
        
        // Intentamos leer el archivo línea por línea
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");  // Agregar la línea al contenido
            }
        } catch (IOException e) {
            // Mostrar el mensaje de error si ocurre una excepción
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        
        // Devolver el contenido del archivo como un String
        return content.toString();
    }
}
