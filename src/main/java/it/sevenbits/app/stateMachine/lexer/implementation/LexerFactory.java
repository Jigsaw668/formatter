package it.sevenbits.app.stateMachine.lexer.implementation;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.stateMachine.lexer.ILexer;
import it.sevenbits.app.stateMachine.lexer.ILexerFactory;

/**
 * creates a new lexer
 */
public class LexerFactory implements ILexerFactory {
    @Override
    public ILexer createLexer(final IReader reader) {
        return new Lexer(reader);
    }
}
