package reflection;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by insight-ks on 2015-08-21.
 */
public class BookChangerTest {

    @Test
    public void testChangeBookWithoutGetterAndSetter() throws Exception {
        Book book = new Book();
        BookChanger.change(book);
    }
}
