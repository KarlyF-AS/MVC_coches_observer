package testPreObserver;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestModel {

    @BeforeEach
    public void setUp() {
        Model.parking.clear(); // Limpiar parking antes de cada test
    }

    @Test
    public void testCrearCoche() {
        Coche coche = Model.crearCoche("Toyota", "ABC123");

        assertNotNull(coche);
        assertEquals("Toyota", coche.modelo);
        assertEquals("ABC123", coche.matricula);
        assertEquals(0, coche.velocidad); // Velocidad inicial debe ser 0
        assertTrue(Model.parking.contains(coche));
    }
}
