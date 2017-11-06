package contain.exceptions;

/**
 * @author Denis Makarov
 */
public class InputException extends Exception {

    public InputException(final String var1, final Throwable var2) {
        super(var1, var2);
    }

    public InputException(final Throwable e) {
        super(e);
    }
}
