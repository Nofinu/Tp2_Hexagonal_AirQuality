package org.example.exception;

public class DateFormatNotFitException extends Exception {
    public DateFormatNotFitException() {
        super("Date Format Not Fit Format : dd-MM-yyyy HH:mm:ss");
    }
}
