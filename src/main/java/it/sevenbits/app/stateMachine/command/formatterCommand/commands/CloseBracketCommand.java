package it.sevenbits.app.stateMachine.command.formatterCommand.commands;


import it.sevenbits.app.stateMachine.command.CommandException;
import it.sevenbits.app.stateMachine.context.ContextException;
import it.sevenbits.app.stateMachine.command.formatterCommand.ICommand;
import it.sevenbits.app.stateMachine.context.formatterContext.IContext;
import it.sevenbits.app.lexer.token.IToken;

/**
 * the command for the token is a closing parenthesis, writes a character + a line break.
 */

public class CloseBracketCommand implements ICommand {

    @Override
    public void execute(final IToken token, final IContext context) throws CommandException {
        try {
            context.decrementIndent();
            context.writeIndent();
            context.writeLexeme(token.getLexeme());
            context.writeNewLine();
        } catch (ContextException e) {
            throw new CommandException(e);
        }
    }

}
