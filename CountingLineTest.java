import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountingLineTest {

    @Test
    public void testCountLine(){
        CountingLines counter = new CountingLines();
        int expected = 1;
        String codeToRead = "System.out.println(\"This is a line of Java Code\")";
        int actual = counter.parseJavaCode(codeToRead);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountMultipleLines(){
        CountingLines counter = new CountingLines();
        int expected = 2;
        String codeToRead = "if (2 == 2){\n" +
                "System.out.println(\"Anotha One\");\n" +
                "}";
        int actual = counter.parseJavaCode(codeToRead);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleLineComment(){
        CountingLines counter = new CountingLines();
        int expected = 0;
        String codeToRead = "// THIS is a comment";
        int actual = counter.parseJavaCode(codeToRead);
        assertEquals(expected, actual);
    }

    @Test
    public void testCommentBlock(){
        CountingLines counter = new CountingLines();
        int expected = 0;
        String codeToRead = "/* THIS is a comment block\n" +
                "it is multiple lines long\n" +
                "three, in fact! */";
        int actual = counter.parseJavaCode(codeToRead);
        assertEquals(expected, actual);
    }

    @Test
    public void testInLineComment(){
        CountingLines counter = new CountingLines();
        int expected = 1;
        String codeToRead = "System/*WHO IN THEIR RIGHT MIND WOULD DO THIS*/.out.println(\"This is a line of Java code\")";
        int actual = counter.parseJavaCode(codeToRead);
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteSpace(){
        CountingLines counter = new CountingLines();
        int expected = 0;
        String codeToRead = "\n" +
                "\n" +
                "\n";
        int actual = counter.parseJavaCode(codeToRead);
        assertEquals(expected, actual);
    }
}
