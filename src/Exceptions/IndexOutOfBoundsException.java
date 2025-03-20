/*
Authors: Anthony Dayoub, Angel Lopez, Amanda McNesby, and Jennifer Alicea
Course: CSCI 234 - Intro to Software Engineering
 */
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