package it.sevenbits.app.stateMachine.lexer;

/**
 * Context interface for lexer
 */
public interface IContext {

    /**
     * @param name token name
     */
    void setTokenName(String name);

    /**
     * @param ch character to append
     */
    void appendLexeme(char ch);

    /**
     * @param ch character
     */
    void appendPostpone(char ch);

    /**
     * Reset postpone buffer
     */
    void resetPostponeBuffer();

    /**
     * Reset lexeme
     */
    void resetLexeme();
}
