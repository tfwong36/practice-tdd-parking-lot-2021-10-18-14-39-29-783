package com.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ParkingBoy {
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        //to be Override by different types of ParkingBoy
        return new Ticket();
    }

    public Car pick(Ticket ticket) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(e -> e.isValidTicket(ticket))
                .findFirst()
                .orElse(null);
        if (parkingLot != null)
            return parkingLot.pick(ticket);
        throw new UnrecognizedParkingTicketException("Unrecognized parking ticket.");
    }

    protected void addParkingLot(ParkingLot parkingLot) {
        this.parkingLots = new ArrayList<>(parkingLots);
        this.parkingLots.add(parkingLot);
    }
}
