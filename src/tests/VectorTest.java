package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Utils.Vector;


public class VectorTest {

    private Vector vector1;
    private Vector vector2;
    private Vector vector3;

    @BeforeEach
    public void setUp() {
        // Inicializa los vectores antes de cada test
        vector1 = new Vector(new double[] {1.0, 2.0, 3.0});
        vector2 = new Vector(new double[] {4.0, 5.0, 6.0});
        vector3 = new Vector(5); // Un vector de tamaño aleatorio
    }

    @Test
    public void testSize() {
        // Verifica que el tamaño del vector sea el correcto
        assertEquals(3, vector1.size());
        assertEquals(3, vector2.size());
    }

    @Test
    public void testToString() {
        // Verifica la conversión a String
        assertEquals("(1.0, 2.0, 3.0)", vector1.toString());
        assertEquals("(4.0, 5.0, 6.0)", vector2.toString());
    }

    @Test
    public void testChangeElement() {
        // Verifica que se pueda cambiar un elemento del vector
        vector1.changeElement(1, 10.0); // Cambia el segundo elemento a 10.0
        assertEquals(10.0, vector1.getComponente(1), 0.0001);
    }

    @Test
    public void testProductoEscalar() throws Exception {
        // Verifica el cálculo del producto escalar entre dos vectores
        Vector result = vector1.productoEscalar(vector2);
        // Producto escalar: 1*4 + 2*5 + 3*6 = 32
        assertEquals("(4.0, 10.0, 18.0)", result.toString());
    }

    @Test
    public void testProductoEscalarDifferentSize() {
        // Verifica que se lance una excepción cuando los vectores tienen tamaños diferentes
        Vector vector4 = new Vector(new double[] {7.0, 8.0}); // Vector de tamaño 2
        Exception exception = assertThrows(Exception.class, () -> {
            vector1.productoEscalar(vector4);
        });
        assertEquals("ERROR: LOS VECTORES DEBEN TENER EL MISMO TAMAÑO", exception.getMessage());
    }

    @Test
    public void testRandomSizedVector() {
        // Verifica que el vector de tamaño aleatorio tenga una longitud válida
        assertTrue(vector3.size() > 0 && vector3.size() <= 10);
    }

    @Test
    public void testGetComponente() {
        // Verifica que se pueda obtener un componente específico
        assertEquals(1.0, vector1.getComponente(0), 0.0001);
        assertEquals(3.0, vector1.getComponente(2), 0.0001);
    }
}
