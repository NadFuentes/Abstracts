
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chung
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase{
    private final String palabraSecretaFija;
    
    public JuegoAhorcadoFijo(String palabraSecretaFija){
    this.palabraSecretaFija = palabraSecretaFija.toUpperCase();
    }
    
    @Override
    public void jugar() {
        
        
    }

    @Override
    protected void actualizarPalabraActual(char letra) {
            for(int i=0; i<palabraSecreta.length(); i ++){
            if(verificarLetra(letra) && palabraSecreta.charAt(i)== letra){
            palabraActual.setCharAt(i, letra);
                
            }
        }
    }

    @Override
    protected boolean verificarLetra(char letra) {
        for(int i=0; i<palabraSecreta.length();i++){
            if(letra == palabraSecreta.charAt(i)){
            return true;
            }
        }
        return false;
    }

    @Override
    protected boolean hasGanado() {
        if (palabraActual.toString().equals(palabraSecreta)){
        return true;
        }
        return false;
    }

    @Override
    public void inicializarPalabraSecreta() {
        this.palabraSecreta= palabraSecretaFija;
        this.palabraActual = new StringBuilder("_".repeat(palabraSecreta.length()));
        this.intentos= 6;
    }
    
}
