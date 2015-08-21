package reflection;

import junit.framework.Assert;
import org.junit.Test;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.Assert.*;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = JavaReflectionApplication.class)
public class JavaReflectionApplicationTests {

    enum  E { A, B}

    @Test
    public void testGetClass() throws Exception {
        Class c = "foo".getClass();
        assertAndPrintClassName(c);

        c = E.A.getClass();
        assertAndPrintClassName(c);

        byte[] bytes = new byte[1024];
        c = bytes.getClass();
        assertAndPrintClassName(c);

        Set<String> s = new HashSet<String>();
        c = s.getClass();
        assertAndPrintClassName(c);
    }

    @Test
    public void testClassSyntax() throws Exception {
        boolean b;
//        Class c = b.getClass(); //compile-time error
        Class c = boolean.class;
        assertAndPrintClassName(c);

        c = java.io.PrintStream.class;
        assertAndPrintClassName(c);

        c = int[][][].class;
        assertAndPrintClassName(c);
    }

    @Test
    public void testforName() throws Exception {
        Class c = Class.forName("reflection.JavaReflectionApplication");
        assertAndPrintClassName(c);

        Class cDoubleArray = Class.forName("[D"); // double[].class
        assertAndPrintClassName(cDoubleArray);

        Class cStringArray = Class.forName("[[Ljava.lang.String;"); // String[][].class
        assertAndPrintClassName(cStringArray);
    }

    @Test
    public void testTypeField() throws Exception {

        Class c = Double.TYPE;
        assertAndPrintClassName(c);

        c = Void.TYPE;
        assertAndPrintClassName(c);
    }

    @Test
    public void testMethodThatReturnClasses() throws Exception {

        Class superClass = javax.swing.JButton.class.getSuperclass();
        assertAndPrintClassName(superClass);

        Class<?>[] classes = Character.class.getClasses();
        assertAndPrintClassName(classes);

        classes = Character.class.getDeclaredClasses();
        assertAndPrintClassName(classes);
    }

    private void assertAndPrintClassName(Class<?>[] classes) {
        assertNotNull(classes);
        Arrays.asList(classes).forEach(c -> System.out.println(c));
    }

    private void assertAndPrintClassName(Class c) {
        assertNotNull(c);
        System.out.println(c.getName());
    }

}

