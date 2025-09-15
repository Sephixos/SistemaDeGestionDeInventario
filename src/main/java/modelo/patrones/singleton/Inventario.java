package modelo.patrones.singleton;

import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import modelo.Producto;

/**
Autores: 
Grupo 5: Edgar Bonilla, Javier Norberto Vargas Clavijo, Ronald Stiven Cardenas Aguilar

Clase que gestiona el inventario. Implementa el patrón Singleton para
asegurar que solo exista una instancia de inventario en toda la aplicación.
*/

public class Inventario {
    // 1. Variable estática privada para almacenar la Única instancia.
    private static Inventario instancia;

    private List<Categoria> categorias;
    private List<Producto> productos;

    // 2. Constructor privado para evitar la instanciación directa.
    private Inventario() {
        categorias = new ArrayList<>();
        productos = new ArrayList<>();
    }

    /**
    3. Método público estático para obtener la instancia Única.
    La Única instancia de la clase Inventario.
    */
    public static Inventario getInstance() {
        if (instancia == null) {
            instancia = new Inventario();
        }
        return instancia;
    }

    // Métodos para gestionar el inventario.
    // Agrega una Categorí­a
    public void agregarCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }
    // Agrega un Producto
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }
    // Trae las Categorías
    public List<Categoria> obtenerCategorias() {
        return this.categorias;
    }
    // Trae los Productos
    public List<Producto> obtenerProductos() {
        return this.productos;
    }

    /**
    Busca el producto en el inventario por su nombre
    Devuelve el nombre El nombre del producto a buscar.
    Devuelve el objeto Producto si se encuentra, de lo contrario null.
    */
    public Producto buscarProductoPorNombre(String nombre) {
        // Ciclo for-each que recorre la lista de productos
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    /**
     * Muestra por consola todos los productos del inventario y sus detalles.
     */
    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("El inventario esta vacio.");
        } else {
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }    
}
