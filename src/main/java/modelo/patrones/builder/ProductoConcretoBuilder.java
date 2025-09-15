package modelo.patrones.builder;
import modelo.Categoria;
import modelo.Producto;


/**
Autores: 
Grupo 5: Edgar Bonilla, Javier Norberto Vargas Clavijo, Ronald Stiven Cardenas Aguilar

Clase "ConcreteBuilder" del patrón de diseño Builder.
Implementa la interfaz ProductoBuilder para construir un objeto Producto.
*/

public class ProductoConcretoBuilder implements ProductoBuilder {
private Producto producto;

    // Al iniciar, se crea una instancia vacía del producto que se va a construir.
    public ProductoConcretoBuilder() {
        this.producto = new Producto();
    }

    @Override
    public ProductoBuilder conNombre(String nombre) {
        producto.setNombre(nombre);
        return this; // Devuelve la propia instancia para permitir el encadenamiento de métodos.
    }
    // Sobreescribe el método conPrecio con su implementación
    @Override
    public ProductoBuilder conPrecio(double precio) {
        producto.setPrecio(precio);
        return this;
    }
    // Sobreescribe el método conCantidadEnInventario con su implementación
    @Override
    public ProductoBuilder conCantidadEnInventario(int cantidad) {
        producto.setCantidadEnInventario(cantidad);
        return this;
    }
    // Sobreescribe el método paraCategoria con su implementación
    @Override
    public ProductoBuilder paraCategoria(Categoria categoria) {
        producto.setCategoria(categoria);
        return this;
    }
    // Sobreescribe el método conAtributo con su implementación
    @Override
    public ProductoBuilder conAtributo(String nombreAtributo, String valorAtributo) {
        producto.setValorAtributo(nombreAtributo, valorAtributo);
        return this;
    }

    /**
    Finaliza la construcción y devuelve el objeto Producto completo.
    Devuelve el objeto Producto construido.
    */
    @Override
    public Producto construir() {
        return this.producto;
    }    
}
