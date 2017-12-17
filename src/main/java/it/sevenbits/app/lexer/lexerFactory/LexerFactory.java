package it.sevenbits.app.lexer.lexerFactory;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.implementation.Lexer;

/**
 * creates a new lexer
 */
public class LexerFactory implements ILexerFactory {
    @Override
    public ILexer createLexer(final IReader reader) {
        return new Lexer(reader);
    }
}
