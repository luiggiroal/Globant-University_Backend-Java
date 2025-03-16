// Actividad: Depurando un programa con un Bucle
// Crea un programa que use un bucle fori para iterar a través de
// un array de números y calcular la suma de todos los números
// en el array.
//
// Coloca un punto de interrupción dentro del bucle.
// Ejecuta el programa en modo debug y observa cómo cambian los
// valores de "suma" y "número" en cada iteración usando el
// “step over”.
//
// Luego vuelve a ejecutar el programa pero utiliza un
// “breakpoint condicional” para que el programa se detenga
// en el anteúltimo índice del array
//
//💡Un breakpoint condicional es un breakpoint común al que se le
// agrega una sentencia de evaluación. Para realizar esto se hace
// click derecho en el breakpoint y se selecciona la opción
// “Edit Breakpoint…”, eso habilitará un input donde se podrá
// escribir una sentencia (en el lenguaje java) que se evaluará
// cada vez que el programa pase por ese breakpoint, cuando la
// sentencia devuelve “true” el programa se detendrá al pasar por
// el breakpoint.
public class DebugLoop {
    public static void main(String[] args) {
        int[] arrayInt = {1, 2, 3, 4, 5};
        int total = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            total += arrayInt[i];
        }
        System.out.printf("La suma total es: %s", total);
    }
}