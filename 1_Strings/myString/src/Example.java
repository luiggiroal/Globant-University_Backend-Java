//
//public class EjIntegrador {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        try {
//// Solicitar la temperatura
//            System.out.print("Ingresa la temperatura: ");
//            String inputTemperatura = scanner.nextLine();
//            double temperatura = Double.parseDouble(inputTemperatura); // Convertimos la entrada a double
//
//// Solicitar la unidad de medida
//            System.out.print("Ingresa la unidad de medida (C para Celsius, F para Fahrenheit): ");
//            String unidad = scanner.nextLine().toUpperCase(); // Convertimos a mayúscula para evitar errores de minúscula
//
//// Verificar la unidad de medida y realizar la conversión
//            if (unidad.equals("C")) {
//// Convertir de Celsius a Fahrenheit
//                double fahrenheit = (temperatura * 9 / 5) + 32;
//                System.out.println("La temperatura en Fahrenheit es: " + fahrenheit + "°F");
//            } else if (unidad.equals("F")) {
//// Convertir de Fahrenheit a Celsius
//                double celsius = (temperatura - 32) * 5 / 9;
//                System.out.println("La temperatura en Celsius es: " + celsius + "°C");
//            } else {
//// Unidad de medida inválida
//                throw new IllegalArgumentException("Unidad de medida no válida. Debe ser 'C' o 'F'.");
//            }
//
//        } catch (NumberFormatException e) {
//// Error al convertir la temperatura (por ejemplo, si no ingresa un número)
//            System.out.println("Error: La temperatura ingresada no es válida. Debes ingresar un número.");
//        } catch (IllegalArgumentException e) {
//// Error por unidad de medida inválida
//            System.out.println(e.getMessage());
//        } catch (Exception e) {
//// Manejo de cualquier otra excepción
//            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
//        }
//
//        scanner.close();
//    }
