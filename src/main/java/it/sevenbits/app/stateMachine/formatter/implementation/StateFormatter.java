package it.sevenbits.app.stateMachine.formatter.implementation;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.stateMachine.CommandException;
import it.sevenbits.app.stateMachine.IState;
import it.sevenbits.app.stateMachine.State;
import it.sevenbits.app.stateMachine.formatter.*;
import it.sevenbits.app.stateMachine.lexer.ILexer;
import it.sevenbits.app.stateMachine.lexer.ILexerFactory;
import it.sevenbits.app.stateMachine.lexer.LexerException;
import it.sevenbits.app.stateMachine.token.IToken;

/**
 * Class containing method for formatting code
 */
public class StateFormatter implements IFormatter {

    private ILexerFactory lexerFactory;
    private ICommandRepository commands;
    private IStateTransition transitions;

    /**
     * Basic constructor
     * @param lexerFactory lexer factory
     */
    public StateFormatter(final ILexerFactory lexerFactory) {
        this.lexerFactory = lexerFactory;
        commands = new CommandRepository();
        transitions = new StateTransitions();
    }

    @Override
    public void format(final IReader reader, final IWriter writer) throws FormatterException {
        IContext context = new Context(writer);
        IState state = new State("default");
        ILexer lexer = lexerFactory.createLexer(reader);
        try {
            while (lexer.hasMoreTokens() && state != null) {
                IToken token = lexer.readToken();
                ICommand command = commands.getCommand(state, token);
                command.execute(token, context);
                state = transitions.getNextState(state, token);
            }
        } catch (LexerException | CommandException e) {
            throw new FormatterException(e);
        }
    }
}