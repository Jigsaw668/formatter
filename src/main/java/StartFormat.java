import it.sevenbits.formatter.io.Formatter;
import it.sevenbits.formatter.io.interfaces.ICloseable;
import it.sevenbits.formatter.io.interfaces.InputInterface;
import it.sevenbits.formatter.io.interfaces.OutputInterface;
import it.sevenbits.formatter.io.ioFiles.InFile;
import it.sevenbits.formatter.io.ioFiles.OutFile;
import it.sevenbits.formatter.io.ioStream.InputStreamRead;
import it.sevenbits.formatter.io.ioStream.OutputStreamWrite;
import org.apache.commons.cli.*;

/**
 * Starts reading, editing and writing to a file
 */
public class StartFormat {
    /**
     *
     * @param args - main argument
     * @throws Exception - catches all exceptions
     */
    public static void main(final String[] args) throws Exception {

        Options options = new Options();

        Option input = new Option("i", "input", true, "input file path");
        options.addOption(input);

        Option output = new Option("o", "output", true, "output file path");
        options.addOption(output);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("", options);
            System.exit(1);
            return;
        }

        String inputFilePath = cmd.getOptionValue("input");
        String outputFilePath = cmd.getOptionValue("output");

        InputInterface in;
        OutputInterface out;

        if (inputFilePath == null || inputFilePath.isEmpty()) {
            in = new InputStreamRead();
        } else {
            in = new InFile(inputFilePath);
        }

        if (outputFilePath == null || outputFilePath.isEmpty()) {
            out = new OutputStreamWrite();
        } else {
            out = new OutFile(outputFilePath);
        }

        Formatter f = new Formatter();
        f.format(in , out);

        ((ICloseable) out).close();
    }
}
