package com.practice.mockito.exception.handling;

public class DataBaseReadException extends RuntimeException {
    public DataBaseReadException(String message) {
        super(message);
    }
}
