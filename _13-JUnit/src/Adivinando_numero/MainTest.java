package Adivinando_numero;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
    }

    @RepeatedTest(25)
    void numeroAleatorio() {
        int numAleatorio = Main.numeroAleatorio(13, 35);
        assertTrue(numAleatorio >= 13 && numAleatorio <= 35);
    }
}