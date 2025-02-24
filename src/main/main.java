package main;

import java.util.Scanner;
import Utils.Fibonacci;
import Utils.FileUtils;
import Utils.Primos;
import Utils.Vector;
import Utils.Matrix;

/**
 * Clase principal que contiene el menú y la interacción del usuario con diversas funcionalidades como números primos, Fibonacci, vectores y matrices.
 */
public class main {

    /**
     * Muestra el menú de opciones para trabajar con vectores y permite al usuario realizar diversas operaciones.
     *
     * @param s Scanner para la entrada de datos del usuario.
     */
    private static void menuVector(Scanner s) {

        int opcion = -1;
        Vector vector = null;
        boolean creado = false;

        while (opcion != 0) {
            System.out.println("\n--- MENÚ: VECTOR---");

            if(creado) {
                vector.print();
                System.out.println("Dimension: "+ vector.size());
            }

            System.out.println("1. Crear vector");
            System.out.println("2. Producto escalar");
            System.out.println("3. Guardar en archivo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = s.nextInt();

            switch (opcion) {
                case 1:
                    if(creado) {
                        System.out.println("Ya has inicializado el vector!");
                        break;
                    }
                    else {
                        creado = true;
                    }

                    System.out.println("Numero de componentes?");
                    int size = s.nextInt();

                    double[] componentes = new double[size];

                    for (int i = 0; i < size; i++) {
                        System.out.print("Componente numero "+ i+":");
                        double comp = s.nextDouble();
                        componentes[i] = comp;
                    }

                    vector = new Vector(componentes);
                    break;
                case 2:
                    double[] newComps = new double[vector.size()];
                    System.out.println("Inicializando un segundo vector de dimension "+ vector.size());

                    for (int i = 0; i < vector.size(); i++) {
                        System.out.print("Componente numero "+ i+":");
                        double comp = s.nextDouble();
                        newComps[i] = comp;
                    }

                    Vector newVector = new Vector(newComps);

                    try {
                        vector.productoEscalar(newVector);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    FileUtils utils = new FileUtils();

                    String currAbsolutePathString = "E:/output/";
                    String nombre = "";

                    s.nextLine();
                    System.out.println("Introduzca el nombre del archivo:");
                    nombre = s.nextLine();

                    currAbsolutePathString = currAbsolutePathString +"/"+nombre;
                    utils.escribirArchivo(currAbsolutePathString, vector.toString());
                    break;
                case 0:
                    System.out.println("Volviendo a Menu Principal...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;
            }
        }
    }

    /**
     * Muestra el menú de opciones para trabajar con matrices y permite al usuario realizar diversas operaciones.
     *
     * @param s Scanner para la entrada de datos del usuario.
     */
    private static void menuMatrix(Scanner s) {

        int opcion = -1;
        Matrix matrix = null;
        boolean creadaMatrix = false;

        while (opcion != 0) {
            System.out.println("\n--- MENÚ: MATRIZ---");

            if(creadaMatrix) {
                matrix.print();
                System.out.println("Dimension: "+ matrix.getNumRow() + "x" + matrix.getNumCol());
            }

            System.out.println("1. Crear matriz");
            System.out.println("2. Producto de 2 matrices");
            System.out.println("3. Guardar en archivo");
            System.out.println("4. Leer en archivo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = s.nextInt();

            switch (opcion) {
                case 1:
                    if(creadaMatrix) {
                        System.out.println("Ya has inicializado la matriz!");
                        break;
                    }
                    else {
                        creadaMatrix = true;
                    }

                    System.out.println("Número de filas:");
                    int rows = s.nextInt();

                    System.out.println("Número de columnas:");
                    int cols = s.nextInt();

                    double[][] elementos = new double[rows][cols];

                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.print("Componente (" + i + "," + j + "): ");
                            elementos[i][j] = s.nextDouble();
                        }
                    }
                    matrix = new Matrix(rows, cols, elementos);
                    break;
                case 2:

                    // Solicitar las dimensiones de la segunda matriz
                    int n2 = matrix.getNumCol();  // Las columnas de la primera matriz (n)
                    int l = matrix.getNumRow();

                    System.out.println("Dimensiones de la Matriz 2:");
                    System.out.println(n2 + ", " +l);


                    // Crear y llenar la segunda matriz
                    double[][] matrixB = new double[n2][l];
                    System.out.println("Introduce los elementos de la segunda matriz:");
                    for (int i = 0; i < n2; i++) {
                        for (int j = 0; j < l; j++) {
                            System.out.print("Elemento B[" + i + "][" + j + "]: ");
                            matrixB[i][j] = s.nextDouble();
                        }
                    }


                    Matrix matrix2 = new Matrix(l, n2, matrixB);

                    matrix.producto(matrix2);


                    break;

                case 3:
                    FileUtils utils = new FileUtils();

                    String currAbsolutePathString = "E:/output/";
                    String nombre = "";

                    s.nextLine();
                    System.out.println("Introduzca el nombre del archivo:");
                    nombre = s.nextLine();

                    currAbsolutePathString = currAbsolutePathString +"/"+nombre;
                    utils.escribirArchivo(currAbsolutePathString, matrix.toString());
                    break;

                case 4:

                    if(!creadaMatrix) {
                        matrix = new Matrix();
                    }

                    FileUtils utils2 = new FileUtils();

                    String currPath = "E:/output/";
                    String nombreInput = "";

                    s.nextLine();
                    System.out.println("Introduzca el nombre del archivo:");
                    nombre = s.nextLine();

                    currPath = currPath +"/"+nombre;

                    matrix.read(currPath);

                    break;



                case 0:
                    System.out.println("Volviendo a Menu Principal...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;
            }
        }
    }

    /**
     * Función principal que muestra el menú y permite al usuario interactuar con las funcionalidades del programa.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

        Primos primos = new Primos();
        Fibonacci fibonacci = new Fibonacci();

        int opc = -1;

        Scanner s = new Scanner(System.in);

        while (opc != 0) {
            System.out.println("---------------------------------------------");
            System.out.println("Menu - Practica 1 - Modelado de Software");
            System.out.println("0. Salir del programa");
            System.out.println("1. Encontrar numeros primos en un rango y sumarlos");
            System.out.println("2. Encontrar los N primeros numeros de la serie de Fibonacci");
            System.out.println("3. Encontrar la Serie de Fibonacci entre 2 numeros");
            System.out.println("4. Comprobar si un numero pertenece a la Serie de Fibonacci");
            System.out.println("5. Funciones del vector N-Dimensional");
            System.out.println("6. Funciones de la matriz");

            opc = s.nextInt();

            int limit = -1;

            switch (opc) {
                case 1:
                    System.out.println("Introduzca el limite superior:");
                    limit = s.nextInt();

                    System.out.println("Sumatorio: "+ primos.primos(limit));
                    break;
                case 2:
                    System.out.println("Introduzca el numero de terminos:");
                    limit = s.nextInt();

                    if(limit < 1) {
                        System.out.println("ERROR: Limite incorrecto");
                    }else {
                        System.out.println("La serie es: ");
                        fibonacci.fibonacci(limit);
                    }
                    break;

                case 3:
                    System.out.println("Introduzca el limite inferior");
                    int inferior = s.nextInt();
                    s.nextLine();

                    System.out.println("Introduzca el limite superior");
                    int superior = s.nextInt();

                    if (superior <= inferior) {
                        System.out.println("Error, limite inferior debe de ser menor que superior");
                    }else if(inferior < 0 || superior < 0) {
                        System.out.println("Error, los numeros deben ser naturales positivos");
                    }else {
                        fibonacci.fibonacciLimited(inferior, superior);
                    }
                    break;

                case 4:
                    System.out.println("Introduzca el numero a comprobar:");
                    int number = s.nextInt();

                    if(number < 0) {
                        System.out.println("Error; el numero debe de ser natural positivo");
                    }
                    else {
                        fibonacci.checkNumber(number);
                    }
                    break;

                case 5:
                    menuVector(s);
                    break;

                case 6:
                    menuMatrix(s);
                    break;

                default:
                    if(opc != 0)
                        System.out.println("Opcion invalida");
                    break;
            }
        }
        s.close();
        System.exit(0);
        return;
    }
}
