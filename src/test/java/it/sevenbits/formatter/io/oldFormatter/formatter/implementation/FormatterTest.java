package it.sevenbits.formatter.io.oldFormatter.formatter.implementation;

import it.sevenbits.app.oldFormatter.formatter.IFormatter;
import it.sevenbits.app.oldFormatter.formatter.implementation.Formatter;
import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import it.sevenbits.app.oldFormatter.lexer.ILexer;
import it.sevenbits.app.oldFormatter.lexer.implementation.Lexer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatterTest {
    private IFormatter formatter = new Formatter();
    @Test
    public void brackets() throws Exception{
        String ExpectedString = " {\n}\n";
        StringReader reader = new StringReader("{}");
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        assertEquals(ExpectedString, writer.toString());
    }
    @Test
    public void semicolons() throws Exception{
        String ExpectedString = "todo;\ndoto";
        StringReader reader = new StringReader("todo;doto");
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        assertEquals(ExpectedString, writer.toString());
    }
    @Test
    public void notValid() throws Exception{
        String ExpectedString = "todo {\n    todo {\n        todo;\n    }\n}\n";
        StringReader reader = new StringReader("todo{todo{todo;}}");
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        assertEquals(ExpectedString, writer.toString());
    }@Test
    public void valid() throws Exception{
        String ExpectedString = "if(x = 1) {\n    return x;\n}\nelse {\n    return 0;\n}\n";
        StringReader reader = new StringReader("if(x = 1){return x;}else{return 0;}");
        StringWriter writer = new StringWriter();
        ILexer lexer = new Lexer(reader);
        formatter.format(lexer, writer);
        assertEquals(ExpectedString, writer.toString());
    }
}
