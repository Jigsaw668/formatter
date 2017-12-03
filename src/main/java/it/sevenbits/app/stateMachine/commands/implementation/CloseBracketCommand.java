package it.sevenbits.app.stateMachine.commands.implementation;

import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.stateMachine.commands.CommandException;
import it.sevenbits.app.stateMachine.commands.ICommand;
import it.sevenbits.app.stateMachine.token.IToken;

/**
 * the command for the token is a closing parenthesis, writes a character + a line break.
 */
public class CloseBracketCommand implements ICommand {
    @Override
    public void execute(final IToken token, final IWriter writer) throws CommandException {
        try {
            for (char c : token.getLexeme().toCharArray()) {
                writer.writeChar(c);
            }
            writer.writeChar('\n');
        } catch (WriterException e) {
            throw new CommandException(e);
        }
    }
}
