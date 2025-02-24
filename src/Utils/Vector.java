package Utils;

/**
 * La clase {@code Vector} representa un vector matemático de componentes tipo {@code double}.
 * Permite realizar operaciones como la creación de vectores, obtener el tamaño, cambiar elementos,
 * realizar productos escalares y convertir el vector a formato de cadena.
 */
public class Vector {
    
    private double coeficientes[];
    
    /**
     * Constructor que inicializa el vector con los coeficientes proporcionados.
     *
     * @param coeficientes Un arreglo de tipo {@code double} que contiene los coeficientes del vector.
     */
    public Vector(double[] coeficientes) {
        this.coeficientes = coeficientes;
    }
    
    /**
     * Constructor que inicializa un vector de tamaño fijo con componentes aleatorias.
     *
     * @param size El tamaño del vector.
     */
    //Este constructor inicializa un vector de tamaño fijo pero con componentes aleatorias
    public Vector(int size) {
        coeficientes = new double[size];
        for (double coef : coeficientes) {
            coef = Math.random() * 10;
        }
    }
    
    /**
     * Constructor que inicializa un vector de tamaño aleatorio y con componentes aleatorias.
     */
    public Vector() {
        int size = (int) Math.round(Math.random() * 10);
        this.coeficientes = new double[size];
        
        for (double coef : coeficientes) {
            coef = Math.random() * 10;
        }
    }
    
    /**
     * Obtiene el tamaño del vector.
     *
     * @return El número de componentes del vector.
     */
    public int size() {
        return coeficientes.length;
    }
    
    /**
     * Convierte el vector a una cadena de texto en formato "(coef1, coef2, ..., coefN)".
     *
     * @return Una representación en cadena del vector.
     */
    public String toString() {
        StringBuffer output = new StringBuffer("(");
        
        int i = 0;
        for (double coef : coeficientes) {
            output.append(coef);
            
            String separador = (i < coeficientes.length - 1) ? ", " : ")";
            output.append(separador);
            i++;
        }
        
        return output.toString();
    }
    
    /**
     * Imprime la representación en cadena del vector en la consola.
     */
    public void print() {
        System.out.println(this.toString());
    }
    
    /**
     * Cambia el valor de un componente específico del vector.
     *
     * @param i El índice del componente a cambiar.
     * @param coef El nuevo valor para el componente en la posición {@code i}.
     */
    public void changeElement(int i, double coef) {
        coeficientes[i] = coef;
    }
    
    /**
     * Obtiene el valor de un componente específico del vector.
     *
     * @param i El índice del componente a obtener.
     * @return El valor del componente en la posición {@code i}.
     */
    public double getComponente(int i) {
        return coeficientes[i];
    }
    
    /**
     * Realiza el producto escalar entre el vector actual y otro vector proporcionado.
     *
     * @param vector El otro vector con el que realizar el producto escalar.
     * @return Un nuevo vector resultante del producto escalar.
     * @throws Exception Si los vectores no tienen el mismo tamaño.
     */
    public Vector productoEscalar(Vector vector) throws Exception {
        if (vector.size() != this.size()) {
            throw new Exception("ERROR: LOS VECTORES DEBEN TENER EL MISMO TAMAÑO");
        }
        
        Vector output = new Vector(this.size());
        for (int i = 0; i < this.size(); i++) {
            output.changeElement(i, coeficientes[i] * vector.getComponente(i));
        }
        System.out.println(this.toString() + " ⋅ " + vector.toString() + " = " + output.toString());
        return output;
    }
    
    /**
     * Escribe la representación en cadena del vector en un archivo en la ruta especificada.
     *
     * @param ruta La ruta del archivo donde escribir el vector.
     */
    public void write(String ruta) {
        FileUtils.escribirArchivo(ruta, this.toString());
    }
}
