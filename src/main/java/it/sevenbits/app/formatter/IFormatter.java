package it.sevenbits.app.formatter;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.writer.IWriter;

/**
 * Interface for formatting the input data stream
 */
public interface IFormatter {
    /**
     * @param reader - input
     * @param writer - output
     * @throws FormatterException - with formatting error
     */
    void format(IReader reader, IWriter writer) throws FormatterException;

}
