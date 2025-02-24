package Utils;

/**
 * Representa una matriz matemática, donde las columnas están representadas por vectores.
 * La clase proporciona métodos para crear matrices, leer matrices desde un archivo,
 * imprimir matrices, y realizar operaciones como la multiplicación de matrices.
 */
public class Matrix {
    private Vector[] columnas;  // Un arreglo de vectores, cada uno representa una columna
    
    /**
     * Constructor por defecto que crea una matriz de 1x1 con valor 0.
     */
    public Matrix() {
        this(1, 1);  // Llama al constructor con parámetros
    }

    /**
     * Constructor que crea una matriz de dimensiones m x n con valores 0.
     * 
     * @param m Número de filas de la matriz.
     * @param n Número de columnas de la matriz.
     */
    public Matrix(int m, int n) {
        columnas = new Vector[n];
        for (int i = 0; i < n; i++) {
            columnas[i] = new Vector(m);  // Cada columna es un vector de tamaño m con todos los elementos en 0
        }
    }

    /**
     * Constructor que crea una matriz a partir de un array 2D de coeficientes.
     * 
     * @param m Número de filas de la matriz.
     * @param n Número de columnas de la matriz.
     * @param coef Array 2D que contiene los valores de la matriz.
     * @throws IllegalArgumentException Si las dimensiones del array no coinciden con las dimensiones de la matriz.
     */
    public Matrix(int m, int n, double[][] coef) {
        if (coef.length != m || coef[0].length != n) {
            throw new IllegalArgumentException("Las dimensiones del array no coinciden con las dimensiones de la matriz.");
        }
        columnas = new Vector[n];
        for (int i = 0; i < n; i++) {
            double[] columna = new double[m];
            for (int j = 0; j < m; j++) {
                columna[j] = coef[j][i];  // Almacenamos las columnas del array 2D en los vectores
            }
            columnas[i] = new Vector(columna);  // Crear un vector para cada columna
        }
    }

    /**
     * Devuelve el número de filas de la matriz.
     * 
     * @return El número de filas de la matriz.
     */
    public int getNumRow() {
        return columnas[0].size();
    }

    /**
     * Devuelve el número de columnas de la matriz.
     * 
     * @return El número de columnas de la matriz.
     */
    public int getNumCol() {
        return columnas.length;
    }

    /**
     * Devuelve una representación en formato string de la matriz.
     * 
     * @return Una cadena que representa la matriz.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(getNumRow()).append("\n");  // Número de filas
        sb.append(getNumCol()).append("\n");  // Número de columnas

        // Añadir los elementos de la matriz
        for (int i = 0; i < getNumRow(); i++) {
            for (int j = 0; j < getNumCol(); j++) {
                sb.append(getElement(i, j));
                if (j < getNumCol() - 1) {
                    sb.append(" ");  // Espacio entre los elementos de la fila
                }
            }
            sb.append("\n");  // Salto de línea al final de cada fila
        }
        
        return sb.toString();
    }

    /**
     * Imprime la matriz en la consola.
     */
    public void print() {
        for (int i = 0; i < getNumRow(); i++) {
            for (int j = 0; j < getNumCol(); j++) {
                System.out.print(columnas[j].getComponente(i) + "\t");  // Imprimir cada componente de la matriz
            }
            System.out.println();  // Salto de línea después de cada fila
        }
    }

    /**
     * Devuelve una columna específica de la matriz.
     * 
     * @param index Índice de la columna que se desea obtener.
     * @return El vector que representa la columna especificada.
     */
    public Vector getColumn(int index) {
        return columnas[index];
    }

    /**
     * Devuelve el elemento en la fila y columna especificadas.
     * 
     * @param row Fila del elemento a obtener.
     * @param col Columna del elemento a obtener.
     * @return El valor del elemento en la posición especificada.
     */
    public double getElement(int row, int col) {
        return columnas[col].getComponente(row);  // Obtener el componente de la columna 'col' y fila 'row'
    }

    /**
     * Realiza el producto de la matriz actual con otra matriz dada.
     * 
     * @param matrixB La segunda matriz con la que se realiza la multiplicación.
     */
    public void producto(Matrix matrixB) {
        int m = this.getNumRow();       // Filas de la primera matriz
        int n = this.getNumCol();       // Columnas de la primera matriz

        // Crear la matriz resultante
        double[][] result = new double[m][n];

        // Multiplicar las matrices
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;  // Inicializar el valor en la posición (i,j)
                for (int k = 0; k < n; k++) {
                    result[i][j] += this.getElement(i, k) * matrixB.getElement(k, j);
                }
            }
        }

        // Imprimir el resultado del producto
        System.out.println("Resultado del producto de matrices:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + "\t");  // Imprimir el resultado
            }
            System.out.println();  // Salto de línea para cada fila
        }
    }

    /**
     * Lee una matriz desde un archivo y la inicializa con los datos leídos.
     * El archivo debe contener el número de filas y columnas en las dos primeras líneas, seguido de los valores de la matriz.
     * 
     * @param filename El nombre del archivo desde el cual leer la matriz.
     */
    public void read(String filename) {
        String content = FileUtils.readFile(filename);  // Leer el contenido del archivo
        
        String[] lines = content.split("\n");  // Dividir el contenido por líneas
        
        int rows = Integer.parseInt(lines[0].trim());  // Primera línea: número de filas
        int cols = Integer.parseInt(lines[1].trim());  // Segunda línea: número de columnas

        Double[][] matriz = new Double[rows + 1][cols + 1];
        
        System.out.println("Filas: " + rows + ", Columnas: " + cols);

        // Inicializar la matriz con los valores leídos
        int row = 0;
        int col = 0;
        int it = 0;

        for (String opt : lines) {
            if (it > 1) {
                String[] words = opt.split("\\s+");  // Divide por uno o más espacios
                row = 0;
                for (String word : words) {
                    matriz[row][col] = Double.parseDouble(word);  // Asignar el valor de la matriz
                    row++;
                }
                col++;
            } else {
                it++;
            }
        }
        
        System.out.println("Matriz leída correctamente desde el archivo:");
        System.out.println("Inicializando con nuevos valores");

        columnas = new Vector[rows];
        for (int i = 0; i < rows; i++) {
            double[] columna = new double[cols];
            for (int j = 0; j < cols; j++) {
                columna[j] = matriz[j][i];  // Almacenar las columnas del array 2D en los vectores
            }
            columnas[i] = new Vector(columna);  // Crear un vector para cada columna
        }
        
        print();  // Mostrar la matriz leída
    }
}
