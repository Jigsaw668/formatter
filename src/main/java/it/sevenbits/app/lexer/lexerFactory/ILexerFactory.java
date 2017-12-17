package it.sevenbits.app.lexer.lexerFactory;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.lexer.ILexer;

/**
 * interfaces for LexerFactory
 */
public interface ILexerFactory {

    /**
     * Creates lexer from factory
     * @param reader source
     * @return lexer
     */
    ILexer createLexer(IReader reader);
}
