/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nadiesda Fuentes
 */
public abstract class JuegoAhorcadosBase implements JuegoAhorcados{
    protected String palabraSecreta;
    protected StringBuilder palabraActual;
    protected int intentos;
    
    public JuegoAhorcadosBase(){
        this.intentos = 5;
        this.palabraActual = new StringBuilder();
    }
    
    public abstract void inicializarPalabraSecreta();
    
    public abstract void jugar();

    // Método abstracto para actualizar la palabra actual
    protected abstract void actualizarPalabraActual(char letra);

    // Método abstracto para verificar si la letra está en la palabra secreta
    protected abstract boolean verificarLetra(char letra);

    // Método abstracto para verificar si el jugador ha ganado
    protected abstract boolean hasGanado();    
}