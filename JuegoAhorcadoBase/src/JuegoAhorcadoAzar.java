
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chung
 */
public class JuegoAhorcadoAzar extends JuegoAhorcadoBase{
    String palabrasPosibles[] = {"perro", "gato", "caminadora", "ingenieria", "sistemas", "abstracto"};
    Random random = new Random();
    
    

    @Override
    public void inicializarPalabraSecreta() {
    palabraSecreta = palabrasPosibles[random.nextInt(palabrasPosibles.length)];
    palabraActual = new StringBuilder("_".repeat(palabraSecreta.length())); 
    intentos = 6; 
    }

    public void jugar() {
      
    }


    @Override
    protected void actualizarPalabraActual(char letra) {
        for(int i=0; i<palabraSecreta.length(); i ++){
            if(verificarLetra(letra) && palabraSecreta.charAt(i)== letra){
            palabraActual.setCharAt(i, letra);
                
            }
        }    }

    @Override
    protected boolean verificarLetra(char letra) {
    for(int i=0; i<palabraSecreta.length();i++){
            if(letra == palabraSecreta.charAt(i)){
            return true;
            }
        }
        return false;    }

    @Override
    protected boolean hasGanado() {
    if (palabraActual.toString().equals(palabraSecreta)){
        return true;
        }
        return false;    }
    
}
