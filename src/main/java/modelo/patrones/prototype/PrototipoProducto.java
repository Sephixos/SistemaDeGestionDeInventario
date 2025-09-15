package modelo.patrones.prototype;
import modelo.Producto;

/**
Autores: 
Grupo 5: Edgar Bonilla, Javier Norberto Vargas Clavijo, Ronald Stiven Cardenas Aguilar

Interfaz "Prototype" del patr�n de dise�oo Prototype.
Define un m�todo para que los objetos puedan clonarse a s� mismos.
La Clase Producto implementa el metodo clonar() de esta interface para hacer la clonaci�n
*/

public interface PrototipoProducto {
     /**
     * Crea y devuelve una copia de este objeto.
     * @return un clon del objeto actual.
     */
    Producto clonar(); 
}
