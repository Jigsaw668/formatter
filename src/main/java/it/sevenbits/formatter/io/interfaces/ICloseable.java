package it.sevenbits.formatter.io.interfaces;

import it.sevenbits.formatter.io.exceptions.CloseException;

/**
 * A ICloseable is a source or destination of data that can be closed.
 * The close method is invoked to release resources that the object is holding (such as open files).
 */
public interface ICloseable extends AutoCloseable {

    @Override
    void close() throws CloseException;
}
