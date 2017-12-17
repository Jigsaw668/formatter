package it.sevenbits.app.lexer.token.implementation;

import it.sevenbits.app.lexer.token.IToken;

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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Token token = (Token) o;

        return name != null ? name.equals(token.name) : token.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }
}