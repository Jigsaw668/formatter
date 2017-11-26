package it.sevenbits.formatter;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.LexerException;
import it.sevenbits.app.lexer.implementation.Lexer;
import it.sevenbits.app.token.IToken;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LexerTest {
    @Test
    public void semicolonTest() throws ReaderException, LexerException {
        String inputString = ";";
        String ExpectedString = "semicolon";
        IReader reader = new StringReader(inputString);
        ILexer lexer = new Lexer(reader);
        IToken token;
        lexer.hasMoreTokens();
        token = lexer.readToken();
        System.out.println(token.getName());
        assertEquals(token.getName(), ExpectedString);
    }
    @Test
    public void newLineTest() throws ReaderException, LexerException {
        String inputString = "\r";
        String ExpectedString = "newLine";
        IReader reader = new StringReader(inputString);
        ILexer lexer = new Lexer(reader);
        IToken token;
        lexer.hasMoreTokens();
        token = lexer.readToken();
        System.out.println(token.getName());
        assertEquals(token.getName(), ExpectedString);
    }
    @Test
    public void newLineTestTwo() throws ReaderException, LexerException {
        String inputString = "\n";
        String ExpectedString = "newLine";
        IReader reader = new StringReader(inputString);
        ILexer lexer = new Lexer(reader);
        IToken token;
        lexer.hasMoreTokens();
        token = lexer.readToken();
        System.out.println(token.getName());
        assertEquals(token.getName(), ExpectedString);
    }
    @Test
    public void leftBracketTest() throws ReaderException, LexerException {
        String inputString = "{";
        String ExpectedString = "leftBracket";
        IReader reader = new StringReader(inputString);
        ILexer lexer = new Lexer(reader);
        IToken token;
        lexer.hasMoreTokens();
        token = lexer.readToken();
        System.out.println(token.getName());
        assertEquals(token.getName(), ExpectedString);
    }
    @Test
    public void rightBracketTest() throws ReaderException, LexerException {
        String inputString = "}";
        String ExpectedString = "rightBracket";
        IReader reader = new StringReader(inputString);
        ILexer lexer = new Lexer(reader);
        IToken token;
        lexer.hasMoreTokens();
        token = lexer.readToken();
        System.out.println(token.getName());
        assertEquals(token.getName(), ExpectedString);
    }
    @Test
    public void whitespaceTest() throws ReaderException, LexerException {
        String inputString = " ";
        String ExpectedString = "whiteSpace";
        IReader reader = new StringReader(inputString);
        ILexer lexer = new Lexer(reader);
        IToken token;
        lexer.hasMoreTokens();
        token = lexer.readToken();
        System.out.println(token.getName());
        assertEquals(token.getName(), ExpectedString);
    }
    @Test
    public void otherCharTest() throws ReaderException, LexerException {
        String inputString = "h";
        String ExpectedString = "otherChar";
        IReader reader = new StringReader(inputString);
        ILexer lexer = new Lexer(reader);
        IToken token;
        lexer.hasMoreTokens();
        token = lexer.readToken();
        System.out.println(token.getName());
        assertEquals(token.getName(), ExpectedString);
    }
    @Test
    public void noValidTest() throws ReaderException, LexerException {
        String inputString = "fklf(){}l:;\nfds\r{{{";
        IReader reader = new StringReader(inputString);
        ILexer lexer = new Lexer(reader);
        IToken token;
        while (lexer.hasMoreTokens()) {
            token = lexer.readToken();
            System.out.println(token.getName());
            System.out.println(token.getLexeme());
        }
    }
    @Test
    public void validTest() throws ReaderException, LexerException {
        String inputString = "try (\n" +
                "                FileReader reader = new FileReader(args[0]);\n" +
                "                FileWriter writer = new FileWriter(args[1])\n" +
                "        ) {\n" +
                "            ILexer lexer = new Lexer(reader);\n" +
                "\n" +
                "            formatter.format(lexer, writer);\n" +
                "        }";
        IReader reader = new StringReader(inputString);
        ILexer lexer = new Lexer(reader);
        IToken token;
        while (lexer.hasMoreTokens()) {
            token = lexer.readToken();
            System.out.println(token.getName());
            System.out.println(token.getLexeme());
        }
    }
}