package contain.io.ioSystem;

import contain.exceptions.OutputException;
import contain.interfaces.ICloseable;
import contain.interfaces.OutputInterface;

import java.io.OutputStreamWriter;

/**
 * @author Denis Makarov
 */
public class OutputStreamWrite implements OutputInterface, ICloseable {

    private OutputStreamWriter out;

    /**
     *
     */
    public OutputStreamWrite() {
        out = new OutputStreamWriter(System.out);
    }

    @Override
    public void writeChar(final char ch) throws OutputException {

        try {
            out.write(ch);
        } catch (Exception e) {
            throw new OutputException("Some error with write char", e);
        }
    }

    @Override
    public void close() throws OutputException {

        try {
            out.close();
        } catch (Exception e) {
            throw new OutputException("Can not close System.in", e);
        }
    }
}
