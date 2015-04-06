package pl.codesharks.matura.util;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class EqualsTestCase<T, S> {
    public static final String NOT_EQUAL_SOLUTIONS = "Problems count not equals solutions count";

    public static <T1, T2> EqualsTestCase<T1, T2> create() {
        return new EqualsTestCase<>();
    }

    public void test(T[] t, S[] s, TestCommand<T, S> c) {
        assertEquals(NOT_EQUAL_SOLUTIONS, t.length, s.length);
        for (int i = 0; i < t.length; i++) {
            S actual = c.execute(t[i]);
            assertEquals(s[i], actual);
        }
    }

    public void test(ArrayList<T> t, ArrayList<S> s, TestCommand<T, S> c) {
        assertEquals(NOT_EQUAL_SOLUTIONS, t.size(), s.size());
        for (int i = 0, length = t.size(); i < length; i++) {
            S actual = c.execute(t.get(i));
            assertEquals(s.get(i), actual);
        }
    }
}
