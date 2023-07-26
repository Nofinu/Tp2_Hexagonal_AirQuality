package org.example.exception;

import java.text.ParseException;

public class DateFormatNotFit extends Exception {
    public DateFormatNotFit() {
        super("Date Format Not Fit Format : dd-MM-yyyy HH:mm:ss");
    }
}
