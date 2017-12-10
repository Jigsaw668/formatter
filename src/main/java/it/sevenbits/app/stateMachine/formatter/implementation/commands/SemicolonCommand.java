package it.sevenbits.app.stateMachine.formatter.implementation.commands;


import it.sevenbits.app.stateMachine.CommandException;
import it.sevenbits.app.stateMachine.ContextException;
import it.sevenbits.app.stateMachine.formatter.ICommand;
import it.sevenbits.app.stateMachine.formatter.IContext;
import it.sevenbits.app.stateMachine.token.IToken;

/**
 * the command for the token is a semicolon, writes a character + a line break.
 */
public class SemicolonCommand implements ICommand {


    @Override
    public void execute(final IToken token, final IContext context) throws CommandException {
        try {
            context.writeLexeme(token.getLexeme());
            context.writeNewLine();
        } catch (ContextException e) {
            throw new CommandException(e);
        }
    }
}
