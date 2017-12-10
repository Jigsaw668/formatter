package it.sevenbits.app.stateMachine.formatter;

import it.sevenbits.app.stateMachine.ContextException;

/**
 * Interface for context
 */
public interface IContext {

    /**
     * Indent
     */
    int INDENT = 4;

    /**
     * @param lexeme lexeme
     * @throws ContextException exception
     */
    void writeLexeme(String lexeme) throws ContextException;

    /**
     * @throws ContextException exception
     */
    void writeNewLine() throws ContextException;

    /**
     * @throws ContextException exception
     */
    void writeIndent() throws ContextException;

    /**
     * Increment indent
     */
    void incrementIndent();

    /**
     * Decrement indent
     */
    void decrementIndent();
}
