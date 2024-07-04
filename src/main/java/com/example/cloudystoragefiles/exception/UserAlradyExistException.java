package com.example.cloudystoragefiles.exception;

public class UserAlradyExistException extends RuntimeException {


    public UserAlradyExistException() {
        super();
    }

    public UserAlradyExistException(String message) {
        super(message);
    }

    public UserAlradyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlradyExistException(Throwable cause) {
        super(cause);
    }


}
