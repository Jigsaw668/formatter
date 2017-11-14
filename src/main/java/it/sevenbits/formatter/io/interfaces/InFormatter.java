package it.sevenbits.formatter.io.interfaces;

import it.sevenbits.formatter.io.exceptions.FormatterException;

/**
 * Interface for formatting the input data stream
 */
public interface InFormatter {
    /**
     * @param in - input
     * @param out - output
     * @throws FormatterException - with formatting error
     */
    void format(InputInterface in, OutputInterface out) throws FormatterException;

}
