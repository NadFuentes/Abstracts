/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nadiesda Fuentes
 */
public interface JuegoAhorcado{
    void inicializarPalabraSecreta();
    void jugar();
}
public abstract class JuegoAhorcadosBase implements JuegoAhorcados{
    protected String palabraSecreta;
    protected StringBuilder palabraActual;
    protected int instentos;
    
    public JuegosAhorcadosBase(){
        this.intentos = 5;
    }
}
