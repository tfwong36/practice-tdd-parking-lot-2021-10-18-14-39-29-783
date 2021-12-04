package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy {
    private final List<ParkingLot> parkingLots;

    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket park(Car car) {
        return new Ticket();
    }
}
