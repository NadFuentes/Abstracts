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

    public abstract void inicializarPalabraSecreta();
    public abstract void jugar();
    protected abstract void actualizarPalabraActual(char letra);
    protected abstract boolean verificarLetra(char letra);
    protected abstract boolean hasGanado();
    
    public static class JuegoAhorcadoConcreto extends JuegoAhorcadoBase{
         public void inicializarPalabraSecreta(){
             Scanner scanner = new Scanner(System.in);
             System.out.print("JUgador 1, ingresa la palabra secreta: ");
             this.palabraSecreta = scanner.nextLine().toUpperCase();
             this.palabraActual = new StringBuilder("_".repeat(palabraSecreta.length()));
             
             System.out.print("\\033[H\\033[2J");
             System.out.flush();
         }
         
         public void jugar(){
             Scanner scanner = new Scanner(System.in);
             
              while (intentos > 0 && !hasGanado()) {
                System.out.println("Palabra: " + palabraActual);
                System.out.print("Jugador 2, ingresa una letra: ");
                char letra = scanner.next().toUpperCase().charAt(0);

                if (verificarLetra(letra)) {
                    actualizarPalabraActual(letra);
                } else {
                    intentos--;
                    System.out.println("Letra incorrecta. Intentos restantes: " + intentos);
                }
            }
              if (hasGanado()) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
            } else {
                System.out.println("Game Over. La palabra era: " + palabraSecreta);
            }

            scanner.close();
         }
         
          protected void actualizarPalabraActual(char letra) {
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letra) {
                    palabraActual.setCharAt(i, letra);
                }
            }
        }
          
           protected boolean verificarLetra(char letra) {
            return palabraSecreta.indexOf(letra) != -1;
        }
           
         protected boolean hasGanado() {
            return palabraActual.toString().equals(palabraSecreta);
        }
          
    }
}

