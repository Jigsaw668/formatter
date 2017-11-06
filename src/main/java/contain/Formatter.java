package contain;

import contain.exceptions.FormatterException;
import contain.interfaces.InputInterface;
import contain.interfaces.OutputInterface;

/**
 * @author Denis Makarov
 */
public class Formatter {
    public static void format(final InputInterface in, final OutputInterface out) throws FormatterException {

        try {
            int level = 0;

            String skip = "\n\t";
            String newline = "{};";

            char prev = 0;

            while (in.readNext()) {

                if (in.getChar() == '{') {
                    level++;
                }

                if (in.getChar() == '}') {
                    level--;
                }

                if ("{};".indexOf(prev) != -1) {
                    for (int i = 0; i < level * 4; i++) {
                        out.writeChar(' ');
                    }
                }

                prev = in.getChar();

                if (skip.indexOf(prev) != -1) {
                    continue;
                }

                out.writeChar(in.getChar());

                if (newline.indexOf(in.getChar()) != -1) {
                    out.writeChar("\n".charAt(0));
                }
            }
        } catch (Exception e) {
            throw new FormatterException(e);
        }
    }
}
