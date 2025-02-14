/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chung
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private AdminPalabrasSecretas admin;
    private JuegoAhorcadoBase juegoFijo;
    private JuegoAhorcadoBase juegoAzar = new JuegoAhorcadoAzar();
    private JTextArea areaJuego;
    private JTextField campoLetra;
    private JButton botonProbarLetra;
    private JuegoAhorcadoBase juego;

    public GUI() {
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

        botonFijo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = JOptionPane.showInputDialog(null, "Ingrese una palabra para el juego:", "Palabra Fija", JOptionPane.PLAIN_MESSAGE);
                
                if (palabra != null && !palabra.trim().isEmpty()) {
                    juegoFijo = new JuegoAhorcadoFijo(palabra);
                    iniciarJuego(juegoFijo);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese una palabra válida.");
                }
            }
        });

        botonAzar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = admin.seleccionarPalabraAzar();
                juego = new JuegoAhorcadoAzar();
                iniciarJuego(juego);
            }
        });

        botonProbarLetra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String letra = campoLetra.getText().toLowerCase();
                if (letra.length() == 1) {
                    if (juego != null) {
                        juego.jugar();
                        actualizarEstado(juego);
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
        this.juego = juego;
        areaJuego.setText("¡Juego iniciado!\n" + juego.palabraActual);
        campoLetra.setEnabled(true);
        botonProbarLetra.setEnabled(true);
    }

    private void actualizarEstado(JuegoAhorcadoBase juego) {
        areaJuego.setText("Intentos restantes: " + juego.intentos + "\n" + juego.palabraActual);
        if (juego.hasGanado()) {
            areaJuego.append("\n¡Felicidades! Has ganado.");
            campoLetra.setEnabled(false);
            botonProbarLetra.setEnabled(false);
        } else if (juego.intentos <= 0) {
            areaJuego.append("\nHas perdido. La palabra era: " + juego.palabraSecreta);
            campoLetra.setEnabled(false);
            botonProbarLetra.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI ventana = new GUI();
            ventana.setVisible(true);
        });
    }
}