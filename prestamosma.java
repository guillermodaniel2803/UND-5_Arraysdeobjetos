package TEMA5.arrays_de_objetos;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
class Autor {
    private String nombre;
    private String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor: " + nombre + ", Nacionalidad: " + nacionalidad;
    }
}

// Clase Libro
class Libro {
    private String codigo;
    private String titulo;
    private Autor autor;

    public Libro(String codigo, String titulo, Autor autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Libro: [Código: " + codigo + ", Título: " + titulo + ", " + autor + "]";
    }
}

// Clase Prestamo
class Prestamo {
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Libro libro;
    private String cliente;
    private static int totalPrestamos = 0;

    public Prestamo(Date fechaPrestamo, Date fechaDevolucion, Libro libro, String cliente) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.cliente = cliente;
        totalPrestamos++;
    }

    public static int getTotalPrestamos() {
        return totalPrestamos;
    }

    @Override
    public String toString() {
        return "Préstamo: [Fecha de Préstamo: " + fechaPrestamo + ", Fecha de Devolución: " + fechaDevolucion + ", Libro: " + libro.getTitulo() + ", Cliente: " + cliente + "]";
    }
}

// Clase Biblioteca para controlar los autores y libros
class Biblioteca {
    private List<Libro> libros;
    private List<Autor> autores;
    private List<Prestamo> prestamos;

    public Biblioteca() {
        libros = new ArrayList<>();
        autores = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public void agregarAutor(Autor autor) {
        autores.add(autor);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void realizarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    public int contarLibros() {
        return libros.size();
    }

    public int contarAutores() {
        return autores.size();
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void mostrarAutores() {
        System.out.println("Lista de Autores:");
        for (Autor autor : autores) {
            System.out.println(autor);
        }
    }

    public void mostrarLibros() {
        System.out.println("Lista de Libros:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    public void mostrarPrestamos() {
        System.out.println("Lista de Préstamos:");
        for (Prestamo prestamo : prestamos) {
            System.out.println(prestamo);
        }
    }
}

// Clase principal para probar el programa
public class prestamosma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        System.out.print("Ingrese el número de autores a agregar: ");
        int numAutores = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numAutores; i++) {
            System.out.print("Ingrese el nombre del autor: ");
            String nombreAutor = scanner.nextLine();
            System.out.print("Ingrese la nacionalidad del autor: ");
            String nacionalidadAutor = scanner.nextLine();
            Autor autor = new Autor(nombreAutor, nacionalidadAutor);
            biblioteca.agregarAutor(autor);
        }

        System.out.print("Ingrese el número de libros a agregar: ");
        int numLibros = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numLibros; i++) {
            System.out.print("Ingrese el código del libro: ");
            String codigoLibro = scanner.nextLine();
            System.out.print("Ingrese el título del libro: ");
            String tituloLibro = scanner.nextLine();
            System.out.print("Ingrese el nombre del autor del libro: ");
            String nombreAutor = scanner.nextLine();
            Autor autor = biblioteca.getAutores().stream().filter(a -> a.getNombre().equals(nombreAutor)).findFirst().orElse(null);
            if (autor == null) {
                System.out.println("Autor no encontrado. Agregue el autor primero.");
                i--;
                continue;
            }
            Libro libro = new Libro(codigoLibro, tituloLibro, autor);
            biblioteca.agregarLibro(libro);
        }

        System.out.print("Ingrese el número de préstamos a realizar: ");
        int numPrestamos = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numPrestamos; i++) {
            System.out.print("Ingrese el código del libro a prestar: ");
            String codigoLibro = scanner.nextLine();
            Libro libro = biblioteca.getLibros().stream().filter(l -> l.getCodigo().equals(codigoLibro)).findFirst().orElse(null);
            if (libro == null) {
                System.out.println("Libro no encontrado. Agregue el libro primero.");
                i--;
                continue;
            }
            System.out.print("Ingrese el nombre del cliente: ");
            String cliente = scanner.nextLine();
            Date fechaPrestamo = new Date();
            Date fechaDevolucion = new Date(System.currentTimeMillis() + 7L * 24 * 60 * 60 * 1000);
            Prestamo prestamo = new Prestamo(fechaPrestamo, fechaDevolucion, libro, cliente);
            biblioteca.realizarPrestamo(prestamo);
        }

        // Mostrar los datos de la biblioteca
        System.out.println("\nNúmero total de autores: " + biblioteca.contarAutores());
        biblioteca.mostrarAutores();

        System.out.println("\nNúmero total de libros: " + biblioteca.contarLibros());
        biblioteca.mostrarLibros();

        System.out.println("\nNúmero total de préstamos: " + Prestamo.getTotalPrestamos());
        biblioteca.mostrarPrestamos();

        scanner.close();
    }
}