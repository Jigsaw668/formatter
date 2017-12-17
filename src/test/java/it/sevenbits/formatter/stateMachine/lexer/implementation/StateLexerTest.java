package it.sevenbits.formatter.stateMachine.lexer.implementation;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.stateMachine.state.lexerState.StateLexer;
import it.sevenbits.app.lexer.token.IToken;
import it.sevenbits.app.lexer.token.implementation.Token;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StateLexerTest {

    private IToken token;
    private IToken actualToken;

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



    
    @Test
    public void testDoublequote() throws Exception {
        IReader reader = new StringReader("\"");
        ILexer lexer = new StateLexer(reader);
        IToken expectedToken = new Token("doublequote", "\"");
        compare(lexer, expectedToken);
    }

    @Test
    public void testSlash() throws Exception {
        IReader reader = new StringReader("/");
        ILexer lexer = new StateLexer(reader);
        IToken expectedToken = new Token("slash", "/");
        compare(lexer, expectedToken);
    }

    @Test
    public void testSingleComment() throws Exception {
        IReader reader = new StringReader("//");
        ILexer lexer = new StateLexer(reader);
        IToken expectedToken = new Token("singlecomment", "//");
        compare(lexer, expectedToken);
    }

    @Test
    public void testMultiCommentBegin() throws Exception {
        IReader reader = new StringReader("/*");
        ILexer lexer = new StateLexer(reader);
        IToken expectedToken = new Token("multicommentbegin", "/*");
        compare(lexer, expectedToken);
    }

    @Test
    public void testMultiCommentEnd() throws Exception {
        IReader reader = new StringReader("*/");
        ILexer lexer = new StateLexer(reader);
        IToken expectedToken = new Token("multicommentend", "*/");
        compare(lexer, expectedToken);
    }

    private void compare(ILexer lexer, IToken expectedToken) throws Exception {
        while (lexer.hasMoreTokens()) {
            actualToken = lexer.readToken();
        }
        assertEquals("Wrong token name", expectedToken.getName(), actualToken.getName());
        assertEquals("Wrong lexeme", expectedToken.getLexeme(), actualToken.getLexeme());
    }
}
