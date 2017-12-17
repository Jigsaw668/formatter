package it.sevenbits.app.stateMachine.state.formatterState;

import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.stateMachine.command.CommandException;
import it.sevenbits.app.stateMachine.context.formatterContext.Context;
import it.sevenbits.app.stateMachine.context.formatterContext.IContext;
import it.sevenbits.app.stateMachine.state.IState;
import it.sevenbits.app.stateMachine.state.State;
import it.sevenbits.app.stateMachine.command.formatterCommand.CommandRepository;
import it.sevenbits.app.stateMachine.command.formatterCommand.ICommand;
import it.sevenbits.app.stateMachine.command.formatterCommand.ICommandRepository;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.lexerFactory.ILexerFactory;
import it.sevenbits.app.lexer.LexerException;
import it.sevenbits.app.lexer.token.IToken;
import it.sevenbits.app.stateMachine.state.formatterState.IStateTransition;
import it.sevenbits.app.stateMachine.state.formatterState.StateTransitions;

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