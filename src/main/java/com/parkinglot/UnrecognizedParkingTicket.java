package com.parkinglot;

public class UnrecognizedParkingTicket extends RuntimeException{
    public UnrecognizedParkingTicket(String message) {
        super(message);
    }
}
