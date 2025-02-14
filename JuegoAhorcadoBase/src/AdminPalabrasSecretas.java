/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jocsan
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdminPalabrasSecretas {
    private List<String> palabrasSecretas;

    public AdminPalabrasSecretas() {
        palabrasSecretas = new ArrayList<>();
    }
  
    //hola
    public void agregarPalabra(String palabra) {
        palabrasSecretas.add(palabra.toLowerCase());
    }

    public String seleccionarPalabraAzar() {
        if (palabrasSecretas.isEmpty()) {
            throw new IllegalStateException("No hay palabras disponibles.");
        }
        Random random = new Random();
        int indice = random.nextInt(palabrasSecretas.size());
        return palabrasSecretas.get(indice);
    }
}
