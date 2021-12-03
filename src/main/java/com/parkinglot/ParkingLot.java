package com.parkinglot;

import java.util.HashMap;

public class ParkingLot {
    HashMap<Ticket, Car> ticketCarHashMap = new HashMap<>();

    public ParkingLot(int i) {
    }

    public ParkingLot() {

    }

    public Ticket park(Car car) {
        Ticket ticket = new Ticket();
        ticketCarHashMap.put(ticket, car);
        return ticket;
    }
}
