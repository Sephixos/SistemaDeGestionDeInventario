package modelo.patrones.prototype;
import modelo.Producto;

/**
Autores: 
Grupo 5: Edgar Bonilla, Javier Norberto Vargas Clavijo, Ronald Stiven Cardenas Aguilar

Interfaz "Prototype" del patrón de diseño Prototype.
Define un método para que los objetos puedan clonarse a si mismos.
La Clase Producto implementa el metodo clonar() de esta interface para hacer la clonación
*/

public interface PrototipoProducto {
     /**
     * Crea y devuelve una copia de este objeto.
     * @return un clon del objeto actual.
     */
    Producto clonar(); 
}
