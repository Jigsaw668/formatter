package it.sevenbits.app.stateMachine.commands;

import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.stateMachine.token.IToken;

/**
 * command interface
 */
public interface ICommand {

    /**
     * Execute command for formatter
     * @param writer output
     * @param token token
     * @throws CommandException no command found
     */
    void execute(IToken token, IWriter writer) throws CommandException;
}
