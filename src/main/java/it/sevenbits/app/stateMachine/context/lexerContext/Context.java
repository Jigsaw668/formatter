package it.sevenbits.app.stateMachine.context.lexerContext;

/**
 *
 */
public class Context implements IContext {

    private String tokenName;
    private StringBuilder tokenLexeme;
    private StringBuilder postponeBuffer;

    /**
     * Basic constructor
     */
    public Context() {
        tokenLexeme = new StringBuilder();
        postponeBuffer = new StringBuilder();
    }

    @Override
    public void setTokenName(final String name) {
        tokenName = name;
    }

    @Override
    public void appendLexeme(final char ch) {
        tokenLexeme.append(ch);
    }

    @Override
    public void appendPostpone(final char ch) {
        postponeBuffer.append(ch);
    }

    public String getTokenName() {
        return tokenName;
    }

    public String getTokenLexeme() {
        return tokenLexeme.toString();
    }

    public String getPostponeBuffer() {
        return postponeBuffer.toString();
    }

    @Override
    public void resetPostponeBuffer() {
        postponeBuffer = new StringBuilder();
    }

    @Override
    public void resetLexeme() {
        tokenLexeme = new StringBuilder();
    }
}
