package it.sevenbits.app.stateMachine.commands.implementation;

import it.sevenbits.app.stateMachine.commands.ICommand;
import it.sevenbits.app.stateMachine.commands.ICommandRepository;
import it.sevenbits.app.stateMachine.state.IState;
import it.sevenbits.app.stateMachine.state.implementation.State;
import it.sevenbits.app.stateMachine.token.IToken;

import java.util.HashMap;

/**
 * command repository
 */
public class CommandRepository implements ICommandRepository {

    private HashMap<IState, HashMap<String, ICommand>> commands;

    /**
     * Basic constructor
     */
    public CommandRepository() {
        commands = new HashMap<>();

        HashMap<String, ICommand> defaultCommands = new HashMap<>();
        defaultCommands.put("any", new DefaultCommand());
        defaultCommands.put("{", new DefaultBracketCommand());
        defaultCommands.put("}", new CloseBracketCommand());
        defaultCommands.put(";", new SemicolonCommand());

        HashMap<String, ICommand> openBracketCommand = new HashMap<>();
        openBracketCommand.put("any", new OpenBracketCommand());

        HashMap<String, ICommand> semicolonCommand = new HashMap<>();
        semicolonCommand.put("any", new SemicolonCommand());

        commands.put(new State("Default"), defaultCommands);
        commands.put(new State("OpenBracket"), openBracketCommand);
        commands.put(new State("Semicolon"), semicolonCommand);
    }

    @Override
    public ICommand getCommand(final IState state, final IToken token) {
        HashMap<String, ICommand> stateCommands = commands.get(state);
        if (stateCommands.containsKey(token.getLexeme())) {
            return stateCommands.get(token.getLexeme());
        } else {
            return stateCommands.get("any");
        }
    }
}
