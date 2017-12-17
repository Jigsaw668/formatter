package it.sevenbits.app.stateMachine.command.formatterCommand.commands;


import it.sevenbits.app.stateMachine.command.CommandException;
import it.sevenbits.app.stateMachine.context.ContextException;
import it.sevenbits.app.stateMachine.command.formatterCommand.ICommand;
import it.sevenbits.app.stateMachine.context.formatterContext.IContext;
import it.sevenbits.app.lexer.token.IToken;

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
