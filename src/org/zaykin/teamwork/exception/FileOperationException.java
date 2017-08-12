package org.zaykin.teamwork.exception;

import java.io.IOException;

/**
 * Created by DHM on 6/4/2017.
 */
public class FileOperationException extends IOException{

    public FileOperationException() {
        super();
    }
    public FileOperationException(String message) {
        super(message);
    }
    public FileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
    public FileOperationException(Throwable cause) {
        super(cause);
    }

}
