package com.parkinglot;

import java.util.Comparator;
import java.util.List;

public class StandardParkingBoy extends ParkingBoy{
    public StandardParkingBoy(List<ParkingLot> parkingLots) {
        super(parkingLots);
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(ParkingLot::hasSpareLot)
                .findFirst()
                .orElse(null);
        if (parkingLot != null)
            return parkingLot.park(car);
        throw new NoAvailablePositionException("No available position.");
    }
}
