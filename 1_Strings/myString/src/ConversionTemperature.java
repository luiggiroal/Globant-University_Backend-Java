//import java.util.Scanner;
//
///* Escribe un programa que cumpla con las siguientes condiciones:
//
//1. Solicita al usuario ingresar una temperatura y una unidad de medida: Celsius (C) o Fahrenheit (F).
//2. Convierte la temperatura a la otra unidad de medida y muestra el resultado en pantalla.
//3. El programa debe manejar al menos las siguientes situaciones:
//Si ingresa una unidad de medida inválida, mostrará un mensaje de error.
//Si ingresa una temperatura no válida, mostrará un mensaje de error.
//*/
//public class ConversionTemperature {
//    public static void main(String[] args) {
//        Scanner myScanner = new Scanner(System.in);
//
//        System.out.print("Ingrese la temperatura: ");
//        float temperature = Float.parseFloat(myScanner.nextLine());
////        myScanner.nextLine();  // Consume the leftover newline (\n)
//        System.out.print("Ingrese la unidad de medida (C/F): ");
//        String unit = myScanner.nextLine();
//
//        float result;
//        String[] printedUnits = {"Celsius", "Fahrenheit"};
//        try {
//            if (unit.equalsIgnoreCase("C")) {  // Comparison case-insensitive
//                result = (temperature * (float) 9 / 5) + 32;
//            } else if (unit.equalsIgnoreCase("F")) {
//                result = ((temperature - 32) * (float) 5 / 9);
//                printedUnits = new String[] {"Fahrenheit","Celsius"};
//            } else {
//                throw new IllegalArgumentException("Unidad de medida no válida. " +
//                        "Debe ser 'C' o 'F'.");
//            }
//
//            System.out.printf("%s grados %s equivale a %s grados %s%n", temperature, printedUnits[0], result, printedUnits[1]);
//
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//
//
//        myScanner.close();
////        float result = (unit.equals("C")) ?
////                ((temperature * ((float) (9 / 5))) + 32) :
////                ((temperature - 32) * 5 / 9);
//
//
//
////        System.out.println(temperature + " grados ");
//    }
//}
