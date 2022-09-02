import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HippodromeTest {
    @Test
    public void HippodromeNullException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Hippodrome(null);
        });
    }

    @Test
    public void HippodromeExceptionMassage() {
        try {
            new Hippodrome(null);
        } catch (IllegalArgumentException e) {
            assertEquals("Horses cannot be null.", e.getMessage());
        }
    }

    @Test
    public void NullListException() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(new ArrayList<>()));
    }

    @Test
    public void HippodromeListExceptionMassage() {
        try {
            new Hippodrome(new ArrayList<>());
        } catch (IllegalArgumentException e) {
            assertEquals("Horses cannot be empty.", e.getMessage());
        }
    }

    @Test
    public void geyHorses() {
        List<Horse> horses = new ArrayList<Horse>();
        for (int i = 0; i < 30; i++) {
            horses.add(new Horse("" + i, i));
        }

        Hippodrome hippodrome = new Hippodrome(horses);

        assertEquals(horses, hippodrome.getHorses());
    }

    @Test
    public void moveTest() {
        List<Horse> horseList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            horseList.add(mock(Horse.class));
        }

        new Hippodrome(horseList).move();

        for (Horse horse : horseList) {
            verify(horse).move();
        }
    }

    @Test
    public void getWinner(){
        Horse horse1 = new Horse("Ann", 2, 4);
        Horse horse2 = new Horse("Nasya", 3, 5);

        Hippodrome hippodrome = new Hippodrome(List.of(horse1, horse2));

        assertSame(horse2, hippodrome.getWinner());
    }
}
