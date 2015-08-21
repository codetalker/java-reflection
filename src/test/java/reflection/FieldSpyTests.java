package reflection;

import org.junit.Test;

/**
 * Created by insight-ks on 2015-08-21.
 */
public class FieldSpyTests {
    @Test
    public void testFieldSpy() throws Exception {
        FieldSpy.spy("reflection.FieldSpy", "b");
        FieldSpy.spy("reflection.FieldSpy", "name");
        FieldSpy.spy("reflection.FieldSpy", "list");
        FieldSpy.spy("reflection.FieldSpy", "val");
    }
}
