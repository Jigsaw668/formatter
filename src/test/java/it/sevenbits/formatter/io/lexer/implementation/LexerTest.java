package it.sevenbits.formatter.io.lexer.implementation;

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
        assertEquals(token.getName(), ExpectedString);
    }
}