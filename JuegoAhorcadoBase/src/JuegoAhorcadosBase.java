/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nadiesda Fuentes
 */
abstract class JuegoAhorcadosBase implements JuegoAhorcado{
    protected String palabraSecreta;
    protected StringBuilder palabraActual;
    protected int intentos;
    
    public JuegoAhorcadosBase(){
        this.intentos = 5;
        this.palabraActual = new StringBuilder();
    }
    
    public void inicializarPalabraSecreta(){
        AdminPalabrasSecretas admi = new AdminPalabrasSecretas();
        this.palabraSecreta = admi.seleccionarPalabraAzar();
        this.palabraActual = new StringBuilder("_".repeat(palabraSecreta.length()));
    }
    
  
    
    public abstract void jugar();

    // Método abstracto para actualizar la palabra actual
    protected void actualizarPalabraActual(char letra){
    for(int i= 0; i < palabraSecreta.length(); i++){
    if (palabraSecreta.charAt(i)== letra){
        palabraActual.setCharAt(i, letra);
   }
  }
}
    
    

    // Método abstracto para verificar si la letra está en la palabra secreta
    protected abstract boolean verificarLetra(char letra);

    // Método abstracto para verificar si el jugador ha ganado
    protected boolean hasGanado(){
      return palabraActual.indexOf("_")== -1;
}}
