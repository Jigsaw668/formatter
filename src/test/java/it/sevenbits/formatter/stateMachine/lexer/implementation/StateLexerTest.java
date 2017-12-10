package it.sevenbits.formatter.stateMachine.lexer.implementation;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.stateMachine.lexer.ILexer;
import it.sevenbits.app.stateMachine.lexer.implementation.StateLexer;
import it.sevenbits.app.stateMachine.token.IToken;
import it.sevenbits.app.stateMachine.token.implementation.Token;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateLexerTest {

    private IToken token;

    @Test
    public void testChar() throws Exception {
        IReader reader = new StringReader("a");
        ILexer lexer = new StateLexer(reader);
        IToken expectedToken = new Token("char", "a");
        while (lexer.hasMoreTokens()) {
            token = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), token.getName());
        assertEquals("Wrong lexeme", expectedToken.getLexeme(), token.getLexeme());
    }

    @Test
    public void testOpenBracket() throws Exception {
        IReader reader = new StringReader("{");
        ILexer lexer = new StateLexer(reader);
        IToken expectedToken = new Token("openbracket", "{");
        while (lexer.hasMoreTokens()) {
            token = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), token.getName());
        assertEquals("Wrong lexeme", expectedToken.getLexeme(), token.getLexeme());
    }

    @Test
    public void testCloseBracket() throws Exception {
        IReader reader = new StringReader("}");
        ILexer lexer = new StateLexer(reader);
        IToken expectedToken = new Token("closebracket", "}");
        while (lexer.hasMoreTokens()) {
            token = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), token.getName());
        assertEquals("Wrong lexeme", expectedToken.getLexeme(), token.getLexeme());
    }

    @Test
    public void testSemicolon() throws Exception {
        IReader reader = new StringReader(";");
        ILexer lexer = new StateLexer(reader);
        IToken expectedToken = new Token("semicolon", ";");
        while (lexer.hasMoreTokens()) {
            token = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), token.getName());
        assertEquals("Wrong lexeme", expectedToken.getLexeme(), token.getLexeme());
    }

    @Test
    public void testNewLine() throws Exception {
        IReader reader = new StringReader("\n");
        ILexer lexer = new StateLexer(reader);
        IToken expectedToken = new Token("newline", "\n");
        while (lexer.hasMoreTokens()) {
            token = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), token.getName());
        assertEquals("Wrong lexeme", expectedToken.getLexeme(), token.getLexeme());
    }

    @Test
    public void testSpace() throws Exception {
        IReader reader = new StringReader(" ");
        ILexer lexer = new StateLexer(reader);
        IToken expectedToken = new Token("space", " ");
        while (lexer.hasMoreTokens()) {
            token = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), token.getName());
        assertEquals("Wrong lexeme", expectedToken.getLexeme(), token.getLexeme());
    }

    @Test
    public void testMultipleSpace() throws Exception {
        IReader reader = new StringReader("   ");
        ILexer lexer = new StateLexer(reader);
        IToken expectedToken = new Token("space", "   ");
        while (lexer.hasMoreTokens()) {
            token = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), token.getName());
        assertEquals("Wrong lexeme", expectedToken.getLexeme(), token.getLexeme());
    }
}
