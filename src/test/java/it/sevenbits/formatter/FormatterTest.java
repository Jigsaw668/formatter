package it.sevenbits.formatter;

import it.sevenbits.app.formatter.implementation.Formatter;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import it.sevenbits.app.io.reader.implementation.StringReader;

import it.sevenbits.app.lexer.ILexer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {

    private Formatter formatter;

    @Before
    public void init() {
        formatter = new Formatter();
    }

    @Test
    public void firstSimpleTest() throws Exception {
        String InputString = "{}";
        String ExpectedString = "{\n}\n";//

        StringReader in = new StringReader(InputString);
        StringWriter out = new StringWriter();

        formatter.format((ILexer) in, out);

        String OutString = out.toString();
        assertEquals(ExpectedString , OutString);

    }

    @Test
    public void oneLevelTest() throws Exception {
        String InputString = "{test();}";
        String ExpectedString = "{\n    test();\n}\n";

        StringReader in = new StringReader(InputString);
        StringWriter out = new StringWriter();

        formatter.format((ILexer) in, out);

        String OutString = out.toString();
        assertEquals(ExpectedString , OutString);
    }

    @Test
    public void SecondLevelTest() throws Exception {
        String InputString = "{test();{}}";
        String ExpectedString = "{\n    test();\n    {\n    }\n}\n";

        StringReader in = new StringReader(InputString);
        StringWriter out = new StringWriter();

        formatter.format((ILexer) in, out);

        String OutString = out.toString();
        assertEquals(ExpectedString , OutString);
    }

    @Test
    public void notValidInputTest() throws Exception {
        String InputString = "{test();{}}";
        String ExpectedString = "{\n    test();\n    {\n    }\n}\n";

        StringReader in = new StringReader(InputString);
        StringWriter out = new StringWriter();

        formatter.format((ILexer) in, out);

        String OutString = out.toString();
        assertEquals(ExpectedString , OutString);
    }
}
