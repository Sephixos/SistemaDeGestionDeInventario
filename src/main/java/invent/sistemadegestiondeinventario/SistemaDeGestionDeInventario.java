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
    
    // Crea el objeto scanner para recibir los datos del teclado
    private static final Scanner scanner = new Scanner(System.in);    
    
    public static void main(String[] args) {
        int opcion = 0;
        // Bucle principal del menú de la aplicación.
        while (opcion != 6) {
            mostrarMenuPrincipal();
            try {
                // Variable que guarda la opciónn digitada por el usuario
                opcion = scanner.nextInt();
                scanner.nextLine();

                // Selector de opciones del menú.
                switch (opcion) {
                    case 1:
                        crearCategoria();
                        break;
                    case 2:
                        crearProducto();
                        break;
                    case 3:
                        clonarProducto();
                        break;
                    case 4:
                        consultarInventario();
                        break;
                    case 5:
                        gestionarInventario();
                        break;
                    case 6:
                        System.out.println("Saliendo de la aplicacion...");
                        break;
                    default:
                        System.out.println("Opcion no valida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un numero. Intente de nuevo.");
                scanner.nextLine(); 
                opcion = 0; 
            }
        }
        scanner.close();
    }

    /**
     * Muestra el menú principal de opciones de la aplicación al usuario.
     */
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Sistema de Gestion de Inventario ---");
        System.out.println("1. Crear Nueva Categoria");
        System.out.println("2. Crear Nuevo Producto");
        System.out.println("3. Clonar Producto Existente");
        System.out.println("4. Consultar Inventario");
        System.out.println("5. Gestionar Inventario (Anadir/Restar Stock)");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    /**
    Lógica para la creaciónn de una nueva Categorí­a.
    */
    private static void crearCategoria() {
        System.out.println("\n--- Creacion de Nueva Categoria ---");
        System.out.print("Ingrese el nombre de la categoria: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripcion de la categoria: ");
        String descripcion = scanner.nextLine();
        System.out.print("Ingrese atributos especificos separados por comas (ej: Talla,Color,Material): ");
        String atributosStr = scanner.nextLine();
        
        // Se crea la categorí­a y se añade al inventario.
        // Crea una lista inmutable con los atributos de la Categorí­a
        Categoria nuevaCategoria = new Categoria(nombre, descripcion, List.of(atributosStr.split(",")));
        // Agrega la Categorí­a al inventario
        inventario.agregarCategoria(nuevaCategoria);
        System.out.println("Categoria '" + nombre + "' creada exitosamente!");
    }

    /**
    2. PATRÓN BUILDER
    Lógica para la creación de un nuevo producto utilizando el patrón Builder.
    */
    private static void crearProducto() {
        System.out.println("\n--- Crear Nuevo Producto ---");
        List<Categoria> categorias = inventario.obtenerCategorias();
        if (categorias.isEmpty()) {
            System.out.println("No hay categorias disponibles. Por favor, cree una categoria primero.");
            return;
        }

        // Pide seleccionar la categorí­a para el nuevo producto.
        System.out.println("Seleccione una categoria para el producto:");
        // Trae el listado de categorÃ­as
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println((i + 1) + ". " + categorias.get(i).getNombre());
        }
        // Solicita seleccionar una categorí­a
        System.out.print("Opcion: ");
        int catOpcion = scanner.nextInt();
        scanner.nextLine();
        Categoria categoriaSeleccionada = categorias.get(catOpcion - 1);

        // Se solicitan los datos básicos del producto.
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad inicial en inventario: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        /* PATRÓN BUILDER         
        Se utiliza el patrón Builder para construir el objeto Producto.
        Esto facilita la creación del objeto paso a paso.
        */
        
        ProductoBuilder builder = new ProductoConcretoBuilder();
        Director director = new Director(builder);
    
     // Usar el Director para crear el producto
        director.crearProducto(nombre, precio, cantidad, categoriaSeleccionada, scanner, inventario);        
        
    }
    
    /**
    3. PATRÓN PROTOTYPE
    Lógica para clonar un producto existente, utlizando el patrón Prototype.
    */
    private static void clonarProducto() {
        System.out.println("\n--- Clonar (Copiar) Producto Existente ---");
        System.out.print("Ingrese el nombre del producto que desea clonar: ");
        String nombreOriginal = scanner.nextLine();
        
        // Busca el producto que se quiere clonar
        Producto productoOriginal = inventario.buscarProductoPorNombre(nombreOriginal);

        // Si no existe devuelve un mensaje
        if (productoOriginal == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        // Si el producto existe, lo clona
        System.out.println("Producto encontrado. Ingrese los nuevos datos para el clon.");
        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        System.out.print("Nuevo precio: ");
        double nuevoPrecio = scanner.nextDouble();
        System.out.print("Nueva cantidad en inventario: ");
        int nuevaCantidad = scanner.nextInt();
        scanner.nextLine();

        // Se utiliza el método clonar() del patrón Prototype.
        Producto productoClonado = productoOriginal.clonar();
        
        // Se actualizan los datos del clon con la nueva informaciÃ³n.
        productoClonado.setNombre(nuevoNombre);
        productoClonado.setPrecio(nuevoPrecio);
        productoClonado.setCantidadEnInventario(nuevaCantidad);
        
        // Añade el producto clonado al inventario
        inventario.agregarProducto(productoClonado);
        System.out.println("Producto '" + nuevoNombre + "' copiado (clonado) exitosamente a partir de '" + nombreOriginal + "'!");
    }

    /**
     * Muestra el estado actual de todos los productos en el inventario.
     */
    private static void consultarInventario() {
        System.out.println("\n--- Estado Actual del Inventario ---");
        inventario.mostrarInventario();
    }

    /**
     * Permite al usuario añadir o restar stock de un producto especí­fico.
     */
    private static void gestionarInventario() {
        System.out.println("\n--- Gestionar Stock de Producto ---");
        System.out.print("Ingrese el nombre del producto a gestionar: ");
        String nombre = scanner.nextLine();
        
        Producto producto = inventario.buscarProductoPorNombre(nombre);
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        
        System.out.print("Ingrese la cantidad a anadir (positivo) o restar (negativo): ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();
        
        producto.setCantidadEnInventario(producto.getCantidadEnInventario() + cantidad);
        
        System.out.println("Stock actualizado. Nueva cantidad para '" + nombre + "': " + producto.getCantidadEnInventario());
    }
}
