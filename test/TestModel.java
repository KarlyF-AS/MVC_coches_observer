import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import COD.programas.coches.*;
public class TestModel {

    @BeforeEach
    public void setUp() {
        Model.parking.clear(); // Limpiar el parking antes de cada test
    }

    @Test
    @Tag("Modelo")
    public void testCrearCoche() {
        Coche coche = Model.crearCoche("Toyota", "ABC123");

        assertNotNull(coche);
        assertEquals("Toyota", coche.modelo);
        assertEquals("ABC123", coche.matricula);
        assertEquals(0, coche.velocidad); // Velocidad inicial debe ser 0
        assertTrue(Model.parking.contains(coche));
    }

    /**
     * @Test public void testNoAgregarDosCochesConMismaMatricula() {
     * Model.crearCoche("Toyota", "XYZ789");
     * <p>
     * assertThrows(IllegalArgumentException.class, () -> {
     * Model.crearCoche("Nissan", "XYZ789");
     * });
     * <p>
     * assertEquals(1, Model.parking.size());
     * }
     */

    @Test
    @Tag("Matricula")
    public void testBuscarCochePorMatriculaValida() {
        Model.crearCoche("LaFerrari", "SBC1234");

        Coche coche = Model.getCoche("SBC1234");
        assertNotNull(coche);
        assertEquals("LaFerrari", coche.modelo);
        assertEquals("SBC1234", coche.matricula);
    }

    @Test
    public void testBuscarCochePorMatriculaInvalida() {
        Coche coche = Model.getCoche("INVALIDA");
        assertNull(coche);
    }
    @Test
    public void testCambiarVelocidadCocheExistente() {
        Model.crearCoche("LaFerrari", "SBC1234");
        Model.cambiarVelocidad("SBC1234", 60);

        assertEquals(60, Model.getVelocidad("SBC1234"));
    }
    @Test
    public void testAumentarVelocidad() {
        Model.crearCoche("LaFerrari", "SBC1234");
        Model.aumentarVelocidad("SBC1234", 20);

        assertEquals(20, Model.getVelocidad("SBC1234"));
    }
    @Test
    public void testDisminuirVelocidad() {
        Model.crearCoche("LaFerrari", "SBC1234");
        Model.disminuirVelocidad("SBC1234", 10);

        assertEquals(-10, Model.getVelocidad("SBC1234")); // Puede llegar a negativo según diseño
    }

}
