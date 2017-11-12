package it.sevenbits.formatter.io.interfaces;

import it.sevenbits.formatter.io.exceptions.FormatterException;

public interface InFormatter {

    void format(InputInterface in, OutputInterface out) throws FormatterException;

}
