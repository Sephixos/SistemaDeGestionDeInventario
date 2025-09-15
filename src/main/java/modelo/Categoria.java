
package modelo;
import java.util.*;
/**
Autores: 
Grupo 5: Edgar Bonilla, Javier Norberto Vargas Clavijo, Ronald Stiven Cardenas Aguilar
 
Clase que representa una categor�a de productos.
Contiene informaci�n general y los atributos espec�ficos que los productos
de esta categor�a deben tener.
*/

public class Categoria {
     private String nombre;
    private String descripcion;
    // Lista de nombres de atributos, ej: "Talla", "Color", "Voltaje".
    private List<String> atributosEspecificos;

    public Categoria(String nombre, String descripcion, List<String> atributosEspecificos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.atributosEspecificos = atributosEspecificos;
    }

    // Getters para acceder a las propiedades de la categor�a.
    public String getNombre() {
        return nombre;
    }
    // Obtiene la descripci�n de la categor�a
    public String getDescripcion() {
        return descripcion;
    }
    // Obtiene los atributos
    public List<String> getAtributosEspecificos() {
        return atributosEspecificos;
    }
    // Sobreescribe el m�todo toString()
    @Override
    public String toString() {
        return "Categoria [nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }
}
