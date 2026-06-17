package Excepciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Interfaz grafica de usuario (Swing) para el ejercicio CalculosNumericos.
 * Esta clase no duplica la logica matematica ni de validacion: reutiliza
 * los metodos estaticos {@link CalculosNumericos#obtenerLogaritmoNeperiano(double)}
 * y {@link CalculosNumericos#obtenerRaizCuadrada(double)} definidos en la
 * clase CalculosNumericos, y se limita a mostrar los resultados o los
 * mensajes de error en pantalla mediante componentes Swing.
 * @version 1.0/2026
 */
public class CalculosNumericosGUI extends JFrame {

    private final JTextField campoValor;
    private final JTextArea areaResultados;

    public CalculosNumericosGUI() {
        super("Calculos Numericos");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelEntrada = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelEntrada.add(new JLabel("Valor numerico:"));
        campoValor = new JTextField(12);
        panelEntrada.add(campoValor);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton botonLogaritmo = new JButton("Calcular logaritmo neperiano");
        JButton botonRaiz = new JButton("Calcular raiz cuadrada");
        panelBotones.add(botonLogaritmo);
        panelBotones.add(botonRaiz);

        areaResultados = new JTextArea(10, 40);
        areaResultados.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultados);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelEntrada, BorderLayout.NORTH);
        panelSuperior.add(panelBotones, BorderLayout.SOUTH);

        add(panelSuperior, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        botonLogaritmo.addActionListener(this::calcularLogaritmo);
        botonRaiz.addActionListener(this::calcularRaiz);

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Lee el valor introducido por el usuario, delega el calculo del
     * logaritmo neperiano en {@link CalculosNumericos#obtenerLogaritmoNeperiano(double)}
     * y muestra el resultado o el error correspondiente.
     */
    private void calcularLogaritmo(ActionEvent evento) {
        try {
            double valor = leerValor();
            double resultado = CalculosNumericos.obtenerLogaritmoNeperiano(valor);
            mostrarResultado("Logaritmo neperiano de " + valor + " = " + resultado);
        } catch (NumberFormatException e) {
            mostrarError("El valor debe ser numerico para calcular el logaritmo neperiano");
        } catch (ArithmeticException e) {
            mostrarError(e.getMessage());
        }
    }

    /**
     * Lee el valor introducido por el usuario, delega el calculo de la
     * raiz cuadrada en {@link CalculosNumericos#obtenerRaizCuadrada(double)}
     * y muestra el resultado o el error correspondiente.
     */
    private void calcularRaiz(ActionEvent evento) {
        try {
            double valor = leerValor();
            double resultado = CalculosNumericos.obtenerRaizCuadrada(valor);
            mostrarResultado("Raiz cuadrada de " + valor + " = " + resultado);
        } catch (NumberFormatException e) {
            mostrarError("El valor debe ser numerico para calcular la raiz cuadrada");
        } catch (ArithmeticException e) {
            mostrarError(e.getMessage());
        }
    }

    private double leerValor() {
        String texto = campoValor.getText().trim();
        return Double.parseDouble(texto);
    }

    private void mostrarResultado(String mensaje) {
        areaResultados.append(mensaje + System.lineSeparator());
    }

    private void mostrarError(String mensaje) {
        areaResultados.append("Error: " + mensaje + System.lineSeparator());
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Metodo main que lanza la interfaz grafica de CalculosNumericos.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculosNumericosGUI ventana = new CalculosNumericosGUI();
            ventana.setVisible(true);
        });
    }
}
