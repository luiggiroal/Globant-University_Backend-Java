package org.egg;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class ApplicationTest {

    @Test
    void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void createMockObject() {
        List<String> mockedList = mock(List.class);
        when(mockedList.size()).thenReturn(0);

        int sizeOfMockedList = mockedList.size();

        assertEquals(0, sizeOfMockedList);
//        verify(mockedList).size();
// Crear un objeto simulado de la clase List
// Llamar al método size() del objeto simulado
// Verificar que el tamaño de la lista es 0
    }

    @Test
    public void configureMockObject2() {
        List<String> mockedList = mock(List.class);
        when(mockedList.size()).thenReturn(5);

        int sizeOfMockedList = mockedList.size();

        assertEquals(5, sizeOfMockedList);
// Crear y configurar un objeto simulado de la clase List
// Llamar al método size() del objeto simulado
// Verificar que el tamaño de la lista es el valor configurado
    }

    @Test
    public void verifyInteraction() {
        List<String> mockedList = mock(List.class);

        mockedList.add("un elemento");
        mockedList.add("un elemento");
        mockedList.add("un elemento");
        mockedList.add("un elemento");

        verify(mockedList, never()).add("un elemento");

//        verify(mockedList).add("un elemento");
//        verify(mockedList).("un elemento");
// Crear un objeto simulado de la clase List
// Llamar al método add() del objeto simulado con un elemento
// Verificar que el método add() ha sido llamado
    }

    @Test
    public void createSpyObject() {
        List<String> spyList = spy(new ArrayList<String>());

        spyList.add("elemento real");

        verify(spyList).add("elemento real");

        assertEquals(1, spyList.size());

// Crear un objeto espía de la clase ArrayList
// Añadir un elemento al objeto espía
// Verificar que el método add() ha sido llamado
// Verificar que el tamaño de la lista es 1
    }
}
