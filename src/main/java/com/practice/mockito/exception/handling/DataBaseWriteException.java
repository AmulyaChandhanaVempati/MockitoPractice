package com.practice.mockito.exception.handling;

public class DataBaseWriteException extends RuntimeException {
    public DataBaseWriteException(String message) {
        super(message);
    }
}
