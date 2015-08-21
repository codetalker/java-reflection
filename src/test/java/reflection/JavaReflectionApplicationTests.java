package reflection;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertNotNull;

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

        Field f = System.class.getField("out");
        Class c = f.getDeclaringClass();
        assertAndPrintClassName(c);

        assertAndPrintClassName(MyClass.o.getClass().getEnclosingClass());

    }

    @Test
    public void testSpyClass() throws Exception {
        ClassDeclarationSpy.spy("reflection.JavaReflectionApplication");
        ClassDeclarationSpy.spy("java.util.concurrent.ConcurrentNavigableMap");
        ClassDeclarationSpy.spy("java.io.InterruptedIOException");
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

class MyClass {
    static Object o = new Object() {
        public void m() {}
    };
    static Class c = o.getClass().getEnclosingClass();
}
