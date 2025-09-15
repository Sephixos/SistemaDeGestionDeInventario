package modelo.patrones.builder;
import modelo.Categoria;
import modelo.Producto;


/**
Autores: 
Grupo 5: Edgar Bonilla, Javier Norberto Vargas Clavijo, Ronald Stiven Cardenas Aguilar
 
Interfaz "Builder" del patrón de diseño Builder.
Define los pasos necesarios para construir un objeto Producto.
*/

public interface ProductoBuilder {
    ProductoBuilder conNombre(String nombre);
    ProductoBuilder conPrecio(double precio);
    ProductoBuilder conCantidadEnInventario(int cantidad);
    ProductoBuilder paraCategoria(Categoria categoria);
    ProductoBuilder conAtributo(String nombreAtributo, String valorAtributo);
    Producto construir(); 
}
