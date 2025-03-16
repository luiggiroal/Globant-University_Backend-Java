import java.util.Scanner;

// 1. Obtener datos: Perfeccionando la actividad de “imprimir
// datos”, no solo crea el método imprimeNombreYEdad(String
// nombre, int edad) que reciba dos parámetros, el nombre y la edad,
// sino a su vez, crea dos métodos para obtener el nombre y la
// edad, respectivamente. Ambos métodos deben recibir por parámetro
// un objeto de tipo "Scanner".
//
// 2. Usar una variable global: Modifica los métodos
// "obtenerNombre()" y "obtenerEdad()" para que no necesiten
// recibir el Scanner por parámetro. En su lugar, utiliza una
// variable global para acceder al Scanner y obtener los datos
// necesarios.
//public class LetsWork {
//    public static Scanner myScanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        String name = getName(myScanner);
//        int age = getAge(myScanner);
//        printNameAge(name, age);
//    }
//
//    private static String getName(Scanner myScanner) {
//        System.out.print("Enter your name: ");
//        return myScanner.nextLine();
//    }
//
//    private static int getAge(Scanner myScanner) {
//        System.out.print("Enter your age: ");
//        return Integer.parseInt(myScanner.nextLine());
//    }
//
//    private static void printNameAge(String name, int age) {
//        System.out.printf("My name is %s and I'm %s years old.", name, age);
//    }
//}
