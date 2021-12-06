package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class StandardParkingBoy extends ParkingBoy{
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        return parkingLots.stream()
                .filter(ParkingLot::hasSpareLot)
                .findFirst()
                .orElseThrow(() -> new NoAvailablePositionException("No available position."))
                .park(car);
    }
}
