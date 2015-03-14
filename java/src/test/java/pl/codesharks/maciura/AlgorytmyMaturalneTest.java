package pl.codesharks.maciura;

import org.junit.Test;
import pl.codesharks.maciura.util.CollectionsUtils;
import pl.codesharks.maciura.util.Pair;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
public class AlgorytmyMaturalneTest {

    public static final String NOT_EQUAL_SOLUTIONS = "Problems != solutions (amount) See test case";

    @Test
    public void testNWW() throws Exception {
        int[][] t = {{1, 2}, {2, 10}, {100, 50}};
        int[] s = {2, 10, 100};

        assertEquals(NOT_EQUAL_SOLUTIONS, t.length, s.length);

        for (int i = 0; i < t.length; i++) {
            assertEquals(s[i], AlgorytmyMaturalne.nww(t[i][0], t[i][1]));
        }
    }

    @Test
    public void testCzynniki() throws Exception {
        int[] t = {1, 2, 3, 4, 5, 6, 7};
        int[][] s = {{}, {2}, {3}, {2, 2}, {5}, {2, 3}, {7}};

        assertEquals(NOT_EQUAL_SOLUTIONS, t.length, s.length);

        for (int i = 0; i < t.length; i++) {
            assertArrayEquals(s[i], AlgorytmyMaturalne.rozlozNaCzynniki(t[i]));
        }
    }

    @Test
    public void testIsPrime() throws Exception {
        Integer[] t = {1, 2, 3, 4, 5, 6, 7};
        Boolean[] s = {false, true, true, false, true, false, true};

        EqualsTestCase<Integer, Boolean> tc = EqualsTestCase.get();
        tc.test(t, s, new Command<Integer, Boolean>() {
            @Override
            public Boolean execute(Integer x) {
                return AlgorytmyMaturalne.isPrimeNumber(x);
            }
        });
    }

    @Test
    public void testFibbonacciRecursive() throws Exception {
        Integer[] t = {1, 2, 3, 4, 5, 6, 7};
        Integer[] s = {1, 1, 2, 3, 5, 8, 13};

        EqualsTestCase<Integer, Integer> tc = EqualsTestCase.get();
        tc.test(t, s, new Command<Integer, Integer>() {
            @Override
            public Integer execute(Integer x) {
                return AlgorytmyMaturalne.fibbonacciRecursive(x);
            }
        });
    }

    @Test
    public void testFibbonacciIterational() throws Exception {
        Integer[] t = {1, 2, 3, 4, 5, 6, 7};
        Integer[] s = {1, 1, 2, 3, 5, 8, 13};

        EqualsTestCase<Integer, Integer> tc = EqualsTestCase.get();
        tc.test(t, s, new Command<Integer, Integer>() {
            @Override
            public Integer execute(Integer x) {
                return AlgorytmyMaturalne.fibbonacciIterational(x);
            }
        });
    }

    @Test
    public void testNWDModRecursive() throws Exception {
        assertEquals(2, AlgorytmyMaturalne.nwdModRecursive(10, 2));
        assertEquals(5, AlgorytmyMaturalne.nwdModRecursive(10, 5));
        assertEquals(25, AlgorytmyMaturalne.nwdModRecursive(125, 25));
        assertEquals(6, AlgorytmyMaturalne.nwdModRecursive(30, 6));

    }

    @Test
    public void testFactorial() throws Exception {
        Integer[] t = {1, 2, 3, 4, 5};
        Integer[] s = {1, 2, 6, 24, 120};

        EqualsTestCase<Integer, Integer> tc = EqualsTestCase.get();
        tc.test(t, s, new Command<Integer, Integer>() {
            @Override
            public Integer execute(Integer x) {
                return AlgorytmyMaturalne.factorialRecursive(x);
            }
        });
    }

    /**
     * @see AlgorytmyMaturalne NwdSubtract
     */
    @Test
    public void testNwdSubtract() throws Exception {
        assertEquals(2, AlgorytmyMaturalne.nwdSubtract(10, 2));
        assertEquals(5, AlgorytmyMaturalne.nwdSubtract(10, 5));
        assertEquals(25, AlgorytmyMaturalne.nwdSubtract(125, 25));
        assertEquals(6, AlgorytmyMaturalne.nwdSubtract(30, 6));
    }

    @Test
    public void testNwdMod() throws Exception {
        assertEquals(2, AlgorytmyMaturalne.nwdMod(10, 2));
        assertEquals(5, AlgorytmyMaturalne.nwdMod(10, 5));
        assertEquals(25, AlgorytmyMaturalne.nwdMod(125, 25));
        assertEquals(6, AlgorytmyMaturalne.nwdMod(30, 6));
    }

    @Test
    public void testCollatz() throws Exception {
        Integer[] t = {1, 2, 8, 3, 567};
        Integer[] s = {0, 1, 3, 7, 61};

        EqualsTestCase<Integer, Integer> tc = EqualsTestCase.get();

        tc.test(t, s, new Command<Integer, Integer>() {
            @Override
            public Integer execute(Integer x) {
                return AlgorytmyMaturalne.collatz(x);
            }
        });
    }

    @Test
    public void testFactorialIterational() throws Exception {
        Integer[] t = {1, 2, 3, 4, 5};
        Integer[] s = {1, 2, 6, 24, 120};

        EqualsTestCase<Integer, Integer> tc = EqualsTestCase.get();
        tc.test(t, s, new Command<Integer, Integer>() {
            @Override
            public Integer execute(Integer x) {
                return AlgorytmyMaturalne.factorialRecursive(x);
            }
        });
    }

    @Test
    public void testStringMerge() throws Exception {
        String[][] t = {{"a", "bb"}, {"abs", "sfd"}, {"ewr", "w"}, {"wqeqweqweq", "eqweqwe"}};
        String[] s = {"ab", "asbfsd", "ew", "weqqewqewqewqe"};

        ArrayList<Pair<String, String>> arr = CollectionsUtils.toArrayList(t);

        EqualsTestCase<Pair<String, String>, String> tc = EqualsTestCase.get();
        tc.test(arr, CollectionsUtils.toArrayList(s), new Command<Pair<String, String>, String>() {
            @Override
            public String execute(Pair<String, String> x) {
                return AlgorytmyMaturalne.stringMerge(x.getKey(), x.getValue());
            }
        });
    }


    @Test
    public void testTelefony() throws Exception {
        String[] t = {"ALAMAKOTA", "BRZECZYSZCZYKIEWICZ"};
        String[] s = {"252625682", "2793299792995439429"};

        EqualsTestCase<String, String> tc = EqualsTestCase.get();
        tc.test(t, s, new Command<String, String>() {
            @Override
            public String execute(String x) {
                return AlgorytmyMaturalne.telefony(x);
            }
        });
    }

    @Test
    public void testIsPESELValid() throws Exception {
        String[] t = {"44051401458", "12345678901"};
        Boolean[] s = {true, false};
        EqualsTestCase<String, Boolean> tc = EqualsTestCase.get();

        tc.test(t, s, new Command<String, Boolean>() {
            @Override
            public Boolean execute(String x) {
                return AlgorytmyMaturalne.isPESELValid(x);
            }
        });
    }

    @Test
    public void testConvertToInt() throws Exception {
        Character[] t = {'6', '9'};
        Integer[] s = {6, 9};

        EqualsTestCase<Character, Integer> tc = EqualsTestCase.get();

        tc.test(t, s, new Command<Character, Integer>() {
            @Override
            public Integer execute(Character x) {
                return AlgorytmyMaturalne.convertToInt(x);
            }
        });
    }

    static interface Command<T1, T2> {
        T2 execute(T1 x);
    }

    static class EqualsTestCase<T, S> {
        public static final String NOT_EQUAL_SOLUTIONS = "Problems != solutions (amount) See test case";

        public static <T1, T2> EqualsTestCase<T1, T2> get() {
            return new EqualsTestCase<>();
        }

        public void test(T[] t, S[] s, Command<T, S> c) {
            assertEquals(NOT_EQUAL_SOLUTIONS, t.length, s.length);
            for (int i = 0; i < t.length; i++) {
                S actual = c.execute(t[i]);
                assertEquals(s[i], actual);
            }
        }

        public void test(ArrayList<T> t, ArrayList<S> s, Command<T, S> c) {
            assertEquals(NOT_EQUAL_SOLUTIONS, t.size(), s.size());
            for (int i = 0, length = t.size(); i < length; i++) {
                S actual = c.execute(t.get(i));
                assertEquals(s.get(i), actual);
            }
        }
    }

}
