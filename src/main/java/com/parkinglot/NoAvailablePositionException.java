package com.parkinglot;

public class NoAvailablePositionException extends RuntimeException{
    public NoAvailablePositionException(String message) {
        super(message);
    }
}
