package com.Mighty.Performance.exception;

public class TeamNotFoundException extends RuntimeException {
    public TeamNotFoundException(String message) {
        super(message);
    }
}
