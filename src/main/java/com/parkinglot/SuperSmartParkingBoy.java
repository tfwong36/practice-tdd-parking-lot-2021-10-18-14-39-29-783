package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy {
    private final List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot =  parkingLots.stream()
            .min(Comparator.comparing(ParkingLot::getAvailableLotRate))
            .orElse(null);
        return parkingLot.park(car);
    }
}
