package org.zaykin.teamwork.exception;

/**
 * Created by DHM on 6/29/2017.
 */
public class ParameterFormatException extends Exception{

    public ParameterFormatException() {
        super();
    }
    public ParameterFormatException(String message) {
        super(message);
    }
    public ParameterFormatException(String message, Throwable cause) {
        super(message, cause);
    }
    public ParameterFormatException(Throwable cause) {
        super(cause);
    }

}
