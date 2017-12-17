package it.sevenbits.formatter.stateMachine.formatter.implementation;

import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.formatter.Formatter;
import it.sevenbits.app.lexer.lexerFactory.LexerFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {

    private IFormatter formatter;
    private StringReader reader;
    private StringWriter writer;

    private String inputString;
    private String expectedString;

    @Before
    public void setUp() throws Exception {
        formatter = new Formatter(new LexerFactory());
        writer = new StringWriter();
    }

    @Test
    public void testInLineIndent() throws Exception {
        inputString = "public void main(){               System.out.println(\"Hello World\");\n}";
        expectedString = "public void main() {\n    System.out.println(\"Hello World\");\n}\n";
        reader = new StringReader(inputString);
        formatter.format(reader, writer);
        assertEquals("Wrong text", expectedString, writer.toString());
    }

    @Test
    public void testFormatted() throws Exception {
        inputString = "public void main() {\n    System.out.println(\"Hello World\");\n}\n";
        expectedString = "public void main() {\n    System.out.println(\"Hello World\");\n}\n";
        reader = new StringReader(inputString);
        formatter.format(reader, writer);
        assertEquals("Wrong text", expectedString, writer.toString());
    }

    @Test
    public void testFormattedVal() throws Exception {
        inputString = "if (x) {return x;\n}";
        expectedString = "if (x) {\n    return x;\n}\n";
        reader = new StringReader(inputString);
        formatter.format(reader, writer);
        assertEquals("Wrong text", expectedString, writer.toString());
    }
}
