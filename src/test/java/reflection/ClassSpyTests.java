package reflection;

import org.junit.Test;

/**
 * Created by insight-ks on 2015-08-21.
 */
public class ClassSpyTests {
    @Test
    public void testClassSpy() throws Exception {
        ClassSpy.spy("java.lang.ClassCastException", "CONSTRUCTOR");
        ClassSpy.spy("reflection.ClassMember", "FIELD", "METHOD");
    }


}
