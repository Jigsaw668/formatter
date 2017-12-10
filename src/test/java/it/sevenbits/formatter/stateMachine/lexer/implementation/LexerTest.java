package it.sevenbits.formatter.stateMachine.lexer.implementation;

import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.stateMachine.lexer.ILexer;
import it.sevenbits.app.stateMachine.lexer.LexerException;
import it.sevenbits.app.stateMachine.lexer.implementation.Lexer;
import it.sevenbits.app.stateMachine.token.IToken;
import it.sevenbits.app.stateMachine.token.implementation.Token;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LexerTest {

    private ILexer lexer;
    private StringReader stringReader;
    private IToken actualToken;
    private IToken expectedToken;

    private String inputString;

    @Test
    public void testSemicolon() throws LexerException {
        inputString = ";";
        stringReader = new StringReader(inputString);
        lexer = new Lexer(stringReader);
        expectedToken = new Token("semicolon", ";");
        while (lexer.hasMoreTokens()) {
            actualToken = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), actualToken.getName());
        assertEquals("Wrong token lexeme", expectedToken.getLexeme(), actualToken.getLexeme());
    }

    @Test
    public void testOpenBracket() throws LexerException {
        inputString = "{";
        stringReader = new StringReader(inputString);
        lexer = new Lexer(stringReader);
        expectedToken = new Token("openBracket", "{");
        while (lexer.hasMoreTokens()) {
            actualToken = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), actualToken.getName());
        assertEquals("Wrong token lexeme", expectedToken.getLexeme(), actualToken.getLexeme());
    }

    @Test
    public void testCloseBracket() throws LexerException {
        inputString = "}";
        stringReader = new StringReader(inputString);
        lexer = new Lexer(stringReader);
        expectedToken = new Token("closeBracket", "}");
        while (lexer.hasMoreTokens()) {
            actualToken = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), actualToken.getName());
        assertEquals("Wrong token lexeme", expectedToken.getLexeme(), actualToken.getLexeme());
    }

    @Test
    public void testNewLine() throws LexerException {
        inputString = "\n";
        stringReader = new StringReader(inputString);
        lexer = new Lexer(stringReader);
        expectedToken = new Token("newLine", "\n");
        while (lexer.hasMoreTokens()) {
            actualToken = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), actualToken.getName());
        assertEquals("Wrong token lexeme", expectedToken.getLexeme(), actualToken.getLexeme());
    }

    @Test
    public void testWhitespace() throws LexerException {
        inputString = " ";
        stringReader = new StringReader(inputString);
        lexer = new Lexer(stringReader);
        expectedToken = new Token("whitespace", " ");
        while (lexer.hasMoreTokens()) {
            actualToken = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), actualToken.getName());
        assertEquals("Wrong token lexeme", expectedToken.getLexeme(), actualToken.getLexeme());
    }

    @Test
    public void testSingleChar() throws LexerException {
        inputString = "a";
        stringReader = new StringReader(inputString);
        lexer = new Lexer(stringReader);
        expectedToken = new Token("singleChar", "a");
        while (lexer.hasMoreTokens()) {
            actualToken = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), actualToken.getName());
        assertEquals("Wrong token lexeme", expectedToken.getLexeme(), actualToken.getLexeme());
    }
}
