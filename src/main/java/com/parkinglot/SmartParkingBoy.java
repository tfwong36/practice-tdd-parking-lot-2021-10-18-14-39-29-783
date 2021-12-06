package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        return parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getNumberOfSpareLot))
                .orElseThrow(() -> new NoAvailablePositionException("No available position."))
                .park(car);
    }

}
