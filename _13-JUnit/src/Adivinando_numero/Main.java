package Adivinando_numero;

import java.util.Scanner;

public class Main {
    static Scanner myScanner = new Scanner(System.in);
    public static void main(String[] args) {
        int aleatorio = numeroAleatorio(13, 35);
        System.out.println(aleatorio);
//        String msg;
        int num;
        do {
            System.out.print("Ingrese un número: ");
            num = Integer.parseInt(myScanner.nextLine());

            if (num > aleatorio)
                System.out.println("El número " + num +
                        " es mayor al número aleatorio");
            else if (num < aleatorio)
                System.out.println("El número " +  num + " es menor al número aleatorio");
            else
                System.out.println("Exito! El número " + num + " es el número aleatorio.");

//            msg = (num > aleatorio) ? ("El número " + num +
//                    " es mayor al número aleatorio") :
//                    ("El número " +  num + " es menor al número aleatorio");

//            System.out.println(msg);
        } while (aleatorio != num);


    }

    static int numeroAleatorio(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
