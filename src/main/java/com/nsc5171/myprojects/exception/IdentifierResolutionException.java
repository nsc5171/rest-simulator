package com.nsc5171.myprojects.exception;

public class IdentifierResolutionException extends SimulatorApplicationException {
    public IdentifierResolutionException(String message) {
        super(message);
    }

    public IdentifierResolutionException(String message, Exception e) {
        super(message, e);

    }
}
