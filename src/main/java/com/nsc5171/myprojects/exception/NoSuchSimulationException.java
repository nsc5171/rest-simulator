package com.nsc5171.myprojects.exception;

public class NoSuchSimulationException extends SimulatorApplicationException {
    public NoSuchSimulationException(String message) {
        super(message);
    }

    public NoSuchSimulationException(String message, Exception e) {
        super(message, e);
    }
}
