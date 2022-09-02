import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

public class testMethods {
    @AfterAll
    public static void init(){
        System.out.println("All tests done");
    }
    @Test
    public void getMethodTest() throws NoSuchFieldException, IllegalAccessException {
        Horse horse = new Horse("Ann", 1, 1);


        Field name = Horse.class.getDeclaredField("name");
        name.setAccessible(true);
        String nameValue = (String) name.get(horse);
        assertEquals("Ann", nameValue);
    }

    @Test
    public void getSpeedTest() {
        double expectedSpeed = 443;

        Horse horse = new Horse("Ann", expectedSpeed, 1);
        assertEquals(expectedSpeed, horse.getSpeed());

    }

    @Test
    public void getDistanceTest(){
        double expectedDistance = 443;

        Horse horse1 = new Horse("Ann", 1, expectedDistance);
        assertEquals(expectedDistance, horse1.getDistance());

        Horse horse2 = new Horse("Sara", 1);
        assertEquals(0, horse2.getDistance());
    }

    @Test
    public void moveTest(){
        try(MockedStatic<Horse> mockedStatic = mockStatic(Horse.class)){
            new Horse("Ann", 1, 1).move();

            mockedStatic.verify(( ) -> Horse.getRandomDouble(0.2, 0.9));
        }
    }

    @Test
    public void getWinnerTest(){
        Horse horse1 = new Horse("Ann", 2, 4);
        Horse horse2 = new Horse("Nasya", 3, 5);

        List<Horse> Horse = new ArrayList<>();
        Horse.add(horse1);
        Horse.add(horse2);

        Hippodrome winner = new Hippodrome(Horse);
        winner.getWinner();

    }
}
