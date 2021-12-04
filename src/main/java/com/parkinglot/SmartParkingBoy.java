package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {
    private final List<ParkingLot> parkingLots;

    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot =  parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getNumberOfSpareLot))
                .orElse(null);
        return parkingLot.park(car);
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
}
