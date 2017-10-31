package contain;

import contain.interfaces.*;

import java.io.*;
import java.lang.String;

public class Formatter {
    /**
     * @throws
     */
    public static void format(Input input, Output output) throws IOException {

        int level = 0;

        String skip = "\n\t";
        String newline = "{};";

        char prev = 0;

        while (input.readNext()) {

            if (input.getChar() == '{') {
                level++;
            }

            if (input.getChar() == '}') {
                level--;
            }

            if ("{};".indexOf(prev) != -1) {

                for (int i = 0; i < level * 4; i++) {
                    output.WriteChar(' ');
                }
            }

            prev = input.getChar();

            if (skip.indexOf(prev) != -1) {
                continue;
            }

            output.WriteChar(input.getChar());

            if (newline.indexOf(input.getChar()) != -1) {
                output.WriteChar("\n".charAt(0));
            }
        }
    }
}
