package com.nsc5171.myprojects.exception;

import java.io.IOException;

public class SimulatorApplicationException extends Exception {
    public SimulatorApplicationException(String message) {
        super(message);
    }

    public SimulatorApplicationException(String message, IOException e) {
        super(message,e);
    }
}
