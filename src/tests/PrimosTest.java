package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;



import Utils.Primos;
import org.junit.Test;

public class PrimosTest {

    @Test
    public void testPrimosSmallRange() {
        // Probamos con un rango pequeño (max = 10)
        int expectedSum = 17; // 2 + 3 + 5 + 7 = 17
        int result = Primos.primos(10);
        assertEquals(expectedSum, result);
    }

    @Test
    public void testPrimosMediumRange() {
        // Probamos con un rango de tamaño medio (max = 20)
        int expectedSum = 77; // 2 + 3 + 5 + 7 + 11 + 13 + 17 + 19 = 77
        int result = Primos.primos(20);
        assertEquals(expectedSum, result);
    }

    @Test
    public void testPrimosLargeRange() {
        // Probamos con un rango más grande (max = 50)
        int expectedSum = 328; // Suma de los primos hasta 50
        int result = Primos.primos(50);
        assertEquals(expectedSum, result);
    }

    @Test
    public void testPrimosWithOne() {
        // Probamos con max = 1, que no debería devolver ningún primo
        int expectedSum = 0; 
        int result = Primos.primos(1);
        assertEquals(expectedSum, result);
    }

    @Test
    public void testPrimosWithTwo() {
        // Probamos con max = 2, que debería devolver solo el primo 2
        int expectedSum = 2; 
        int result = Primos.primos(3);
        assertEquals(expectedSum, result);
    }
    
    @Test
    public void testPrimosWithNegativeRange() {
        // Probamos con un rango negativo, lo cual debería dar un resultado 0
        int expectedSum = 0; 
        int result = Primos.primos(-5);
        assertEquals(expectedSum, result);
    }
}
