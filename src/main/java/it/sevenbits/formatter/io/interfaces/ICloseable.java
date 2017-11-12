package it.sevenbits.formatter.io.interfaces;

import it.sevenbits.formatter.io.exceptions.CloseException;

/**
 * Завершает поток и освобождает ресурсы
 */
public interface ICloseable extends AutoCloseable {
    @Override
    void close() throws CloseException;
}
