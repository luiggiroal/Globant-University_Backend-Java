import java.util.Scanner;

public class ConversionTemperature1 {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        float temperature;
        String unit;

        try {
            temperature = getTemperature(myScanner);
            unit = getTempUnit(myScanner);
       } catch (NumberFormatException e) {
            System.out.println("La temperatura ingresada no es válida. Debe ser un número");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        } finally {
            myScanner.close();
        }

        float convertedTemp = convertTemp(temperature, unit);
        String[] printedUnits = getPrintedUnits(unit);

        System.out.printf("%s grados %s equivale a %s grados %s.%n",
                temperature, printedUnits[0], convertedTemp, printedUnits[1]);
    }

    private static float getTemperature(Scanner scanner) throws NumberFormatException {
        System.out.print("Ingrese la temperatura: ");
        return Float.parseFloat(scanner.nextLine());
    }

    private static String getTempUnit(Scanner scanner) throws IllegalArgumentException {
        System.out.print("Ingrese la unidad de medida (C/F): ");
        String unit = scanner.nextLine();

        if (!unit.equalsIgnoreCase("C") && !unit.equalsIgnoreCase("F"))
            throw new IllegalArgumentException("Unidad de medida no válida." + "Debe ser 'C' o 'F'.");

        return unit;
    }

    private static float convertTemp(float temperature, String unit) {
        return (unit.equalsIgnoreCase("C")) ?
                (temperature * 9 / 5) + 32
                : (temperature - 32) * 5 / 9;
    }

    private static String[] getPrintedUnits(String unit) {
        return (unit.equalsIgnoreCase("C")) ?
                new String[] {"Celsius", "Farenheit"}
                : new String[] {"Farenheit", "Celsius"};
    }
}
