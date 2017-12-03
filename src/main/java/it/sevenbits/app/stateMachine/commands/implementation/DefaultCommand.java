package it.sevenbits.app.stateMachine.commands.implementation;

import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.stateMachine.commands.CommandException;
import it.sevenbits.app.stateMachine.commands.ICommand;
import it.sevenbits.app.stateMachine.token.IToken;

/**
 * command for all characters, writes a character
 */
public class DefaultCommand implements ICommand {
    @Override
    public void execute(final IToken token, final IWriter writer) throws CommandException {
        try {
            for (char c : token.getLexeme().toCharArray()) {
                writer.writeChar(c);
            }
        } catch (WriterException we) {
            throw new CommandException(we);
        }
    }
}
