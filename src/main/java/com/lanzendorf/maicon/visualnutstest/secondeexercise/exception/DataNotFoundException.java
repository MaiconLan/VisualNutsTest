package com.lanzendorf.maicon.visualnutstest.secondeexercise.exception;

public class DataNotFoundException extends RuntimeException {

    public DataNotFoundException() {
        super("Data Not Found in class path");
    }

    public DataNotFoundException(Throwable cause) {
        super(cause);
    }
}
