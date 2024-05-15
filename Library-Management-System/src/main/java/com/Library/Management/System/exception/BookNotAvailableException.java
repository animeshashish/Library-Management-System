package com.Library.Management.System.exception;

public class BookNotAvailableException extends RuntimeException{
    public BookNotAvailableException(String message) { // constructor
        super(message);
    }
}
