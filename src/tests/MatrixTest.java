package tests;

import Utils.Matrix;
import Utils.Vector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MatrixTest {

    private Matrix matrix;

    @Before
    public void setUp() {
        // Crea una matriz 2x2 con valores predeterminados (0)
        matrix = new Matrix(2, 2);
    }

    @Test
    public void testConstructorDefault() {
        Matrix defaultMatrix = new Matrix();

        assert ( 1 == defaultMatrix.getNumCol());
        assert ( 1 == defaultMatrix.getNumRow());
    }

    @Test
    public void testConstructorWithDimensions() {
        Matrix m = new Matrix(3, 3);
        assert ( 3 == m.getNumCol());
        assert ( 3 == m.getNumRow());
    }

    @Test
    public void testConstructorWithValues() {
        double[][] values = {
            {1, 2},
            {3, 4}
        };

        Matrix m = new Matrix(2, 2, values);

        assert ( 2 == m.getNumCol());
        assert ( 2 == m.getNumRow());
        assert( 1.0 == m.getElement(0,0));
    }

    @Test
    public void testGetElement() {
        matrix = new Matrix(2, 2, new double[][]{
            {1, 2},
            {3, 4}
        });
        assert ( 2 == matrix.getElement(0, 1));
        assert ( 3 == matrix.getElement(1, 0));
    }

    @Test
    public void testToString() {
        Matrix m = new Matrix(2, 2, new double[][]{
                {1, 2},
                {3, 4}
        });
        String expected = "2\n2\n1.0 2.0\n3.0 4.0\n";
        System.out.println(m.toString());
        assert (expected.equals(m.toString()));
    }
}
