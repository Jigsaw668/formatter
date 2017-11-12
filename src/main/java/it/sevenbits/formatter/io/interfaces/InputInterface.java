package it.sevenbits.formatter.io.interfaces;

import it.sevenbits.formatter.io.exceptions.InputException;

/**
 * Интерфейс для работы с вводом
 * @author Denis Makarov
 */
public interface InputInterface {
    boolean readNext() throws InputException;
    char getChar() throws InputException;
}
