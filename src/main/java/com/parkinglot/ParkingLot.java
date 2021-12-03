package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    private final HashMap<Ticket, Car> ticketCarHashMap = new HashMap<>();
    private int capacity = 10;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {

    }

    public Ticket park(Car car) {
        if (hasSpareLot()){
            Ticket ticket = new Ticket();
            ticketCarHashMap.put(ticket, car);
            return ticket;
        }
        return null;
    }

    public Car pick(Ticket ticket) {
        return ticketCarHashMap.get(ticket);
    }

    private boolean hasSpareLot(){
        return ticketCarHashMap.size() < capacity;
    }
}
