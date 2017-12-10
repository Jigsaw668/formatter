package it.sevenbits.app.stateMachine.formatter.implementation.commands;


import it.sevenbits.app.stateMachine.CommandException;
import it.sevenbits.app.stateMachine.ContextException;
import it.sevenbits.app.stateMachine.formatter.ICommand;
import it.sevenbits.app.stateMachine.formatter.IContext;
import it.sevenbits.app.stateMachine.token.IToken;

/**
 * the command for the token opens the parenthesis, writes the line break, indent, and the character itself
 */
public class OpenBracketCommand implements ICommand {

    @Override
    public void execute(final IToken token, final IContext context) throws CommandException {
        try {
            context.writeLexeme(token.getLexeme());
            context.incrementIndent();
            context.writeNewLine();
        } catch (ContextException e) {
            throw new CommandException(e);
        }
    }
}
