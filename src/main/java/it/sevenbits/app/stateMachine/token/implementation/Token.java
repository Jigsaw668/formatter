package it.sevenbits.app.stateMachine.token.implementation;

import it.sevenbits.app.stateMachine.token.IToken;

/**
 * Implementation of IToken interface
 */
public class Token implements IToken {
    private String name;
    private String lexeme;

    /**
     * @param name - token's name
     * @param lexeme -  token's lexeme
     */
    public Token(final String name, final String lexeme) {
        this.name = name;
        this.lexeme = lexeme;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLexeme() {
        return lexeme;
    }
}