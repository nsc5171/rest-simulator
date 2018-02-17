package com.nsc5171.myprojects.exception;

import java.io.IOException;

public class NoSuchSimulationException extends SimulatorApplicationException {
    public NoSuchSimulationException(String message) {
        super(message);
    }

    public NoSuchSimulationException(String message, IOException e) {
        super(message, e);
    }
}
