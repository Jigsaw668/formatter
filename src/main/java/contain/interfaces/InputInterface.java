package contain.interfaces;

import contain.exceptions.InputException;

/**
 * @author Denis Makarov
 */
public interface InputInterface {
    boolean readNext() throws InputException;
    char getChar();
}
