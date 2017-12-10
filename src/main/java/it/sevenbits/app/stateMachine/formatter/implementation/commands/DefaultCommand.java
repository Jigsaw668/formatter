package it.sevenbits.app.stateMachine.formatter.implementation.commands;


import it.sevenbits.app.stateMachine.CommandException;
import it.sevenbits.app.stateMachine.ContextException;
import it.sevenbits.app.stateMachine.formatter.ICommand;
import it.sevenbits.app.stateMachine.formatter.IContext;
import it.sevenbits.app.stateMachine.token.IToken;

/**
 * command for all characters, writes a character
 */
public class DefaultCommand implements ICommand {

    @Override
    public void execute(final IToken token, final IContext context) throws CommandException {
        try {
            context.writeLexeme(token.getLexeme());
        } catch (ContextException e) {
            throw new CommandException(e);
        }
    }
}
