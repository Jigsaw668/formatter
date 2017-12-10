package it.sevenbits.formatter.stateMachine.formatter.implementation;

import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import it.sevenbits.app.stateMachine.formatter.IFormatter;
import it.sevenbits.app.stateMachine.formatter.implementation.StateFormatter;
import it.sevenbits.app.stateMachine.lexer.implementation.StateLexerFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateFormatterTest {

    private IFormatter formatter;
    private StringReader reader;
    private StringWriter out;

    private String inputString;
    private String expectedString;

    @Before
    public void setUp() {
        formatter = new StateFormatter(new StateLexerFactory());
        out = new StringWriter();
    }

    @Test
    public void testFormatter() throws Exception {
        inputString = "void main() {print(hello);}hello()";
        expectedString = "void main() {\n    print(hello);\n}\nhello()";;
        reader = new StringReader(inputString);
        formatter.format(reader, out);
        assertEquals("Wrong text", expectedString, out.toString());
    }

    @Test
    public void testFormattedCode() throws Exception {
        inputString = "hello main() {\n print(hello);\n print(hello);\n }\nhello()";
        expectedString = "hello main() {\n    print(hello);\n    print(hello);\n}\nhello()";;
        reader = new StringReader(inputString);
        formatter.format(reader, out);
        assertEquals("Wrong text", expectedString, out.toString());
    }

    @Test
    public void testMultiLevelIndent() throws Exception {
        inputString = "void main() {print(hello) {print(hello) {print(hello);}}}";
        expectedString = "void main() {\n    print(hello) {\n        print(hello) {\n            print(hello);\n        }\n    }\n}\n";;
        reader = new StringReader(inputString);
        formatter.format(reader, out);
        assertEquals("Wrong text", expectedString, out.toString());
    }

    @Test
    public void testSimpleFormat() throws Exception {
        inputString = "a;\n   b";
        expectedString = "a;\nb";
        reader = new StringReader(inputString);
        formatter.format(reader, out);
        assertEquals("Wrong text", expectedString, out.toString());
    }
}
