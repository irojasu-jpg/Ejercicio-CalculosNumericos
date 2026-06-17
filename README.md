# Ejercicio - Calculos Numericos

Implementacion del ejercicio 6.6 "Genericidad, excepciones y lectura/escritura
de archivos" del libro *Ejercicios de programacion orientada a objetos con
Java y UML*.

## Enunciado

Se requiere definir una clase denominada `CalculosNumericos` que realice las
siguientes operaciones:

- Calcular el logaritmo neperiano recibiendo un valor `double` como
  parametro. Este metodo debe ser estatico. Si el valor no es positivo se
  genera una excepcion aritmetica.
- Calcular la raiz cuadrada recibiendo un valor `double` como parametro.
  Este metodo debe ser estatico. Si el valor no es positivo se genera una
  excepcion aritmetica.

Se debe crear un metodo `main` que utilice dichos metodos ingresando un
valor por teclado. Si el valor introducido no es numerico, se debe
gestionar mediante `InputMismatchException`.

## Estructura del proyecto

```
Ejercicio-CalculosNumericos/
|-- src/
|   `-- Excepciones/
|       |-- CalculosNumericos.java       (clase original, version consola)
|       `-- CalculosNumericosGUI.java    (interfaz grafica Swing)
|-- diagrams/
|   |-- class_diagram.png
|   |-- use_case_diagram.png
|   `-- Diagramas_CalculosNumericos.docx
|-- bin/                                  (clases compiladas)
`-- README.md
```

La clase `CalculosNumericos` contiene, ademas de los metodos originales
`calcularLogaritmoNeperiano(double)` y `calcularRaizCuadrada(double)`
(que imprimen el resultado por consola, igual que en el libro), dos
metodos auxiliares reutilizables `obtenerLogaritmoNeperiano(double)` y
`obtenerRaizCuadrada(double)` que devuelven el resultado (o lanzan
`ArithmeticException`) en lugar de imprimirlo. La interfaz grafica
`CalculosNumericosGUI` reutiliza estos metodos auxiliares para no duplicar
la logica de calculo ni de validacion.

## Compilacion

Desde la raiz del proyecto:

```bash
javac -d bin src/Excepciones/*.java
```

## Ejecucion (version consola)

```bash
java -cp bin Excepciones.CalculosNumericos
```

El programa solicita un valor numerico por teclado y muestra el resultado
del logaritmo neperiano y de la raiz cuadrada, o el mensaje de error
correspondiente si el valor no es positivo o no es numerico.

Ejemplo:

```
Valor numerico = -200
El valor debe ser un numero positivo para calcular el logaritmo neperiano
El valor debe ser un numero positivo para calcular la raiz cuadrada
```

## Ejecucion (version grafica)

```bash
java -cp bin Excepciones.CalculosNumericosGUI
```

Se abre una ventana con un campo "Valor numerico", dos botones ("Calcular
logaritmo neperiano" y "Calcular raiz cuadrada") y un area de resultados.
Los errores (valor no numerico o no positivo) se muestran tambien mediante
un cuadro de dialogo (`JOptionPane`).

## Diagramas

En la carpeta `diagrams/` se incluyen el diagrama de clases UML, el
diagrama de casos de uso y un documento Word (`Diagramas_CalculosNumericos.docx`)
con la explicacion de ambos diagramas.
