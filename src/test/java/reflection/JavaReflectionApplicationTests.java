package reflection;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = JavaReflectionApplication.class)
public class JavaReflectionApplicationTests {

    enum  E { A, B}

    @Test
    public void testGetClass() throws Exception {
        Class c = "foo".getClass();
        printClassName(c);

        c = E.A.getClass();
        printClassName(c);

        byte[] bytes = new byte[1024];
        c = bytes.getClass();
        printClassName(c);

        Set<String> s = new HashSet<String>();
        c = s.getClass();
        printClassName(c);
    }

    @Test
    public void testClassSyntax() throws Exception {
        boolean b;
//        Class c = b.getClass(); //compile-time error
        Class c = boolean.class;
        printClassName(c);

        c = java.io.PrintStream.class;
        printClassName(c);

        c = int[][][].class;
        printClassName(c);
    }

    @Test
    public void testforName() throws Exception {
        Class c = Class.forName("reflection.JavaReflectionApplication");
        printClassName(c);

        Class cDoubleArray = Class.forName("[D"); // double[].class
        printClassName(cDoubleArray);

        Class cStringArray = Class.forName("[[Ljava.lang.String;"); // String[][].class
        printClassName(cStringArray);
    }

    @Test
    public void testTypeField() throws Exception {

        Class c = Double.TYPE;
        printClassName(c);

        c = Void.TYPE;
        printClassName(c);
    }

    private void printClassName(Class c) {
        System.out.println(c.getName());
    }

}

