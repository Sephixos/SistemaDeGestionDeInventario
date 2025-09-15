package invent.sistemadegestiondeinventario;
import java.util.*;
import modelo.Categoria;
import modelo.Producto;
import modelo.patrones.builder.ProductoBuilder;
import modelo.patrones.builder.ProductoConcretoBuilder;
import modelo.patrones.singleton.Inventario;
import modelo.patrones.builder.Director;

/**
Autores: 
Grupo 5: Edgar Bonilla, Javier Norberto Vargas Clavijo, Ronald Stiven Cardenas Aguilar

Clase principal que actúa como punto de entrada de la aplicación y gestiona la
interacción con el usuario a través de un menú de consola.
*/
public class SistemaDeGestionDeInventario {
 
    // 1. PATRÓN SINGLETON
    // Se obtiene la instancia Única del inventario utilizando el patrón Singleton.
    // Todas las operaciones de la aplicación se realizarán sobre esta Única instancia.
    private static final Inventario inventario = Inventario.getInstance();
    
    public static void main(String[] args) {

        System.out.println("Hola mundo!");
        System.out.println("Hola mundo_javier!");

    }
}
