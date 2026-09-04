package org.anudip.rrs.exception;

@SuppressWarnings("serial")
public class BookingNotFoundException extends Exception {

    public BookingNotFoundException(String message) {
        super(message);
    }

}