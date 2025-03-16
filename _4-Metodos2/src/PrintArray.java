import java.lang.reflect.Array;
import java.util.Arrays;

// 4. Imprimir array: Crea un programa que utilice un
// método "imprimirArray(int[] array)" que se encargue de imprimir
// un array por consola. El método debe recibir como parámetro
// un arreglo de tipo "int" y no devolver nada. Luego, crea una
// sobrecarga del método para que acepte arrays de tipo String
// y arreglos bidimensionales de tipo "int" y de tipo "String".
public class PrintArray {
    public static void main(String[] args) {
        int[] arrayInt = {1, 2, 3};
        String[] arrayStr = {"foo", "this", "name"};
        int[][] bidArrayInt = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        String[][] bidArrayStr = {
                {"Yellow", "Pink", "Blue"},
                {"Red", "Orange", "Green"},
                {"Black", "White", "Purple"},
        };

        printArray(arrayInt);
        printArray(arrayStr);
        printArray(bidArrayInt);
        printArray(bidArrayStr);
    }

    private static void printArray(int[] arrayInt) {
        System.out.print("[ ");
        for (int element : arrayInt) {
            System.out.printf("%s ", element);
        }
        System.out.println("]\n");
    }

    private static void printArray(String[] arrayStr) {
        System.out.print("[ ");
        for (String element : arrayStr) {
            System.out.printf("%s ", element);
        }
        System.out.println("]\n");
    }

    private static void printArray(int[][] bidArrayInt) {
        System.out.print("[\n");
        for (int[] row : bidArrayInt) {
            System.out.print("[ ");
            for (int column : row) {
                System.out.printf("%s ", column);
            }
            System.out.print("]\n");
        }
        System.out.println("]\n");
    }

    private static void printArray(String[][] bidArrayStr) {
        System.out.println("[");
        for (String[] row : bidArrayStr) {
            System.out.print("[ ");
            for (String column : row) {
                System.out.printf("%s ", column);
            }
            System.out.print("]\n");
        }
        System.out.println("]");
    }
}
