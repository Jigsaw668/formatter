package it.sevenbits.app.oldFormatter.formatter;

import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.oldFormatter.lexer.ILexer;

/**
 * Interface for formatting the input data stream
 */
public interface IFormatter {
    /**
     * @param lexer - input
     * @param writer - output
     * @throws FormatterException - with formatting error
     */
    void format(ILexer lexer, IWriter writer) throws FormatterException;

}
