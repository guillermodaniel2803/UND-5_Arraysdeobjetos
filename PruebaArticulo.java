package TEMA5.arrays_de_objetos;


class Articulo {
    // Atributos privados
    private String codigo;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int stock;

    // Constructor
    public Articulo(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioCompra = 0.0;
        this.precioVenta = 0.0;
        this.stock = 0;
    }

    // Métodos get y set
    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

public class Artic {
    public static void main(String[] args) {
        // Crear tres artículos
        Articulo articulo1 = new Articulo("A001", "Monitor Dell 24''");
        articulo1.setPrecioCompra(150.00);
        articulo1.setPrecioVenta(200.00);
        articulo1.setStock(10);
        
        Articulo articulo2 = new Articulo("A002", "Mouse inalámbrico Logitech");
        articulo2.setPrecioCompra(20.00);
        articulo2.setPrecioVenta(35.00);
        articulo2.setStock(50);
        
        Articulo articulo3 = new Articulo("A003", "Teclado mecánico Redragon");
        articulo3.setPrecioCompra(50.00);
        articulo3.setPrecioVenta(80.00);
        articulo3.setStock(30);
        
        // Almacenar en un array
        Articulo[] arrayArticulos = {articulo1, articulo2, articulo3};
        
        // Mostrar información de los artículos
        for (Articulo articulo : arrayArticulos) {
            System.out.println("Código: " + articulo.getCodigo() + ", Descripción: " + articulo.getDescripcion() +
                               ", Precio de compra: " + articulo.getPrecioCompra() + ", Precio de venta: " + articulo.getPrecioVenta() +
                               ", Stock: " + articulo.getStock());
        }

        // Almacenar en otro array usando el constructor directamente
        Articulo[] nuevoArrayArticulos = new Articulo[3];
        nuevoArrayArticulos[0] = new Articulo("T001", "Teclado Logitech K860");
        nuevoArrayArticulos[1] = new Articulo("M002", "Mouse Razer DeathAdder");
        nuevoArrayArticulos[2] = new Articulo("M003", "Monitor Samsung Curvo 27''");
        
        // Mostrar información del nuevo array
        for (Articulo articulo : nuevoArrayArticulos) {
            System.out.println("Código: " + articulo.getCodigo() + ", Descripción: " + articulo.getDescripcion());
        }
    }
}
