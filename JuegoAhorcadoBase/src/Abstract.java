/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chung
 */import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Abstract extends JFrame {
    private AdminPalabrasSecretas admin;
    private JuegoAhorcadoFijo juegoFijo;
    private JuegoAhorcadoAzar juegoAzar;
    private JTextArea areaJuego;
    private JTextField campoLetra;
    private JButton botonProbarLetra;

    public abstract() {
        setTitle("Juego del Ahorcado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        admin = new AdminPalabrasSecretas();
        admin.agregarPalabra("java");
        admin.agregarPalabra("programacion");
        admin.agregarPalabra("ahorcado");

        JPanel panelBotones = new JPanel();
        JButton botonFijo = new JButton("Juego con Palabra Fija");
        JButton botonAzar = new JButton("Juego con Palabra al Azar");

        areaJuego = new JTextArea();
        areaJuego.setEditable(false);
        areaJuego.setText("Seleccione un juego para comenzar...");

        campoLetra = new JTextField(5);
        botonProbarLetra = new JButton("Probar Letra");
        botonProbarLetra.setEnabled(false);

        // Acción para el juego fijo
        botonFijo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                juegoFijo = new JuegoAhorcadoFijo("java");
                iniciarJuego(juegoFijo);
            }
        });

        // Acción para el juego al azar
        botonAzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = admin.seleccionarPalabraAzar();
                juegoAzar = new JuegoAhorcadoAzar(palabra);
                iniciarJuego(juegoAzar);
            }
        });

        // Acción para probar letras
        botonProbarLetra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String letra = campoLetra.getText().toLowerCase();
                if (letra.length() == 1) {
                    if (juegoFijo != null) {
                        juegoFijo.jugar(letra.charAt(0));
                        actualizarEstado(juegoFijo);
                    } else if (juegoAzar != null) {
                        juegoAzar.jugar(letra.charAt(0));
                        actualizarEstado(juegoAzar);
                    }
                    campoLetra.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese solo una letra.");
                }
            }
        });

        panelBotones.add(botonFijo);
        panelBotones.add(botonAzar);

        JPanel panelInferior = new JPanel();
        panelInferior.add(new JLabel("Letra:"));
        panelInferior.add(campoLetra);
        panelInferior.add(botonProbarLetra);

        add(panelBotones, BorderLayout.NORTH);
        add(new JScrollPane(areaJuego), BorderLayout.CENTER);
        add(panelInferior, BorderLayout.SOUTH);
    }

    private void iniciarJuego(JuegoAhorcadoBase juego) {
        areaJuego.setText("¡Juego iniciado!\n" + juego.getEstadoPalabra());
        campoLetra.setEnabled(true);
        botonProbarLetra.setEnabled(true);
    }

    private void actualizarEstado(JuegoAhorcadoBase juego) {
        areaJuego.setText("Intentos restantes: " + juego.getIntentos() + "\n" + juego.getEstadoPalabra());
        if (juego.hasGanado()) {
            areaJuego.append("\n¡Felicidades! Has ganado.");
            campoLetra.setEnabled(false);
            botonProbarLetra.setEnabled(false);
        } else if (juego.getIntentos() <= 0) {
            areaJuego.append("\nHas perdido. La palabra era: " + juego.getPalabraSecreta());
            campoLetra.setEnabled(false);
            botonProbarLetra.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            abstract ventana = new abstract();
            ventana.setVisible(true);
        });
    }
}
