package pl.codesharks.matura;

import org.junit.Test;
import pl.codesharks.matura.util.Collections;
import pl.codesharks.matura.util.EqualsTestCase;
import pl.codesharks.matura.util.Pair;
import pl.codesharks.matura.util.TestCommand;

import java.util.ArrayList;

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
        Integer[] t = {1, 2, 3, 4, 5, 6, 7};
        Integer[] s = {1, 1, 2, 3, 5, 8, 13};

        EqualsTestCase<Integer, Integer> testCase = EqualsTestCase.create();
        TestCommand<Integer, Integer> command = PureFunctions::fibbonacciRecursive;

        testCase.test(t, s, command);
    }

    @Test
    public void testFibbonacciIterational() throws Exception {
        Integer[] t = {1, 2, 3, 4, 5, 6, 7};
        Integer[] s = {1, 1, 2, 3, 5, 8, 13};

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
        assertEquals(2, PureFunctions.nwdSubtract(10, 2));
        assertEquals(5, PureFunctions.nwdSubtract(10, 5));
        assertEquals(25, PureFunctions.nwdSubtract(125, 25));
        assertEquals(6, PureFunctions.nwdSubtract(30, 6));
    }

    @Test
    public void testNwdMod() throws Exception {
        assertEquals(2, PureFunctions.nwdMod(10, 2));
        assertEquals(5, PureFunctions.nwdMod(10, 5));
        assertEquals(25, PureFunctions.nwdMod(125, 25));
        assertEquals(6, PureFunctions.nwdMod(30, 6));
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

        tc.test(arr, Collections.toArrayList(s), x -> {
            return PureFunctions.stringMerge(x.getKey(), x.getValue());
        });
    }

    @Test
    public void testConvertToInt() throws Exception {
        Character[] t = {'6', '9'};
        Integer[] s = {6, 9};

        EqualsTestCase<Character, Integer> tc = EqualsTestCase.create();

        tc.test(t, s, PureFunctions::convertToInt);
    }
}
