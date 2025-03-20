package Exceptions;

/**
 * Custom exception class for handling index out of bounds errors.
 */
public class IndexOutOfBoundsException extends RuntimeException {
    /**
     * Constructs a new IndexOutOfBoundsException with the specified detail message.
     * @param message the detail message.
     */
    public IndexOutOfBoundsException(String message) {
        super(message);

    }
}