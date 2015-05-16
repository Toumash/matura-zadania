package pl.codesharks.matura;

import org.junit.Test;
import pl.codesharks.matura.util.EqualsTestCase;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
public class ExercisesTest {
    @Test
    public void testTelefony() {
        String[] t = {"ALAMAKOTA", "BRZECZYSZCZYKIEWICZ"};
        String[] s = {"252625682", "2793299792995439429"};

        EqualsTestCase<String, String> tc = EqualsTestCase.create();
        tc.test(t, s, Exercises::telefony);
    }

    @Test
    public void testIsPESELValid() {
        String[] t = {"44051401458", "12345678901"};
        Boolean[] s = {true, false};
        EqualsTestCase<String, Boolean> tc = EqualsTestCase.create();

        tc.test(t, s, Exercises::isPESELValid);
    }

    @Test
    public void testProstyKalkulator() {
        String[] t = {"1+2+3-4", "0-5+3"};
        Integer[] s = {2, -2};

        EqualsTestCase<String, Integer> etc = EqualsTestCase.create();
        etc.test(t, s, Exercises::prostyKalkulator);
    }

    @Test
    public void testparzysteNieparzyste() {
        int[][] t = {{1, 2, 3, 5}, {9, 8, 7}};
        int[][] s = {{2, 5, 1, 3}, {8, 9, 7}};

        assertEquals(EqualsTestCase.NOT_EQUAL_SOLUTIONS, t.length, s.length);
        for (int i = 0; i < t.length; i++) {
            assertArrayEquals(Exercises.parzysteNieparzyste(t[i]), s[i]);
        }
    }

    @Test
    public void testKabalistyczneDaty() {
        String[] t = {"info", "miska", "abcdefghij"};
        Integer[] s = {105, 140, 45};

        EqualsTestCase<String, Integer> etc = EqualsTestCase.create();
        etc.test(t, s, Exercises::kabalistyczneDaty);
    }

    @Test
    public void testCezar() {
        Character[] t = {'a', 'x', 'z', 'Z'};
        Character[] s = {'d', 'a', 'c', 'C'};

        final int CEZAR_PRZESUNIECIE = 3;

        EqualsTestCase<Character, Character> etc = EqualsTestCase.create();
        etc.test(t, s, (c) -> {
            return PureFunctions.cezar(c, CEZAR_PRZESUNIECIE);
        });
    }

    @Test
    public void testszyfrGronsfelda() {
        final String[] t = {"abc", "xyz"};
        final String[] s = {"bdf", "yac"};

        final byte[] key = {1, 2, 3, 4};
        assertEquals(EqualsTestCase.NOT_EQUAL_SOLUTIONS, t.length, s.length);

        for (int i = 0; i < t.length; i++) {
            assertEquals(s[i], PureFunctions.szyfrGronsfelda(t[i], key));
        }
    }

    @Test
    public void testZliczanieWyrazow() {
        String[] t = {"Romek ma 2 koty i 3 psy", "2 plus 2 jest rowne 4"};
        int[][] s = {{5, 2}, {3, 3}};

        for (int i = 0; i < t.length; i++) {
            int[] out = Exercises.zliczanieWyrazow(t[i]);
            assertArrayEquals(out, s[i]);
        }
    }
}
