package reflection;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by insight-ks on 2015-08-21.
 */
public class FieldModifierSpyTest {
    @Test
    public void testFieldModifierSpy() throws Exception {
        FieldModifierSpy.spy("reflection.FieldModifierSpy", "volatile");
        FieldModifierSpy.spy("reflection.Spy", "public");
        FieldModifierSpy.spy("reflection.FieldModifierSpy$Inner", "final");
        FieldModifierSpy.spy("reflection.Spy", "private", "static", "final");
    }
}