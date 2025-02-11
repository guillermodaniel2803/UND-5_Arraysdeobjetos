package TEMA5.arrays_de_objetos;

import java.util.Scanner;

class Autobus {
    private String matricula;
    private String modelo;
    private int potenciaCV;
    private int numeroPlazas;

    public Autobus(String matricula, String modelo, int potenciaCV, int numeroPlazas) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.potenciaCV = potenciaCV;
        this.numeroPlazas = numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPotenciaCV() {
        return potenciaCV;
    }

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void mostrarDatos() {
        System.out.println("Matrícula: " + matricula);
        System.out.println("Modelo: " + modelo);
        System.out.println("Potencia: " + potenciaCV + " CV");
        System.out.println("Número de Plazas: " + numeroPlazas);
        System.out.println("----------------------------");
    }
}

public class autobuses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Autobus[] autobuses = new Autobus[4];
        
        // Introducir datos de los autobuses
        for (int i = 0; i < autobuses.length; i++) {
            System.out.println("Introduce los datos del autobús " + (i + 1) + ":");
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();
            System.out.print("Modelo: ");
            String modelo = scanner.nextLine();
            System.out.print("Potencia (CV): ");
            int potenciaCV = scanner.nextInt();
            System.out.print("Número de plazas: ");
            int numeroPlazas = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            autobuses[i] = new Autobus(matricula, modelo, potenciaCV, numeroPlazas);
        }
        
        // Mostrar datos de los autobuses
        System.out.println("\nInformación de los autobuses:");
        for (Autobus autobus : autobuses) {
            autobus.mostrarDatos();
        }

        scanner.close();
    }
}
    
