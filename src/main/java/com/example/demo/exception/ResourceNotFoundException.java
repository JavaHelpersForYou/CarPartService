package com.example.demo.exception;

public class ResourceNotFoundException extends RuntimeException{

    public static final String RESOURCE_NOT_FOUND = "Resource not found";

    public ResourceNotFoundException() {
        super(RESOURCE_NOT_FOUND);
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
