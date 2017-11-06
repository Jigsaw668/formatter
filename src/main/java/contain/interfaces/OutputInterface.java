package contain.interfaces;


import contain.exceptions.OutputException;

/**
 * @author Denis Makarov
 */
public interface OutputInterface {
    void writeChar(char ch) throws OutputException;
}
