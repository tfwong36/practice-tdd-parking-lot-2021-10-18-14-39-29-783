package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SuperSmartParkingBoy extends ParkingBoy{
    public SuperSmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot parkingLot =  parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getAvailableLotRate))
                .orElse(null);
        return parkingLot.park(car);
    }
}
