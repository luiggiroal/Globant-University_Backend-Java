//
///*En esta actividad, se solicita al usuario ingresar una cadena
//de texto y calcular su longitud, pero esta vez sin contar los espacios
// en blanco. Para lograr esto, se utilizará el método length()
// de la clase String y se realizará un proceso adicional para excluir
// los espacios de la cuenta.*/
//
//import java.util.Scanner;
//
//public class lengthStrings {
//    public static void main(String[] args) {
//        Scanner myScanner = new Scanner(System.in);
//
//        System.out.println("Ingrese una cadena de texto:");
//        String myString = myScanner.nextLine();
//
//        /* Simpler solution */
//        String myStringNoBlankSpaces = myString.replace(" ", "");
//
//        /* More complex solution */
////        String myStringNoBlankSpaces = "";
////        String[] myStringArray = myString.split(" ");
////        for (int i = 0; i < myStringArray.length; i++) myStringNoBlankSpaces += myStringArray[i];
//
//        System.out.println(
//                "Cadena de texto con espacios en blanco: " + myString
//                + "\nLongitud: " + myString.length()
//                + "\n\nCadena de texto sin espacios en blanco: " + myStringNoBlankSpaces
//                + "\nLongitud: " + myStringNoBlankSpaces.length() );
//    }
//}
