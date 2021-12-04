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
        throw new NoAvailablePositionException("No available position.");
    }

    public Car pick(Ticket ticket) {
        if (ticketCarHashMap.containsKey(ticket))
            return ticketCarHashMap.remove(ticket);
        throw new UnrecognizedParkingTicket("Unrecognized packing ticket.");
    }

    public boolean hasSpareLot(){
        return ticketCarHashMap.size() < capacity;
    }

    public int getNumberOfSpareLot() {
        return capacity - ticketCarHashMap.size();
    }
}
