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

    public Boolean isValidTicket(Ticket ticket){
        return ticketCarHashMap.containsKey(ticket);
    }

    public Car pick(Ticket ticket) {
        if (isValidTicket(ticket))
            return ticketCarHashMap.remove(ticket);
        throw new UnrecognizedParkingTicketException("Unrecognized parking ticket.");
    }

    public boolean hasSpareLot(){
        return ticketCarHashMap.size() < capacity;
    }

    public int getNumberOfSpareLot() {
        return capacity == 0? 0 : capacity - ticketCarHashMap.size();
    }

    public float getAvailableLotRate(){
        return capacity == 0? 0 : (float)this.getNumberOfSpareLot()/this.capacity;
    }
}
