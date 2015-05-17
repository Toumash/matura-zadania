package pl.codesharks.matura;

import org.junit.Test;
import pl.codesharks.matura.Rzymskie.LiczbaRzymska;
import pl.codesharks.matura.util.EqualsTestCase;

import static org.junit.Assert.assertEquals;

public class LiczbaRzymskaTest {

    @Test
    public void testIntFromString() {
        String[] t = {"MCMXC", "XIV", "XI", "IX", "CCCLXXIX"};
        Integer[] s = {1990, 14, 11, 9, 379};

        EqualsTestCase<String, Integer> etc = EqualsTestCase.create();
        etc.test(t, s, (str) -> {
            return LiczbaRzymska.valueOf(str).getValue();
        });
    }

    @Test
    public void testStringFromInt() {
        Integer[] t = {1990, 14, 11, 9, 379};
        String[] s = {"MCMXC", "XIV", "XI", "IX", "CCCLXXIX"};

        EqualsTestCase<Integer, String> etc = EqualsTestCase.create();
        etc.test(t, s, (x) -> {
            return LiczbaRzymska.valueOf(x).toString();
        });
    }

    @Test
    public void testStringAddition() {
        LiczbaRzymska a = LiczbaRzymska.valueOf("CXXIII");
        LiczbaRzymska b = LiczbaRzymska.valueOf("CCLVI");
        LiczbaRzymska wynik = a.add(b);
        assertEquals("CCCLXXIX", wynik.toString());
    }

    @Test
    public void testStringToString() {
        String[] t = {"MCMXC", "XIV", "XI", "IX", "CCCLXXIX"};
        String[] s = {"MCMXC", "XIV", "XI", "IX", "CCCLXXIX"};

        EqualsTestCase<String, String> etc = EqualsTestCase.create();
        etc.test(t, s, (x) -> {
            return LiczbaRzymska.valueOf(x).toString();
        });
    }
}