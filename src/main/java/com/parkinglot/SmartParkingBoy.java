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
        return new Car();
    }
}
