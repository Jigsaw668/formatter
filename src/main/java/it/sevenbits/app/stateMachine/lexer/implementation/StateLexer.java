package it.sevenbits.app.stateMachine.lexer.implementation;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.reader.implementation.StringReader;
import it.sevenbits.app.stateMachine.IState;
import it.sevenbits.app.stateMachine.State;
import it.sevenbits.app.stateMachine.lexer.*;
import it.sevenbits.app.stateMachine.token.IToken;
import it.sevenbits.app.stateMachine.token.implementation.Token;

/**
 * Class for lexer state
 */
public class StateLexer implements ILexer {

    private final IReader reader;

    private ICommandRepository commands;
    private IStateTransition transitions;
    private Context context;

    /**
     * @param reader source file
     */
    public StateLexer(final IReader reader) {
        this.reader = reader;
        commands = new CommandRepository();
        transitions = new StateTransitions();
        context = new Context();
    }

    @Override
    public boolean hasMoreTokens() {
        return context.getPostponeBuffer().length() > 0 || reader.hasMoreChars();
    }

    @Override
    public IToken readToken() throws LexerException {
        context.resetLexeme();
        IState state = new State("default");

        IReader postponeReader = new StringReader(context.getPostponeBuffer());
        while (postponeReader.hasMoreChars() && state != null) {
            state = step(state, postponeReader);
        }
        context.resetPostponeBuffer();

        while (reader.hasMoreChars() && state != null) {
            state = step(state, reader);
        }
        return new Token(context.getTokenName(), context.getTokenLexeme());
    }

    private IState step(final IState state, final IReader stepReader) throws LexerException {
        try {
            char c = stepReader.readChar();
            ICommand command = commands.getCommand(state, c);
            command.execute(c, context);
            return transitions.getNextState(state, c);
        } catch (ReaderException e) {
            throw new LexerException(e);
        }
    }
}
