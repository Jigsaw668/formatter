package it.sevenbits.formatter.stateMachine.formatter.implementation;

import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.stateMachine.state.formatterState.StateFormatter;
import it.sevenbits.app.stateMachine.state.lexerState.StateLexerFactory;
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

    @Test
    public void testString() throws Exception {
        inputString = "\"world\"";
        expectedString = "\"world\"";
        compare(inputString);
    }

    @Test
    public void testCodeBlockWithString() throws Exception {
        inputString = "void main() {str = \"Hello World\";print(str);}";
        expectedString = "void main() {\n    str = \"Hello World\";\n    print(str);\n}\n";
        compare(inputString);
    }

    @Test
    public void testSingleLineComment() throws Exception {
        inputString = "//this {is a} \"comment\"\n";
        expectedString = "//this {is a} \"comment\"\n";
        compare(inputString);
    }

    @Test
    public void testCommentInCode() throws Exception {
        inputString = "//this is a comment\nvoid main() {str = \"Hello World\";print(str);}";
        expectedString = "//this is a comment\nvoid main() {\n    str = \"Hello World\";\n    print(str);\n}\n";
        compare(inputString);
    }

    @Test
    public void testMultilineComment() throws Exception {
        inputString = "/*Hello \n World*/";
        expectedString = "/*Hello \n World*/\n";
        compare(inputString);
    }

    private void compare(String inputString) throws Exception {
        reader = new StringReader(inputString);
        formatter.format(reader, out);
        assertEquals("Wrong text", expectedString, out.toString());
    }
}
