package com.nsc5171.myprojects.exception;

public class SimulatorApplicationException extends Exception {
    public SimulatorApplicationException(String message) {
        super(message);
    }

    public SimulatorApplicationException(String message, Exception e) {
        super(message, e);
    }
}
