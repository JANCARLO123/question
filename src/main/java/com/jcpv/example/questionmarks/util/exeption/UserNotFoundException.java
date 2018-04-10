package com.jcpv.example.questionmarks.util.exeption;

/**
 * Created by jancarlo on 23/03/18.
 */
public class UserNotFoundException extends  RuntimeException{

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final Throwable cause) {
        super(cause);
    }
}
