package it.sevenbits.app.stateMachine.lexer.implementation;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.stateMachine.lexer.ILexer;
import it.sevenbits.app.stateMachine.lexer.ILexerFactory;

/**
 * Implementation of lexer factory
 */
public class StateLexerFactory implements ILexerFactory {

    @Override
    public ILexer createLexer(final IReader reader) {
        return new StateLexer(reader);
    }
}