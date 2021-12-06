package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        return parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getAvailableLotRate))
                .orElseThrow(() -> new NoAvailablePositionException("No available position."))
                .park(car);
    }
}
