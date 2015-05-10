package pl.codesharks.matura;

import org.junit.Test;
import pl.codesharks.matura.util.Collections;
import pl.codesharks.matura.util.EqualsTestCase;
import pl.codesharks.matura.util.Pair;
import pl.codesharks.matura.util.TestCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("SpellCheckingInspection")
public class PureFuncionsTest {

    @Test
    public void testNWW() throws Exception {
        Integer[][] t = {{1, 2}, {2, 10}, {100, 50}};
        Integer[] s = {2, 10, 100};

        EqualsTestCase<Pair<Integer, Integer>, Integer> testCase = EqualsTestCase.create();
        TestCommand<Pair<Integer, Integer>, Integer> command = (p) -> PureFunctions.nww(p.getKey(), p.getValue());

        testCase.test(Collections.toPairArrayList(t), Collections.toArrayList(s), command);
    }

    @Test
    public void testCzynniki() throws Exception {
        Integer[] t = {1, 2, 3, 4, 5, 6, 7};
        Integer[][] s = {{}, {2}, {3}, {2, 2}, {5}, {2, 3}, {7}};

        EqualsTestCase<Integer, ArrayList<Integer>> testCase = EqualsTestCase.create();
        TestCommand<Integer, ArrayList<Integer>> command = PureFunctions::rozlozNaCzynniki;

        testCase.test(Collections.toArrayList(t), Collections.toArrayList(s), command);
    }

    @Test
    public void testIsPrime() throws Exception {
        Integer[] t = {1, 2, 3, 4, 5, 6, 7};
        Boolean[] s = {false, true, true, false, true, false, true};

        EqualsTestCase<Integer, Boolean> tc = EqualsTestCase.create();

        tc.test(t, s, PureFunctions::isPrimeNumber);
    }

    @Test
    public void testFibbonacciRecursive() throws Exception {
        Integer[] t = Data.tFibbonacci;
        Integer[] s = Data.sFibbonacci;

        EqualsTestCase<Integer, Integer> testCase = EqualsTestCase.create();
        TestCommand<Integer, Integer> command = PureFunctions::fibbonacciRecursive;

        testCase.test(t, s, command);
    }

    @Test
    public void testFibbonacciIterational() throws Exception {
        Integer[] t = Data.tFibbonacci;
        Integer[] s = Data.sFibbonacci;

        EqualsTestCase<Integer, Integer> testCase = EqualsTestCase.create();

        testCase.test(t, s, PureFunctions::fibbonacciIterational);
    }

    @Test
    public void testNWDModRecursive() throws Exception {
        assertEquals(2, PureFunctions.nwdModRecursive(10, 2));
        assertEquals(5, PureFunctions.nwdModRecursive(10, 5));
        assertEquals(25, PureFunctions.nwdModRecursive(125, 25));
        assertEquals(6, PureFunctions.nwdModRecursive(30, 6));

    }

    @Test
    public void testFactorial() throws Exception {
        Integer[] t = {1, 2, 3, 4, 5};
        Integer[] s = {1, 2, 6, 24, 120};

        EqualsTestCase<Integer, Integer> tc = EqualsTestCase.create();

        tc.test(t, s, PureFunctions::factorialRecursive);
    }

    @Test
    public void testNwdSubtract() throws Exception {
        Integer[][] t = Data.tNwd;
        Integer[] s = Data.sNwd;

        EqualsTestCase<Pair<Integer, Integer>, Integer> tc = EqualsTestCase.create();
        TestCommand<Pair<Integer, Integer>, Integer> command = (p) -> PureFunctions.nwdMod(p.getKey(), p.getValue());

        tc.test(Collections.toPairArrayList(t), Collections.toArrayList(s), command);
    }

    @Test
    public void testNwdMod() throws Exception {
        Integer[][] t = Data.tNwd;
        Integer[] s = Data.sNwd;

        EqualsTestCase<Pair<Integer, Integer>, Integer> tc = EqualsTestCase.create();
        TestCommand<Pair<Integer, Integer>, Integer> command = (p) -> PureFunctions.nwdMod(p.getKey(), p.getValue());

        tc.test(Collections.toPairArrayList(t), Collections.toArrayList(s), command);
    }

    @Test
    public void testCollatz() throws Exception {
        Integer[] t = {1, 2, 8, 3, 567};
        Integer[] s = {0, 1, 3, 7, 61};

        EqualsTestCase<Integer, Integer> tc = EqualsTestCase.create();

        tc.test(t, s, PureFunctions::collatz);
    }

    @Test
    public void testFactorialIterational() throws Exception {
        Integer[] t = {1, 2, 3, 4, 5};
        Integer[] s = {1, 2, 6, 24, 120};

        EqualsTestCase<Integer, Integer> tc = EqualsTestCase.create();

        tc.test(t, s, PureFunctions::factorialRecursive);
    }

    @Test
    public void testStringMerge() throws Exception {
        String[][] t = {{"a", "bb"}, {"abs", "sfd"}, {"ewr", "w"}, {"wqeqweqweq", "eqweqwe"}};
        String[] s = {"ab", "asbfsd", "ew", "weqqewqewqewqe"};

        ArrayList<Pair<String, String>> arr = Collections.toPairArrayList(t);

        EqualsTestCase<Pair<String, String>, String> tc = EqualsTestCase.create();
        TestCommand<Pair<String, String>, String> command = (x) -> PureFunctions.stringMerge(x.getKey(), x.getValue());

        tc.test(arr, Collections.toArrayList(s), command);
    }

    @Test
    public void testConvertToInt() throws Exception {
        Character[] t = {'6', '9'};
        Integer[] s = {6, 9};

        EqualsTestCase<Character, Integer> tc = EqualsTestCase.create();

        tc.test(t, s, PureFunctions::convertToInt);
    }

    @Test
    public void testIsPalindrome() throws Exception {
        String[] t = Data.tPalindrome;
        Boolean[] s = Data.sPalindrome;

        EqualsTestCase<String, Boolean> tc = EqualsTestCase.create();

        tc.test(t, s, PureFunctions::isPalindrome);
    }

    @Test
    public void testIsPalindromeFaster() throws Exception {
        String[] t = Data.tPalindrome;
        Boolean[] s = Data.sPalindrome;

        EqualsTestCase<String, Boolean> tc = EqualsTestCase.create();

        tc.test(t, s, PureFunctions::isPalindrome);
    }

    @Test
    public void testInsertionSort() throws Exception {
        //generating random data
        final int[][] test = new int[100][100];
        Random rand = new Random(System.nanoTime());
        int[] t = new int[100];
        for (int j = 0; j < test.length; j++) {
            for (int i = 0; i < t.length; i++) {
                t[i] = rand.nextInt();
            }
            test[j] = t;
        }
        //computing expected values
        final int[][] expected = new int[test.length][test[0].length];
        int[] s;
        for (int i = 0; i < test.length; i++) {
            s = test[i].clone();
            Arrays.sort(s);
            expected[i] = s;
        }

        //computing real output
        final int[][] actual = new int[test.length][test[0].length];
        int[] result;
        for (int i = 0; i < actual.length; i++) {
            result = PureFunctions.insertionSort(test[i]);
            actual[i] = result;
        }

        //check fo equality
        for (int i = 0; i < test.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }

    }

    protected static class Data {
        public static final String[] tPalindrome = {"KONIK", "ANNA", "OKO", "ZXZ"};
        public static final Boolean[] sPalindrome = {false, true, true, true};

        public static final Integer[][] tNwd = {{10, 2}, {10, 5}, {125, 25}, {30, 6}};
        public static final Integer[] sNwd = {2, 5, 25, 6};

        public static final Integer[] tFibbonacci = {1, 2, 3, 4, 5, 6, 7};
        public static final Integer[] sFibbonacci = {1, 1, 2, 3, 5, 8, 13};

    }
}
