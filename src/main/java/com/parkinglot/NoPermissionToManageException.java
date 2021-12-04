package com.parkinglot;

public class NoPermissionToManageException extends RuntimeException{
    public NoPermissionToManageException(String message) {
        super(message);
    }
}
