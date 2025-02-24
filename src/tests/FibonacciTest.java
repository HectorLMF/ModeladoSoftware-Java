package tests;

import org.junit.Test;

import Utils.Fibonacci;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FibonacciTest {

    // Test para fibonacci()
    @Test
    public void testFibonacci() {
        // Usar System.out para capturar la salida
        assertEquals("0 1 1 2 3 5 8 13", captureFibonacciOutput(8));
        assertEquals("0", captureFibonacciOutput(1));
    }

    // Test para fibonacciLimited()
    @Test
    public void testFibonacciLimited() {
        // Rango inferior y superior
        assertEquals("2 3 5 8", captureFibonacciLimitedOutput(2, 10));
        assertEquals("0 1 1", captureFibonacciLimitedOutput(0, 2));
    }

    // Test para checkNumber()
    @Test
    public void testCheckNumber() {
        // Verificar si el número pertenece a la serie de Fibonacci
        assertEquals(true, isFibonacciNumber(5));
        assertFalse(isFibonacciNumber(7));
    }

    // Método auxiliar para capturar la salida de fibonacci()
    private String captureFibonacciOutput(int limit) {
        // Redirigir la salida estándar a una cadena
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Fibonacci.fibonacci(limit);
        return outContent.toString().trim();
    }

    // Método auxiliar para capturar la salida de fibonacciLimited()
    private String captureFibonacciLimitedOutput(int inferior, int superior) {
        // Redirigir la salida estándar a una cadena
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Fibonacci.fibonacciLimited(inferior, superior);
        return outContent.toString().trim();
    }

    // Método auxiliar para verificar si un número es parte de la secuencia Fibonacci
    private boolean isFibonacciNumber(int number) {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        return Fibonacci.checkNumber(number);
    }
}
