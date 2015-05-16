package pl.codesharks.matura;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Tomasz on 2015-05-16.
 */
public class DeadApplesTest {
    @Test
    public void testLoop() throws Exception {
        int MAX_PREDKOSC = 5;
        int ILOSC_LUDZI = 3;

        int[] wzrost = {120, 180, 168};
        int[] wiek = {12, 21, 99};
        int[] szybkoscWzrostu = {10, 20, 1};

        int[] EXPECTED = {245, 255, 265, 275, 285, 293, 293, 293, 293,
                293, 293, 293, 293, 293, 293, 293, 293, 293, 293, 293, 293};

        DeadApples.Human[] humans = new DeadApples.Human[ILOSC_LUDZI];
        for (int i = 0; i < ILOSC_LUDZI; i++) {
            humans[i] = new DeadApples.Human(wzrost[i], wiek[i], szybkoscWzrostu[i]);
        }

        int[] actualResults = DeadApples.logicLoop(MAX_PREDKOSC, humans);
        assertArrayEquals(EXPECTED, actualResults);
    }
}