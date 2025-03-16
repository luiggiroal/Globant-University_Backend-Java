package Liga_Futbol_I;

import java.util.List;
import java.util.Scanner;

public class Jugador {
    private String nombre;
    private Equipo equipo;

    public Jugador (String nombre, Equipo equipo) {
        this.nombre = nombre;
        this.equipo = equipo;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return this.nombre;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
    public Equipo getEquipo() {
        return this.equipo;
    }

}
