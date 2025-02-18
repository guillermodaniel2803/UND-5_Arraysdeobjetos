package TEMA5.arrays_de_objetos;

import java.util.ArrayList;
import java.util.List;

// Clase Autor
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

// Clase Biblioteca para controlar los autores y libros
class Biblioteca {
    private List<Libro> libros;
    private List<Autor> autores;

    public Biblioteca() {
        libros = new ArrayList<>();
        autores = new ArrayList<>();
    }

    public void agregarAutor(Autor autor) {
        autores.add(autor);
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public int contarLibros() {
        return libros.size();
    }

    public int contarAutores() {
        return autores.size();
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
}

// Clase principal para probar el programa
public class BibliotecaMain {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Crear autores
        Autor autor1 = new Autor("J.K. Rowling", "Británica");
        Autor autor2 = new Autor("Stephen King", "Estadounidense");
        Autor autor3 = new Autor("Haruki Murakami", "Japonesa");

        // Agregar autores a la biblioteca
        biblioteca.agregarAutor(autor1);
        biblioteca.agregarAutor(autor2);
        biblioteca.agregarAutor(autor3);

        // Crear libros
        Libro libro1 = new Libro("001", "Harry Potter y la Piedra Filosofal", autor1);
        Libro libro2 = new Libro("002", "Harry Potter y la Cámara Secreta", autor1);
        Libro libro3 = new Libro("003", "It", autor2);
        Libro libro4 = new Libro("004", "El Resplandor", autor2);
        Libro libro5 = new Libro("005", "Kafka en la Orilla", autor3);
        Libro libro6 = new Libro("006", "1Q84", autor3);

        // Agregar libros a la biblioteca
        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarLibro(libro3);
        biblioteca.agregarLibro(libro4);
        biblioteca.agregarLibro(libro5);
        biblioteca.agregarLibro(libro6);

        // Mostrar los datos de la biblioteca
        System.out.println("Número total de autores: " + biblioteca.contarAutores());
        biblioteca.mostrarAutores();

        System.out.println("\nNúmero total de libros: " + biblioteca.contarLibros());
        biblioteca.mostrarLibros();
    }
}
