package modelo;

import java.util.*;
import modelo.patrones.prototype.PrototipoProducto;

/**
Autores: 
Grupo 5: Edgar Bonilla, Javier Norberto Vargas Clavijo, Ronald Stiven Cardenas Aguilar

Clase que representa un producto.
Es el "ConcretePrototype" en el patrón Prototype y el "Product" en el patrón Builder.
 */



public class Producto  implements PrototipoProducto{
    private String nombre;
    private double precio;
    private int cantidadEnInventario;
    private Categoria categoria;
    // Mapa para almacenar los valores de los atributos especí­ficos, ej: ("Talla", "M").
    private Map<String, String> valoresAtributos;

    // Constructor por defecto, usado por el Builder.
    public Producto() {
        this.valoresAtributos = new HashMap<>();
    }

    // Getters y Setters para las propiedades del producto.
    public String getNombre() {
        return nombre;
    }
    // Guarda el Nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // Obtiene el precio
    public double getPrecio() {
        return precio;
    }
    // Guarda el precio
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    // Obtiene la cantidad en inventario
    public int getCantidadEnInventario() {
        return cantidadEnInventario;
    }
    // Guarda la Cantidad en inventario
    public void setCantidadEnInventario(int cantidadEnInventario) {
        this.cantidadEnInventario = cantidadEnInventario;
    }
    // Obtiene la categorí­a
    public Categoria getCategoria() {
        return categoria;
    }
    // Guarda la categorí­a
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    // Obtiene los valores de los Atributos
    public Map<String, String> getValoresAtributos() {
        return valoresAtributos;
    }
    // Guarda los valores de los atributos
    public void setValoresAtributos(Map<String, String> valoresAtributos) {
        this.valoresAtributos = valoresAtributos;
    }
    // Guarda el valor de un atributo
    public void setValorAtributo(String atributo, String valor) {
        this.valoresAtributos.put(atributo, valor);
    }

    /**
    Implementación del método clonar del patrón Prototype.
    Crea una copia del producto actual.
    Devuelve un nuevo objeto Producto con los mismos datos que el original.
    */
    @Override
    public Producto clonar() {
        Producto clon = new Producto();
        clon.setNombre(this.nombre);
        clon.setPrecio(this.precio);
        clon.setCantidadEnInventario(this.cantidadEnInventario);
        clon.setCategoria(this.categoria); // La categorí­a se comparte (copia superficial)
        // Se crea un nuevo HashMap para asegurar que el clon tenga su propio mapa de atributos.
        clon.setValoresAtributos(new HashMap<>(this.valoresAtributos));
        return clon;
    }

    @Override
    public String toString() {
        return "Producto [nombre=" + nombre + ", precio=" + precio + ", stock=" + cantidadEnInventario
                + ", categoria=" + categoria.getNombre() + ", atributos=" + valoresAtributos + "]";
    }    
}
