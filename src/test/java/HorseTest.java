import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class HorseTest {
    @Test
    public void nameHorseException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null, 1, 1);
        });
    }

    @Test
    public void nullNameMassage() {
        try {
            new Horse(null, 1, 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be null.", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "   ", "\t\t", "\n", "\n\n", "\n\n\n"})
    public void spaceException(String name) {
        try {
            new Horse(name, 1, 1);
        } catch (IllegalArgumentException e) {
            assertEquals("Name cannot be blank.", e.getMessage());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10})
    public void secondArgumentNotMinus(double speed) {
        try {
            new Horse("Dasha", speed, 1);
        } catch (IllegalArgumentException e) {
            assertTrue(speed < 0);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10})
    public void secondArgumentNotMinusCheckMessage(double speed) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Dasha", speed, 1);
        });

        assertEquals("Speed cannot be negative.", e.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10})
    public void thirdArgumentNotMinus(double distance) {
        try {
            new Horse("Dasha", 1, distance);
        } catch (IllegalArgumentException e) {
            assertTrue(distance < 0);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -3, -4, -5, -6, -7, -8, -9, -10})
    public void thirdArgumentNotMinusCheckMessage(double distance) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Dasha", 1, distance);
        });

        assertEquals("Distance cannot be negative.", e.getMessage());
    }


}
