package Dias_Semana;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DiaSemana[] dias = new DiaSemana[10];
        Random random = new Random();
        for (int i=0; i < dias.length; i++) {
            dias[i] = DiaSemana.values()[random.nextInt(DiaSemana.values().length)];
            imprimirDiaLaboral(dias[i]);
        }
    }

    public static void imprimirDiaLaboral(DiaSemana dia) {
        if (dia.esDiaLaboral())
            System.out.println(dia + ": Día laboral");
        else
            System.out.println(dia + ": No es día laboral");
    }
}
