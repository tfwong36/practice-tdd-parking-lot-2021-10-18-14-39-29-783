package com.parkinglot;

import java.util.List;

public class ParkingBoy {
    private final List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        return parkingLots.stream()
                .filter(ParkingLot::hasSpareLot)
                .findFirst()
                .get().park(car);
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
