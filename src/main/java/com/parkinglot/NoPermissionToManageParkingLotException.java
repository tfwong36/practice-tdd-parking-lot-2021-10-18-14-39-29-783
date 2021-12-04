package com.parkinglot;

public class NoPermissionToManageParkingLotException extends RuntimeException{
    public NoPermissionToManageParkingLotException(String message) {
        super(message);
    }
}
