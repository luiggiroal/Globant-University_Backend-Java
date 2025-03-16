
package Liga_Futbol_I;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner myScanner = new Scanner(System.in);
    static List<Jugador> jugadores = new ArrayList<>();
    static List<Equipo> equipos = new ArrayList<>();

    public static void main(String[] args) {
        int option;
        do {
            System.out.print("""
                    
                    1.Crear jugador
                    2.Crear equipo
                    3.Asignar jugador
                    4.Mostrar lista de jugadores
                    5.Mostrar lista de equipos
                    6.Salir
                    
                    Ingrese una opción: """);
            option = Integer.parseInt(myScanner.nextLine());

            switch (option) {
                case 1 -> crearJugador();
                case 2 -> crearEquipo();
                case 3 -> asignarJugadorEquipo();
                case 4 -> imprimirListaJugadores();
                case 5 -> imprimirListaEquipos();
                case 6 -> System.out.println("Gracias por usar el " +
                        "Sistema de Gestión de Liga de Fútbol");
                default -> System.out.println("Ingrese una opción " +
                        "válida.");
            }
        } while (option != 6);
    }

    public static void crearJugador() {
        int option;

        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = myScanner.nextLine();

        if (!equipos.isEmpty()) {
            do {
                System.out.println("Elija un equipo:\n");
                imprimirListaEquipos();
                System.out.print("\nIngrese una opción: ");
                option = Integer.parseInt(myScanner.nextLine());

                if (option >= 1 && option <= equipos.size())
                    break;

                System.out.println("Ingrese una opción válida.");

//              TODO: Handle when 'option' is an String
//            } while (option < 1 || option > equipos.size());
            } while (true);

            jugadores.add(new Jugador(nombre, equipos.get(option - 1)));
            System.out.printf("Jugador creado con el nombre \"%s\" y " +
                    "asignado al equipo \"%s\".", nombre, equipos.get(option - 1).getNombre());
            return;
        }

        System.out.println("No hay equipos disponibles");
        jugadores.add(new Jugador(nombre, null));
        System.out.printf("Jugador creado con el nombre \"%s\", pero " +
                "sin equipo asignado.", nombre);
    }

    public static void imprimirListaEquipos() {
        for (int i = 0; i < equipos.size(); i++) {
            System.out.printf("%s.%s\n", i + 1, equipos.get(i).getNombre());
        }
    }

    public static void crearEquipo() {
        System.out.print("Ingrese el nombre del equipo: ");
        String nombre = myScanner.nextLine();

//      TODO: Validate if the input is an String.

        equipos.add(new Equipo(nombre));
        System.out.printf("Equipo creado con el nombre \"%s\".", nombre);
    }

    public static void asignarJugadorEquipo() {
        int optionJug;
        int optionEqu;
        Jugador jugadorElegido;
        Equipo equipoElegido;

        if (!jugadores.isEmpty()) {
            do {
                System.out.println("Elija un jugador:\n");
                imprimirListaJugadores();
                System.out.print("\nIngrese una opción: ");
                optionJug = Integer.parseInt(myScanner.nextLine());

                if (optionJug >= 1 && optionJug <= jugadores.size())
                    break;

                System.out.println("Ingrese una opción válida.");
            } while (true);

            jugadorElegido = jugadores.get(optionJug - 1);

            if (!equipos.isEmpty()) {
                do {
                    System.out.println("Elija un equipo:\n");
                    imprimirListaEquipos();
                    System.out.print("\nIngrese una opción: ");
                    optionEqu = Integer.parseInt(myScanner.nextLine());

                    if (optionEqu >= 1 && optionEqu <= equipos.size())
                        break;

                    System.out.println("Ingrese una opción válida.");
                } while (true);

                equipoElegido = equipos.get(optionEqu -1);

                jugadorElegido.setEquipo(equipoElegido);
                System.out.printf("Jugador \"%s\" asignado al " +
                        "equipo \"%s\".", jugadorElegido.getNombre(), equipoElegido.getNombre());

                return;
            }

            System.out.printf("No hay equipos disponibles. " +
                    "Jugador \"%s\" no fue asignado a ningún " +
                    "equipo", jugadorElegido.getNombre());
            return;
        }

        System.out.println("No hay jugadores disponibles. " +
                "Crear un jugador antes.");
    }

    public static void imprimirListaJugadores() {
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getEquipo() == null)
                System.out.printf("%s.%s -> sin equipo asignado\n", i + 1, jugadores.get(i).getNombre());
            else
                System.out.printf("%s.%s -> %s\n", i + 1, jugadores.get(i).getNombre(), jugadores.get(i).getEquipo().getNombre());
        }
    }
}
