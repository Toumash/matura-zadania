package pl.codesharks.maciura;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    public static final String NOT_EQUAL_SOLUTIONS = "Problems != solutions (amount) See test case";

    @Test
    public void testNWW() throws Exception {
        int[][] t = {{1, 2}, {2, 10}, {100, 50}};
        int[] s = {2, 10, 100};

        assertEquals(NOT_EQUAL_SOLUTIONS, t.length, s.length);

        for (int i = 0; i < t.length; i++) {
            assertEquals(s[i], Main.nww(t[i][0], t[i][1]));
        }
    }

    @Test
    public void testCzynniki() throws Exception {
        int[] t = {1, 2, 3, 4, 5, 6, 7};
        int[][] s = {{}, {2}, {3}, {2, 2}, {5}, {2, 3}, {7}};

        assertEquals(NOT_EQUAL_SOLUTIONS, t.length, s.length);

        for (int i = 0; i < t.length; i++) {
            assertArrayEquals(s[i], Main.rozlozNaCzynniki(t[i]));
        }
    }

    @Test
    public void testIsPrime() throws Exception {
        int[] t = {1, 2, 3, 4, 5, 6, 7};
        boolean[] s = {false, true, true, false, true, false, true};

        assertEquals(NOT_EQUAL_SOLUTIONS, t.length, s.length);

        for (int i = 0; i < t.length; i++) {
            assertEquals("Value :" + t[i], s[i], Main.isPrime(t[i]));
        }
    }

    @Test
    public void testFibbonacciRecursive() throws Exception {
        int[] testCases = {1, 2, 3, 4, 5, 6, 7};
        int[] solutions = {1, 1, 2, 3, 5, 8, 13};

        assertEquals(NOT_EQUAL_SOLUTIONS, testCases.length, solutions.length);

        for (int i = 0; i < testCases.length; i++) {
            assertEquals(solutions[i], Main.fibbonacciRecursive(testCases[i]));
        }
    }

    @Test
    public void testFibbonacciIterational() throws Exception {
        int[] testCases = {1, 2, 3, 4, 5, 6, 7};
        int[] solutions = {1, 1, 2, 3, 5, 8, 13};

        assertEquals(NOT_EQUAL_SOLUTIONS, testCases.length, solutions.length);

        for (int i = 0; i < testCases.length; i++) {
            assertEquals(solutions[i], Main.fibbonacciIterational(testCases[i]));
        }
    }

    @Test
    public void testNWDModRecursive() throws Exception {
        assertEquals(2, Main.nwdModRecursive(10, 2));
        assertEquals(5, Main.nwdModRecursive(10, 5));
        assertEquals(25, Main.nwdModRecursive(125, 25));
        assertEquals(6, Main.nwdModRecursive(30, 6));

    }

    @Test
    public void testFactorial() throws Exception {
        int[] t = {1, 2, 3, 4, 5};
        int[] s = {1, 2, 6, 24, 120};

        assertEquals(NOT_EQUAL_SOLUTIONS, t.length, s.length);

        for (int i = 0; i < t.length; i++) {
            assertEquals(s[i], Main.factorialRecursive(t[i]));
        }
    }

    /**
     * @see pl.codesharks.maciura.Main NwdSubtract
     */
    @Test
    public void testNwdSubtract() throws Exception {
        assertEquals(2, Main.nwdSubtract(10, 2));
        assertEquals(5, Main.nwdSubtract(10, 5));
        assertEquals(25, Main.nwdSubtract(125, 25));
        assertEquals(6, Main.nwdSubtract(30, 6));
    }

    @Test
    public void testNwdMod() throws Exception {
        assertEquals(2, Main.nwdMod(10, 2));
        assertEquals(5, Main.nwdMod(10, 5));
        assertEquals(25, Main.nwdMod(125, 25));
        assertEquals(6, Main.nwdMod(30, 6));
    }

    @Test
    public void testCollatz() throws Exception {
        int[] t = {1, 2, 8, 3, 567};
        int[] s = {0, 1, 3, 7, 61};

        assertEquals(NOT_EQUAL_SOLUTIONS, t.length, s.length);

        for (int i = 0; i < t.length; i++) {
            assertEquals(s[i], Main.collatz(t[i]));
        }
    }

    @Test
    public void testFactorialIterational() throws Exception {
        int[] t = {1, 2, 3, 4, 5};
        int[] s = {1, 2, 6, 24, 120};

        assertEquals(NOT_EQUAL_SOLUTIONS, t.length, s.length);

        for (int i = 0; i < t.length; i++) {
            assertEquals(s[i], Main.factorialRecursive(t[i]));
        }
    }

    @Test
    public void testStringMerge() throws Exception {
        String[][] t = {{"a", "bb"}, {"abs", "sfd"}, {"ewr", "w"}, {"wqeqweqweq", "eqweqwe"}};
        String[] s = {"ab", "asbfsd", "ew", "weqqewqewqewqe"};

        assertEquals(NOT_EQUAL_SOLUTIONS, t.length, s.length);

        for (int i = 0; i < t.length; i++) {
            String actual = Main.stringMerge(t[i][0], t[i][1]);
            assertEquals(s[i], actual);
        }
    }

    @Test
    public void testTelefony() throws Exception {
        String[] t = {"ALAMAKOTA", "BRZECZYSZCZYKIEWICZ"};
        String[] s = {"252625682", "2793299792995439429"};

        assertEquals(NOT_EQUAL_SOLUTIONS, t.length, s.length);

        for (int i = 0; i < t.length; i++) {
            String actual = Main.telefony((t[i]));
            assertEquals(s[i], actual);
        }
    }
}
