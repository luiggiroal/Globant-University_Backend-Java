package Figuras_Geometricas_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner myScanner = new Scanner(System.in);
    static List<Rectangulo> rectangulos = new ArrayList<>();
    static List<Triangulo> triangulos = new ArrayList<>();
    static List<Circulo> circulos = new ArrayList<>();

    public static void main(String[] args) {
        menu();
        myScanner.close();
    }

    public static void menu()  {
        int option = 0;
        System.out.println("\nBienvenido!");
        do {
            System.out.print("""
                    
                    1.Crear Figura Geométrica.
                    2.Conocer datos de una Figura Geométrica.
                    3.Salir
                    
                    Ingrese una opción:""");
            try {
                option = Integer.parseInt(myScanner.nextLine());

                switch (option) {
                    case 1 -> crearFiguraGeometrica();
                    case 2 -> mostrarDatosFiguraGeometrica();
                    case 3 -> System.out.println("Adiós");
                    default -> System.out.println("Ingrese una opción válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido. Excepción atrapada.");
            }
        } while (option != 3);
    }

    public static void crearFiguraGeometrica() throws NumberFormatException {
        int option;
        do {
            System.out.print("""
                
                1.Crear nuevo Rectángulo
                2.Crear nuevo Triángulo
                3.Crear nuevo Círculo
                
                Ingrese una opción:""");
            option = Integer.parseInt(myScanner.nextLine());

            switch (option) {
                case 1 -> crearRectangulo(rectangulos);
                case 2 -> crearTriangulo(triangulos);
                case 3 -> crearCirculo(circulos);
                default -> System.out.println("Ingrese una opción valida");
            }

        } while (option != 1 && option != 2 && option != 3);
    }
    public static void crearRectangulo(List<Rectangulo> rectangulos) throws NumberFormatException {
        System.out.print("Ingrese el ancho: ");
        double ancho = Double.parseDouble(myScanner.nextLine());
        System.out.print("Ingrese el alto: ");
        double alto = Double.parseDouble(myScanner.nextLine());

        rectangulos.add(new Rectangulo(ancho, alto));
        System.out.printf("""
                
                Rectángulo de ancho %s y de alto %s creado.
                """, rectangulos.get(rectangulos.size() - 1).getAncho(), rectangulos.get(rectangulos.size() - 1).getAlto());
    }

    public static void crearTriangulo(List<Triangulo> triangulos) throws NumberFormatException {
        System.out.print("Ingrese la base: ");
        double base = Double.parseDouble(myScanner.nextLine());
        System.out.print("Ingrese la altura: ");
        double altura = Double.parseDouble(myScanner.nextLine());

        triangulos.add(new Triangulo(base, altura));

        System.out.printf("Triángulo con base %s y altura %s " +
                "creado.%n", triangulos.get(triangulos.size() - 1).getBase(), triangulos.get(triangulos.size() - 1).getAltura());
    }
    public static void crearCirculo(List<Circulo> circulos) throws NumberFormatException {
        System.out.print("Ingrese el radio: ");
        double radio = Double.parseDouble(myScanner.nextLine());

        circulos.add(new Circulo(radio));

        System.out.printf("Círculo con radio %s creado.%n", circulos.get(circulos.size() - 1).getRadio());
    }

    public static void mostrarDatosFiguraGeometrica() throws NumberFormatException {
        int option;
        do {
            System.out.print("""
                
                1.Mostrar datos de un Rectángulo
                2.Mostrar datos de un Triángulo
                3.Mostrar datos de un Círculo
                
                Elija una opción:""");
            option = Integer.parseInt(myScanner.nextLine());

            switch (option) {
                case 1 -> mostrarDatosRectangulo(rectangulos);
                case 2 -> mostrarDatosTriangulo(triangulos);
                case 3 -> mostrarDatosCirculo(circulos);
                default -> System.out.println("Ingrese una opción valida.");
            }
        } while (option != 1 && option != 2 && option != 3);
    }

    public static void mostrarDatosRectangulo(List<Rectangulo> rectangulos) throws NumberFormatException {
        int indice;
        do {
            System.out.print("Ingrese el índice del Rectángulo: ");
            indice = Integer.parseInt(myScanner.nextLine());

            if (indice >= 0 && indice < rectangulos.size()) {
                rectangulos.get(indice).imprimirDatos();
                break;
            }
            else
                System.out.println("Ingrese un índice válido.");
        } while (true);
    }

    public static void mostrarDatosTriangulo(List<Triangulo> triangulos) throws NumberFormatException {
        int indice;
        do {
            System.out.print("Ingrese el índice del Triángulo: ");
            indice = Integer.parseInt(myScanner.nextLine());

            if (indice >= 0 && indice < triangulos.size()) {
                triangulos.get(indice).imprimirDatos();
                break;
            }
            else
                System.out.println("Ingrese un índice válido");
        } while (true);
    }
    public static void mostrarDatosCirculo(List<Circulo> circulos) throws NumberFormatException {
        int indice;
        do {
            System.out.print("Ingrese el índice del Círculo: ");
            indice = Integer.parseInt(myScanner.nextLine());

            if (indice >= 0 && indice < circulos.size()) {
                circulos.get(indice).imprimirDatos();
                break;
            }
            else
                System.out.println("Ingrese un índice válido");
        } while (true);
    }
}
