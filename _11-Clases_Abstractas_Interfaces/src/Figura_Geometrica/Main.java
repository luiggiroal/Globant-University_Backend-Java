package Figura_Geometrica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figura> figuras = new ArrayList<>(Arrays.asList(
                new Triangulo(3, 4, 5),
                new Rectangulo(3, 4),
                new Circulo(5)
        ));

        for (Figura figura : figuras) {
//          Since method 'dibujar()' is not declared in class 'Figura'
//          but it is in interface 'Dibujable' then the object 'figura' of
//          class 'Figura' should be cast to class 'Dibujable'.
//          It's important to make sure first that object 'figura' is
//          an instance of class 'Dibujable'.
            if (figura instanceof Dibujable)
                ((Dibujable) figura).dibujar();
            System.out.printf("Área: %s\n", figura.calcularArea());
            System.out.printf("Perímetro: %s\n\n", figura.calcularPerimetro());
        }
    }
}
