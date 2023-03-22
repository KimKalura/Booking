package com.spring.booking.exceptions;

//@ResponseStatus (value= HttpStatus.NOT_FOUND)
public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(String message) {
        super(message);
    }
}
