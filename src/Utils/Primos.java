package Utils;

import java.util.Arrays;
import java.util.Vector;

/**
 * La clase {@code Primos} contiene un método para encontrar números primos
 * utilizando el algoritmo de la Criba de Eratóstenes.
 */
public class Primos {

    /**
     * Encuentra los números primos en el rango de 1 a {@code max} utilizando
     * la Criba de Eratóstenes.
     *
     * @param max El valor máximo hasta el cual se buscarán los números primos.
     * @return La suma de todos los números primos encontrados en el rango.
     */
    public static int primos(int max) {
        
        int result = 0;
        
        // Declara un arreglo de Booleanos para marcar los números primos
        Boolean isPrime[] = new Boolean[100];
        Arrays.fill(isPrime, true);
        
        // Declara un vector dinámico que almacenará los números primos
        Vector<Integer> primos = new Vector<Integer>();
        
        // Marca los números 0 y 1 como no primos
        isPrime[0] = isPrime[1] = false;
        
        // Recorre todos los números desde 2 hasta max
        for (int i = 2; i < max; ++i) {
            
            // Si el número actual es primo
            if (isPrime[i]) {
                
                // Añade el número primo al vector
                primos.add(i);
                
                // Marca los múltiplos de i como no primos
                for (int h = 2; h * i < max; ++h) {
                    isPrime[i * h] = false;
                }
            }
        }
        
        // Muestra los números primos encontrados
        System.out.print("Numeros primos en el rango 1, ");
        System.out.print(max);
        System.out.println(" :");
        
        // Imprime los números primos y suma su valor
        for (Integer curr : primos) {
            System.out.print(curr);
            System.out.print(" ");
            result = result + curr;
        }
        System.out.println("");
        
        // Retorna la suma de los números primos
        return result;
    }
}
