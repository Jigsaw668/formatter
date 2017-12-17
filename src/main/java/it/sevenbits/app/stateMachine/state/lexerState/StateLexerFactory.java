package it.sevenbits.app.stateMachine.state.lexerState;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.lexerFactory.ILexerFactory;

/**
 * Implementation of lexer factory
 */
public class StateLexerFactory implements ILexerFactory {

    @Override
    public ILexer createLexer(final IReader reader) {
        return new StateLexer(reader);
    }
}