package it.sevenbits.app.stateMachine.lexer;

import it.sevenbits.app.io.reader.IReader;

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
