package com.parkinglot;

import java.util.List;

public class StandardParkingBoy {
    private final List<ParkingLot> parkingLots;

    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(ParkingLot::hasSpareLot)
                .findFirst()
                .orElse(null);
        if (parkingLot != null)
            return parkingLot.park(car);
        throw new NoAvailablePositionException("No available position.");
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
