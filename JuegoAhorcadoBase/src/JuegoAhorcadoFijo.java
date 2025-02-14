/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author chung
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadosBase{
    public JuegoAhorcadoFijo(String palabraSecreta){
    this.palabraSecreta = palabraSecreta;
    }
    
    @Override
    public void jugar() {
        
        
    }

    @Override
    protected void actualizarPalabraActual(char letra) {
            String letraString = Character.toString(letra);
            for(int i=0; i<palabraSecreta.length(); i ++){
            if(verificarLetra){
            palabraSecreta.charAt(i)= letraString;
            }
        }
    }

    @Override
    protected boolean verificarLetra(char letra) {
        String letraString = Character.toString(letra);
        for(int i=0; i<palabraSecreta.length();i++){
            if(letraString.equals(palabraSecreta.charAt(i))){
            return true;
            }
        }
        return false;
    }

    @Override
    protected boolean hasGanado() {
        if (palabraActual.equals(palabraSecreta)){
        return true;
        }
        return false;
    }
    
}
