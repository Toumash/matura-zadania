package pl.codesharks.maciura;

import org.junit.Test;
import pl.codesharks.maciura.util.EqualsTestCase;

@SuppressWarnings("SpellCheckingInspection")
public class ExercisesTest {
    @Test
    public void testTelefony() throws Exception {
        String[] t = {"ALAMAKOTA", "BRZECZYSZCZYKIEWICZ"};
        String[] s = {"252625682", "2793299792995439429"};

        EqualsTestCase<String, String> tc = EqualsTestCase.create();
        tc.test(t, s, Exercises::telefony);
    }

    @Test
    public void testIsPESELValid() throws Exception {
        String[] t = {"44051401458", "12345678901"};
        Boolean[] s = {true, false};
        EqualsTestCase<String, Boolean> tc = EqualsTestCase.create();

        tc.test(t, s, Exercises::isPESELValid);
    }
}
