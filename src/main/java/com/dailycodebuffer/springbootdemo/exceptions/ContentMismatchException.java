package com.dailycodebuffer.springbootdemo.exceptions;

public class ContentMismatchException extends RuntimeException{

    public ContentMismatchException() {
    }

    public ContentMismatchException(String message) {
        super(message);
    }
}
