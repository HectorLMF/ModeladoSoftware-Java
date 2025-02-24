package Utils;

import java.util.Vector;

/**
 * Clase para calcular y manipular la serie de Fibonacci.
 * 
 * Esta clase proporciona métodos para obtener los primeros términos de la serie de Fibonacci,
 * buscar números específicos en la serie, y mostrar la serie dentro de un rango dado.
 */
public class Fibonacci {

    /**
     * Método para calcular los primeros N términos de la serie de Fibonacci.
     * 
     * @param limit El número de términos que se desean obtener de la serie de Fibonacci.
     */
    public static void fibonacci(int limit) {        
        // Creamos un vector para almacenar la serie de Fibonacci
        Vector <Integer> serie = new Vector<Integer>();
        
        // Los primeros dos términos de la serie son 0 y 1
        serie.add(0);
        serie.add(1);
        
        // Continuamos agregando términos hasta llegar al límite
        while (serie.size() < limit) {
            int n = serie.size();
            // El siguiente término es la suma de los dos anteriores
            serie.add(serie.get(n-1) + serie.get(n-2));
        }
        
        // Si el límite es 1, solo mostramos 0
        if(limit == 1) {
            System.out.println("0");
        } else {
            // Mostramos la serie de Fibonacci
            for(int curr: serie){
                System.out.print(curr + " ");
            }
            System.out.println();
        }
    }

    /**
     * Método para calcular los términos de la serie de Fibonacci dentro de un rango dado.
     * 
     * @param inferior El límite inferior del rango (inclusive).
     * @param superior El límite superior del rango (exclusive).
     */
    public static void fibonacciLimited(int inferior, int superior) {
        // Creamos un vector para almacenar la serie de Fibonacci
        Vector <Integer> serie = new Vector<Integer>();
        
        // Los primeros dos términos de la serie son 0 y 1
        serie.add(0);
        serie.add(1);
        
        // Continuamos agregando términos hasta superar el límite superior
        while (serie.lastElement() < superior) {
            int n = serie.size();
            // El siguiente término es la suma de los dos anteriores
            serie.add(serie.get(n-1) + serie.get(n-2));
        }
        
        // Si el límite superior es 1, solo mostramos 0
        if(superior == 1) {
            System.out.println("0");
        } else {
            // Mostramos los números dentro del rango dado
            for(int curr: serie){
                if(curr >= inferior && curr < superior) {
                    System.out.print(curr + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Método para verificar si un número pertenece a la serie de Fibonacci.
     * 
     * @param number El número a verificar.
     */
    public static boolean checkNumber(int number) {
        // Creamos un vector para almacenar la serie de Fibonacci
        Vector <Integer> serie = new Vector<Integer>();
        
        // Los primeros dos términos de la serie son 0 y 1
        serie.add(0);
        serie.add(1);
        
        boolean found = false;
        
        // Generamos la serie hasta superar el número
        while (serie.lastElement() < number) {
            int n = serie.size();
            // El siguiente término es la suma de los dos anteriores
            serie.add(serie.get(n-1) + serie.get(n-2));
        }

        // Buscamos si el número está en la serie
        for(int curr: serie){
            if (curr == number) {
                found = true;
            }
        }
        
        // Mostramos el resultado de la búsqueda
        if(found) {
            System.out.println("El número " + number + " SÍ pertenece a la serie de Fibonacci");
            return true;
        } else {
            System.out.println("El número " + number + " NO pertenece a la serie de Fibonacci");
            return false;
        }
    }
}
