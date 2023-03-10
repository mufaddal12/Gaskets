package com.fakhri.gaskets.exceptions;

public class ApplicationException extends RuntimeException {
    public ApplicationException(Exception e) {
        super(e);
    }
}
