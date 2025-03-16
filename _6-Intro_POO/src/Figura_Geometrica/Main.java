package Figura_Geometrica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
        myScanner.close();
    }

    public static void menu() {
        Integer option;
        List<Rectangulo> rectangulos = new ArrayList<>();
        System.out.println("\nBienvenido!");
        do {
            System.out.println("""

                    1.Crear un rectángulo.
                    2.Calcular el área y perimetro del rectángulo
                    3.Ver número total de rectángulos creados.
                    4.Salir.
                    """);
            System.out.print("Elija una opción: ");
            option = Integer.parseInt(myScanner.nextLine());

            System.out.println("\n******************************");
            switch (option) {
                case 1 -> crearRectangulo(rectangulos);
                case 2 -> imprimirAreaPerimetro(rectangulos);
                case 3 -> imprimirTotalRectangulos();
                case 4 -> System.out.println("Adiós!");
                default -> System.out.println("Ingrese una opción válida");
            }
            System.out.println("******************************\n");
        } while (option != 4);
    }

    public static void crearRectangulo(List<Rectangulo> rectangulos) {
        Double ancho, alto;

        System.out.print("Ingrese el ancho del rectángulo: ");
        ancho = Double.parseDouble(myScanner.nextLine());
        System.out.print("Ingrese el alto del rectángulo: ");
        alto = Double.parseDouble(myScanner.nextLine());

        rectangulos.add(new Rectangulo(ancho, alto));
        System.out.println("\nRectangulo creado");
    }

    public static void imprimirAreaPerimetro(List<Rectangulo> rectangulos) {
        Integer indice;
        System.out.print("Ingrese el índice del rectangulo: ");
        indice = Integer.parseInt(myScanner.nextLine());

        if (indice >= 0 && indice < rectangulos.size()){
            System.out.printf("""
                    -------------------------------------
                    Rectangulo con ancho %s y con alto %s.
                    -------------------------------------
                    """, rectangulos.get(indice).getAncho(), rectangulos.get(indice).getAlto());
            rectangulos.get(indice).imprimirArea();
            rectangulos.get(indice).imprimirPerimetro();
        }
        else
            System.out.println("Ingrese un indice válido.");
    }

    public static void imprimirTotalRectangulos() {
        System.out.printf("El numero total de rectangulos creados hasta " +
                "el momento es %s.%n", Rectangulo.obtenerNumeroRectangulos());
    }
}
