package com.nsc5171.myprojects.exception;

import java.io.IOException;

public class IdentifierResolutionException extends SimulatorApplicationException {
    public IdentifierResolutionException(String message) {
        super(message);
    }

    public IdentifierResolutionException(String message, IOException e) {
        super(message, e);

    }
}
