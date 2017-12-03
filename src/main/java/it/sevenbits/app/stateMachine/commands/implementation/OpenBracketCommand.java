package it.sevenbits.app.stateMachine.commands.implementation;

import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.stateMachine.commands.CommandException;
import it.sevenbits.app.stateMachine.commands.ICommand;
import it.sevenbits.app.stateMachine.token.IToken;

/**
 * the command for the token opens the parenthesis, writes the line break, indent, and the character itself
 */
public class OpenBracketCommand implements ICommand {

    @Override
    public void execute(final IToken token, final IWriter writer) throws CommandException {
        try {
            writer.writeChar('\n');
            final int indent = 4;
            for (int i = 0; i < indent; i++) {
                writer.writeChar(' ');
            }

            for (char c : token.getLexeme().toCharArray()) {
                writer.writeChar(c);
            }
        } catch (WriterException we) {
            throw new CommandException(we);
        }
    }
}
