package Sistema_Gestion;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private int edad;
    private double salario;
    private String departamento;

    public Empleado(String nombre, int edad, double salario, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public static void imprimirEmpleados(List<Empleado> empleados) {
        System.out.println("FILA\tNOMBRE\tEDAD\tSALARIO\t\tDEPARTAMENTO");
        for (Empleado empleado : empleados) {
            System.out.printf("%s\t\t", empleados.indexOf(empleado) + 1);
            imprimirEmpleado(empleado);
        }
        System.out.println();
    }
    public static void imprimirEmpleado(Empleado empleado) {
        System.out.printf("%s\t%s\t\t%s\t\t%s\n", empleado.getNombre(), empleado.getEdad(), empleado.getSalario(), empleado.getDepartamento());
    }
    public static List<Empleado> filtrarEmpleados(List<Empleado> empleados, String tipoFiltro, String filtro) {
        return switch (tipoFiltro) {
            case "nombre" -> filtrarNombre(empleados, filtro);
            case "departamento" -> filtrarDepartamento(empleados, filtro);
            default -> throw new IllegalArgumentException("Error. Ingrese 'nombre' o 'departamento'");
        };
//        return empleados;
    }
    public static List<Empleado> filtrarEmpleados(List<Empleado> empleados, String tipoFiltro, int valMax, int valMin) {
        return switch (tipoFiltro) {
            case "salario" -> filtrarSalario(empleados, valMax, valMin);
            case "edad" -> filtrarEdad(empleados, valMax, valMin);
            default -> throw new IllegalArgumentException("Error. Ingrese 'salario' o 'edad'");
        };
    }

    public static List<Empleado> ordenarEmpleados (List<Empleado> empleados, String tipoFiltro) {
        return switch (tipoFiltro) {
            case "nombre" -> ordenarPorNombre(empleados);
            case "departamento" -> ordenarPorDepartamento(empleados);
            case "edad" -> ordenarPorEdad(empleados);
            case "salario" -> ordenarPorSalario(empleados);
            default -> throw new IllegalArgumentException("Error. Ingrese un tipo de filtro válido.");
        };
//        return empleados;
    }

    public static Empleado buscarPorNombre(List<Empleado> empleados, String nombreBusqueda) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(nombreBusqueda))
                return empleado;
        }
        return null;
    }

    public Empleado incrementarSalario(Empleado empleado, double porcentajeAumento) {
        empleado.setSalario(empleado.getSalario() * (1 + (porcentajeAumento / 100)));
        return empleado;
    }

    public static List<Empleado> ordenarPorNombre(List<Empleado> empleados) {
        Empleado temp;
        boolean cambia;
        for (int i = 0; i < empleados.size() - 1; i++) {
            cambia = false;
            for (int j = 0; j < empleados.size() - 1 - i; j++) {
                if (empleados.get(j).getNombre().compareToIgnoreCase(empleados.get(j+1).getNombre()) > 0 ) {
                    temp = empleados.get(j);
                    empleados.set(j, empleados.get(j+1));
                    empleados.set(j+1, temp);
                    cambia = true;
                }
            }

            if (!cambia)
                break;
        }
        return empleados;
    }
    public static List<Empleado> ordenarPorDepartamento(List<Empleado> empleados) {
        Empleado temp;
        boolean cambia;
        for (int i = 0; i < empleados.size() - 1; i++) {
            cambia = false;
            for (int j = 0; j < empleados.size() - 1 - i; j++) {
                if (empleados.get(j).getDepartamento().compareToIgnoreCase(empleados.get(j+1).getDepartamento()) > 0 ) {
                    temp = empleados.get(j);
                    empleados.set(j, empleados.get(j+1));
                    empleados.set(j+1, temp);
                    cambia = true;
                }
            }

            if (!cambia)
                break;
        }
        return empleados;
    }
    public static List<Empleado> ordenarPorEdad(List<Empleado> empleados) {
        Empleado temp;
        boolean cambia;
        for (int i = 0; i < empleados.size() - 1; i++) {
            cambia = false;
            for (int j = 0; j < empleados.size() - 1 - i; j++) {
                if (empleados.get(j).getEdad() > empleados.get(j+1).getEdad()) {
                    temp = empleados.get(j);
                    empleados.set(j, empleados.get(j+1));
                    empleados.set(j+1, temp);
                    cambia = true;
                }
            }

            if (!cambia)
                break;
        }
        return empleados;
    }
    public static List<Empleado> ordenarPorSalario(List<Empleado> empleados) {
        Empleado temp;
        boolean cambia;
        for (int i = 0; i < empleados.size() - 1; i++) {
            cambia = false;
            for (int j = 0; j < empleados.size() - 1 - i; j++) {
                if (empleados.get(j).getSalario() > empleados.get(j+1).getSalario()) {
                    temp = empleados.get(j);
                    empleados.set(j, empleados.get(j+1));
                    empleados.set(j+1, temp);
                    cambia = true;
                }
            }

            if (!cambia)
                break;
        }
        return empleados;
    }

    public static List<Empleado> filtrarNombre(List<Empleado> empleados, String filtro) {
        List<Empleado> empleadosFiltrado = new ArrayList<>();
//        empleados = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equalsIgnoreCase(filtro))
//                empleados.add(empleado);
                empleadosFiltrado.add(empleado);
        }
//        empleados = empleadosFiltrado;
//        System.out.println("Dentro de filtrarNombre");
//        imprimirEmpleados(empleados);
        return  empleadosFiltrado;
//        return empleadosFiltrado;
    }
    public static List<Empleado> filtrarDepartamento(List<Empleado> empleados, String filtro) {
        List<Empleado> empleadosFiltrado = new ArrayList<>();
//        empleados = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getDepartamento().equalsIgnoreCase(filtro))
                empleadosFiltrado.add(empleado);
//                empleadosFiltrado.add(empleado);
        }
        return empleadosFiltrado;
//        return empleados;
    }
    public static List<Empleado> filtrarSalario (List<Empleado> empleados, int valMax, int valMin) {
        List<Empleado> empleadosFiltrado = new ArrayList<>();
//        empleados = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getSalario() >= valMin && empleado.getSalario() <= valMax)
                empleadosFiltrado.add(empleado);
//                empleados.add(empleado);
        }
        return empleadosFiltrado;
//        return empleados;
    }
    public static List<Empleado> filtrarEdad (List<Empleado> empleados, int valMax, int valMin) {
        List<Empleado> empleadosFiltrado = new ArrayList<>();
//        empleados = new ArrayList<>();
        for (Empleado empleado : empleados) {
            if (empleado.getEdad() >= valMin && empleado.getEdad() <= valMax)
                empleadosFiltrado.add(empleado);
//                empleados.add(empleado);
        }
//        return empleados;
        return empleadosFiltrado;
    }
}

