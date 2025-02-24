Práctica 1 - Programación orientada a objetos en Java

1. Escribe un programa en Java, con una clase denominada Primos, que muestre en
pantalla los números primos (aquellos que sólo son divisibles por si mismos y por la
unidad) comprendidos entre el 1 y el 100. Añade un método que calcule la suma de los
mismos. Parametriza el código de forma que el límite superior del intervalo sea una
variable solicitada por teclado.

3. Escribe un programa en Java, con una clase denominada SerieFibonacci, que muestre
en pantalla los n primeros elementos de la sucesión de Fibonacci: 1, 1, 2, 3, 5, 8, … El
programa solicitará la introducción del número n.

5. Añade a la clase anterior un método que muestre en pantalla los elementos de la serie
comprendidos en un determinado intervalo [n1, n2]. Añade otro método que permita
determinar si un número entero dado pertenece o no a la serie.

7. Escribe un programa en Java, con una clase denominada Vector, que almacene un
vector n-dimensional de doubles. La clase debe tener un método para mostrar la
dimensión del vector. Incluye también un método print que muestre en pantalla los
coeficientes del vector. Incluye otro método que permita realizar el producto escalar
de 2 vectores n-dimensionales. Llama al método anterior productoEscalar. Añade los
constructores para la clase que estimes oportunos. El programa solicitará la dimensión
de los vectores a multiplicar y las componentes de ambos vectores, mostrando los
vectores y el resultado en pantalla.

9. Añade a la clase Vector un método write para escribir los datos del vector en un
fichero de texto plano, donde cada coeficiente está separado del siguiente por una
coma. El método recibe como argumento el nombre del fichero.

11. Escribe un programa en Java, con una clase denominada Matrix, que almacene una
matriz de doubles de dimensiones mxn, donde m representa el número de filas y n el
número de columnas. La clase tiene, al menos, los siguientes métodos: Un método
denominado getNumRow que proporciona el número de filas. Un método
denominado getNumCol que proporciona el número de columnas. Un método print
que muestra en pantalla la matriz almacenada en la clase. La clase tiene además tres
constructores: Matrix() crea una matriz de dimensión 1x1 con un único elemento 0.
Matrix(int m, int n) crea una matriz de dimensión mxn con todos sus elementos a 0.
Matriz(int m, int n, double[][] coef) crea una matriz de dimensión mxn con los
elementos del array bidimensional coef.

13. Añade un método que realice el producto de 2 matrices de dimensiones mxn y nxl,
respectivamente. El programa solicitará las dimensiones de las matrices a multiplicar y
los elementos de las mismas por teclado, mostrando el resultado de la operación en
pantalla.

15. Añade a la clase Matrix un método read para leer los datos de la matriz desde un
fichero de texto plano con el siguiente formato: Primera línea: número de filas,
segunda línea, número de columnas, siguientes líneas correspondientes a cada una de
las filas de la matriz. El método recibe como argumento el nombre del fichero.

17. Añade a la clase Matrix un método write para escribir los datos de la matriz en un
fichero de texto plano con el siguiente formato: Primera línea: número de filas,
segunda línea, número de columnas, siguientes líneas correspondientes a cada una de
las filas de la matriz. El método recibe como argumento el nombre del fichero.

19. Comprueba el buen funcionamiento de todas las clases anteriores usando Junit. Añade
comentarios y documentación empotrada al código y genera la documentación
asociada
