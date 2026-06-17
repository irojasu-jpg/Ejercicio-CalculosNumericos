package Excepciones;

import java.util.*;

/**
 * Esta clase denominada CalculosNumericos permite realizar dos
 * calculos matematicos: calcular el logaritmo neperiano de un valor y
 * calcular la raiz cuadrada de un valor.
 * @version 1.2/2020
 */
public class CalculosNumericos {

    /**
     * Metodo que calcula el logaritmo neperiano de un valor numerico.
     * Si el valor pasado como parametro no es correcto se genera la
     * excepcion correspondiente.
     * @param valor Parametro que define el valor al cual se le calculara
     * el logaritmo neperiano
     * @throws ArithmeticException Excepcion aritmetica que indica
     * que el numero debe ser positivo
     * @throws InputMismatchException Excepcion que indica que el
     * valor ingresado debe ser numerico
     */
    public static void calcularLogaritmoNeperiano(double valor) {
        try {
            double resultado = obtenerLogaritmoNeperiano(valor);
            System.out.println("Resultado = " + resultado);
        } catch (ArithmeticException e) {
            /* Si ocurre una excepcion aritmetica, se muestra un mensaje
             * de error */
            System.out.println("El valor debe ser un numero positivo para "
                    + "calcular el logaritmo neperiano");
        } catch (InputMismatchException e) {
            /* Si el valor a calcular no es numerico, se muestra un mensaje
             * de error */
            System.out.println("El valor debe ser numerico para calcular "
                    + "el logaritmo");
        }
    }

    /**
     * Metodo de calculo reutilizable que obtiene el logaritmo neperiano
     * de un valor numerico y devuelve el resultado al codigo llamador
     * (por ejemplo, la version de consola o una interfaz grafica),
     * en lugar de imprimirlo directamente. Contiene la misma logica
     * de validacion que el ejercicio original.
     * @param valor Parametro que define el valor al cual se le calculara
     * el logaritmo neperiano
     * @return El logaritmo neperiano del valor indicado
     * @throws ArithmeticException Excepcion aritmetica que indica
     * que el numero debe ser positivo
     */
    public static double obtenerLogaritmoNeperiano(double valor) {
        if (valor < 0) {
            /* Si el valor es negativo, se genera una excepcion aritmetica */
            throw new ArithmeticException("El valor debe ser un numero positivo para "
                    + "calcular el logaritmo neperiano");
        }
        /* Si el valor es positivo, se calcula el algoritmo neperiano */
        return Math.log(valor);
    }

    /**
     * Metodo que calcula la raiz cuadrada de un valor numerico.
     * Si el valor pasado como parametro no es correcto se genera la
     * excepcion correspondiente.
     * @param valor Parametro que define el valor al cual se le calculara
     * la raiz cuadrada
     * @throws ArithmeticException Excepcion aritmetica que indica
     * que el numero debe ser positivo
     * @throws InputMismatchException Excepcion que indica que el
     * valor ingresado debe ser numerico
     */
    public static void calcularRaizCuadrada(double valor) {
        try {
            double resultado = obtenerRaizCuadrada(valor);
            System.out.println("Resultado = " + resultado);
        } catch (ArithmeticException e) {
            /* Si ocurre una excepcion aritmetica, se muestra un mensaje
             * de error */
            System.out.println("El valor debe ser un numero positivo para "
                    + "calcular la raiz cuadrada");
        } catch (InputMismatchException e) {
            /* Si el valor a calcular no es numerico, se muestra un mensaje
             * de error */
            System.out.println("El valor debe ser numerico para calcular "
                    + "la raiz cuadrada");
        }
    }

    /**
     * Metodo de calculo reutilizable que obtiene la raiz cuadrada
     * de un valor numerico y devuelve el resultado al codigo llamador
     * (por ejemplo, la version de consola o una interfaz grafica),
     * en lugar de imprimirlo directamente. Contiene la misma logica
     * de validacion que el ejercicio original.
     * @param valor Parametro que define el valor al cual se le calculara
     * la raiz cuadrada
     * @return La raiz cuadrada del valor indicado
     * @throws ArithmeticException Excepcion aritmetica que indica
     * que el numero debe ser positivo
     */
    public static double obtenerRaizCuadrada(double valor) {
        if (valor < 0) {
            /* Si el valor es negativo, se genera una excepcion aritmetica */
            throw new ArithmeticException("El valor debe ser un numero positivo para "
                    + "calcular la raiz cuadrada");
        }
        return Math.sqrt(valor);
    }

    /**
     * Metodo main que solicita un valor numerico por teclado. Para
     * dicho valor se calcula el logaritmo neperiano y la raiz cuadrada. Si
     * el valor ingresado no es correcto, se generan las excepciones
     * correspondientes.
     */
    public static void main(String args[]) {
        System.out.print("Valor numerico = ");
        Scanner teclado = new Scanner(System.in);
        try {
            double valor = teclado.nextDouble();
            calcularLogaritmoNeperiano(valor);
            calcularRaizCuadrada(valor);
        } catch (InputMismatchException e) {
            System.out.println("El valor debe ser numerico");
        }
    }
}
