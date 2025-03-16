//2. Tabla de multiplicar 2.0
// En esta actividad, vas a crear un programa que solicita al usuario
// que ingrese 3 números (incluida la lógica en un método llamado
// pedirNumeros())  y luego imprime la tabla de multiplicar de cada
// uno de ellos  1 al 10 (incluida la lógica en un método llamado
// imprimirTablasMultiplicar(int[] numeros)).
// Para ello, implementarás un  un array para almacenar los números
// ingresados y luego invocarás el método para cada uno de ellos.

import java.util.Scanner;

public class MultiplicationTable2 {
    public static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args) {
        getNumber(myScanner);
    }

    private static void getNumber(Scanner myScanner) {
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter a number: ");
            numbers[i] = Integer.parseInt(myScanner.nextLine());
        }
        printMultiplicationTable(numbers);
    }

    private static void printMultiplicationTable(int[] numbers) {
        for (int num : numbers) {
            System.out.printf("%n");
            for (int i = 1; i < 11; i++) {
                int result = num * i;
                System.out.printf("%s x %s = %s %n", num, i, result);
            }
        }
    }
}
