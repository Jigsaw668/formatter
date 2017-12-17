package it.sevenbits.app.stateMachine.command.formatterCommand.commands;

import it.sevenbits.app.lexer.token.IToken;
import it.sevenbits.app.stateMachine.command.CommandException;
import it.sevenbits.app.stateMachine.command.formatterCommand.ICommand;
import it.sevenbits.app.stateMachine.context.ContextException;
import it.sevenbits.app.stateMachine.context.formatterContext.IContext;

/**
 *
 */
public class MultiLineCommendEndCommand implements ICommand {
    @Override
    public void execute(final IToken token, final IContext context) throws CommandException {
        try {
            context.writeLexeme(token.getLexeme());
            context.writeNewLine();
            context.writeIndent();
        } catch (ContextException ce) {
            throw new CommandException(ce);
        }
    }
}
