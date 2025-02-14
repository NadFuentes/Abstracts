/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nadiesda Fuentes
 */
import java.util.Scanner;

public abstract class JuegoAhorcadoBase implements JuegoAhorcado { 
    protected String palabraSecreta;
    protected StringBuilder palabraActual;
    protected int intentos;

    public JuegoAhorcadoBase() {
        this.intentos = 6; 
        this.palabraActual = new StringBuilder(); 
    }

    // Método para inicializar la palabra secreta
   
    public abstract void inicializarPalabraSecreta();

    // Método para jugar (se implementará en la clase concreta)

    public abstract void jugar();

    // Método abstracto para actualizar la palabra actual
    protected abstract void actualizarPalabraActual(char letra);

    // Método abstracto para verificar si la letra está en la palabra secreta
    protected abstract boolean verificarLetra(char letra);

    // Método abstracto para verificar si el jugador ha ganado
    protected abstract boolean hasGanado();
}
