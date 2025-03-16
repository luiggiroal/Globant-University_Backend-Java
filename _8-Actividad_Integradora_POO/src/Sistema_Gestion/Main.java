package Sistema_Gestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
        int option;
        List<Empleado> empleados = new ArrayList<>();
        List<Empleado> empleadosOriginal = new ArrayList<>();
        boolean trigger = false;
//        List<Empleado> empleadosTemp = new ArrayList<>();
        System.out.println("Bienvenido al Sistema de Gestión " +
                "de emplados");
        do {
            System.out.print("""
                    
                    1.Mostrar todos los empleados
                    2.Crear empleado
                    3.Filtrar empleados
                    4.Ordenar empleados
                    5.Incrementar salario
                    6.Limpiar filtros
                    7.Salir del programa
                    
                    Ingrese una opción: """);
            option = Integer.parseInt(myScanner.nextLine());
            switch (option) {
                case 1 -> Empleado.imprimirEmpleados(empleados);
                case 2 -> {
                    if (!trigger) {
                        crearEmpleado(empleados);
                        empleadosOriginal = new ArrayList<>(empleados);
                    }
                    else
                        crearEmpleado(empleados);
                }
                case 3 -> {
//                    empleadosOriginal = empleados;
                    empleados = filtrarEmpleados(empleados);
                    trigger = true;
                }
                case 4 -> {
//                    System.out.println("Antes de ordenarEmpleados");
//                    Empleado.imprimirEmpleados(empleadosOriginal);
                    empleados = ordenarEmpleados(empleados);
//                    System.out.println("Después de ordenarEmpleados");
//                    Empleado.imprimirEmpleados(empleadosOriginal);
                    trigger = true;
                }
                case 5 -> incrementarSalario(empleados);
                case 6 -> limpiarFiltros(empleados, empleadosOriginal);
                case 7 -> System.out.println("Gracias por usar el Sistema" +
                        " de Gestión de Empleados.\n¡Adiós!");
                default -> System.out.println("Ingrese una opción válida");
            }
        } while (option != 7);
    }

    public static List<Empleado> crearEmpleado(List<Empleado> empleados) {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = myScanner.nextLine();

        if (Empleado.buscarPorNombre(empleados, nombre) != null) {
            System.out.printf("Error. El empleado con nombre %s " +
                    "ya existe.", nombre);
            return empleados;
        }

        System.out.print("Ingrese la edad del empleado: ");
        int edad = Integer.parseInt(myScanner.nextLine());
        System.out.print("Ingrese el salario del empleado: ");
        double salario = Double.parseDouble(myScanner.nextLine());
        System.out.print("Ingrese el departamento del empleado: ");
        String departamento = myScanner.nextLine();

        empleados.add(new Empleado(nombre, edad, salario, departamento));
        System.out.println("Empleado creado");

        return empleados;
    }

    public static List<Empleado> filtrarEmpleados(List<Empleado> empleados) {
        int option;
//        empleadosTemp = empleados;
        do {
            System.out.println("""
                    
                    1.Filtrar por nombre
                    2.Filtrar por edad
                    3.Filtrar por salario
                    4.Filtrar por departamento
                    
                    Ingrese una opción: """);
            option = Integer.parseInt(myScanner.nextLine());

            return switch (option) {
                case 1 -> filtrarPorNombre(empleados);
                case 2 -> filtrarPorEdad(empleados);
                case 3 -> filtrarPorSalario(empleados);
                case 4 -> filtrarPorDepartamento(empleados);
                default -> throw new IllegalArgumentException("Ingrese una opción válida");
//                default -> System.out.println("Ingrese una opción válida");
            };
        } while (option != 1 && option != 2 && option != 3 && option != 4);
//        return empleados;
    }

    public static List<Empleado> ordenarEmpleados(List<Empleado> empleados) {
        int option;
        do {
            System.out.print("""
                    
                    1.Ordenar empleados por nombre
                    2.Ordenar empleados por edad
                    3.Ordenar empleados por salario
                    4.Ordenar empleados por departamento
                    
                    Ingrese una opción: """);
            option = Integer.parseInt(myScanner.nextLine());

            empleados = switch (option) {
                case 1 -> Empleado.ordenarEmpleados(empleados, "nombre");
                case 2 -> Empleado.ordenarEmpleados(empleados, "edad");
                case 3 -> Empleado.ordenarEmpleados(empleados, "salario");
                case 4 -> Empleado.ordenarEmpleados(empleados, "departamento");
                default -> throw new IllegalArgumentException("Ingrese una opción válida.");
//                default -> System.out.println("Ingrese una opción válida.");
            };
        } while (option != 1 && option != 2 && option != 3 && option != 4);

        Empleado.imprimirEmpleados(empleados);
        return empleados;
    }

    public static void incrementarSalario(List<Empleado> empleados) {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = myScanner.nextLine();

        Empleado empleadoEncontrado = Empleado.buscarPorNombre(empleados, nombre);

        if (empleadoEncontrado == null) {
            System.out.printf("El empleado de nombre %s no " +
                    "existe.", nombre);
            return;
        }

        System.out.print("Ingrese el porcentaje de aumento " +
                "(sin el signo de porcentaje): ");
        double porcentajeAumento = Double.parseDouble(myScanner.nextLine());

        System.out.printf("El salario del empleado %s fue " +
                "aumentado un %s%%.", nombre, porcentajeAumento);
        Empleado.imprimirEmpleado(empleados.get(0).incrementarSalario(empleadoEncontrado, porcentajeAumento));
    }

    public static List<Empleado> limpiarFiltros(List<Empleado> empleados, List<Empleado> empleadosOriginal) {
        System.out.println("Dentro de limpirFiltros.\nempleadosOriginal");
        Empleado.imprimirEmpleados(empleadosOriginal);
        empleados = empleadosOriginal;
        System.out.println("Filtros limpiados.");
        Empleado.imprimirEmpleados(empleados);

        return empleados;
    }

    public static List<Empleado> filtrarPorNombre(List<Empleado> empleados) {
        System.out.print("Ingrese el nombre a filtrar: ");
        String nombreFiltro = myScanner.nextLine();

//        empleados = empleados.get(0).filtrarEmpleados(empleados, "nombre", nombreFiltro);
        empleados = Empleado.filtrarEmpleados(empleados, "nombre", nombreFiltro);
        Empleado.imprimirEmpleados(empleados);

        return empleados;
    }
    public static List<Empleado> filtrarPorEdad(List<Empleado> empleados) {
        System.out.print("Ingrese una edad mínima a filtrar: ");
        int edadMin = Integer.parseInt(myScanner.nextLine());
        System.out.print("Ingrese una edad máxima a filtrar: ");
        int edadMax = Integer.parseInt(myScanner.nextLine());

        empleados = Empleado.filtrarEmpleados(empleados, "edad", edadMax, edadMin);
        Empleado.imprimirEmpleados(empleados);

        return empleados;
    }
    public static List<Empleado> filtrarPorSalario(List<Empleado> empleados) {
        System.out.print("Ingrese un salario mínimo a filtrar: ");
        int salarioMin = Integer.parseInt(myScanner.nextLine());
        System.out.print("Ingrese un salario máximo a filtrar: ");
        int salarioMax = Integer.parseInt(myScanner.nextLine());

        empleados = Empleado.filtrarEmpleados(empleados, "salario", salarioMax, salarioMin);
        Empleado.imprimirEmpleados(empleados);

        return empleados;
    }
    public static List<Empleado> filtrarPorDepartamento(List<Empleado> empleados) {
        System.out.print("Ingrese el departamento a filtrar: ");
        String departamentoFiltro = myScanner.nextLine();

        empleados = Empleado.filtrarEmpleados(empleados, "departamento", departamentoFiltro);
        Empleado.imprimirEmpleados(empleados);

        return empleados;
    }
}
