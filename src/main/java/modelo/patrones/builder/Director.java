
package modelo.patrones.builder;

import java.util.*;
import modelo.Categoria;
import modelo.Producto;
import modelo.patrones.singleton.Inventario;


/**
Autores: 
Grupo 5: Edgar Bonilla, Javier Norberto Vargas Clavijo, Ronald Stiven Cardenas Aguilar

Clase Directora que construye el objeto
*/
public class Director {
      private ProductoBuilder builder;

    public Director(ProductoBuilder builder) {
        this.builder = builder;
    }

    public void crearProducto(String nombre, double precio, int cantidad, Categoria categoriaSeleccionada, Scanner scanner, Inventario inventario) {
        // Paso 1: Configura el Producto
       builder.conNombre(nombre)
              .conPrecio(precio)
              .conCantidadEnInventario(cantidad)
              .paraCategoria(categoriaSeleccionada);

       // Paso 2: Solicita los atributos específicos de la categoría
       for (String atributo : categoriaSeleccionada.getAtributosEspecificos()) {
           System.out.print("Ingrese el valor para '" + atributo.trim() + "': ");
           String valor = scanner.nextLine();
           builder.conAtributo(atributo.trim(), valor);
       }

       // Paso 3: Construye el producto final
       Producto nuevoProducto = builder.construir();

       // Paso 4: Agrega el producto al inventario al inventario
       inventario.agregarProducto(nuevoProducto);
       System.out.println("Producto '" + nombre + "' creado exitosamente!");
    }
}
