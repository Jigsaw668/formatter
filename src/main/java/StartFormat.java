import contain.Formatter;
import contain.io.ioSystem.InputStreamRead;
import contain.io.ioSystem.OutputStreamWrite;

/**
 * @author Denis Makarov
 */
public class StartFormat {
    public static void main(final String[] args) {

        try {
            InputStreamRead in = new InputStreamRead();
            OutputStreamWrite out = new OutputStreamWrite();
            Formatter.format(in, out);
            out.close();
            in.close();
            System.out.println("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
