package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot parkingLot =  parkingLots.stream()
                .max(Comparator.comparing(ParkingLot::getNumberOfSpareLot))
                .orElse(null);
        if (parkingLot != null)
            return parkingLot.park(car);
        throw new NoAvailablePositionException("No available position.");
    }

}
