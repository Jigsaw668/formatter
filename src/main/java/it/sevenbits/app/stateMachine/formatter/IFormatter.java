package it.sevenbits.app.stateMachine.formatter;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.writer.IWriter;

/**
 * Interface for formatter
 */
public interface IFormatter {
    /**
     * Method for formatting code
     * @param reader source
     * @param out output
     * @throws FormatterException when can't format code
     */
    void format(IReader reader, IWriter out) throws FormatterException;
}
