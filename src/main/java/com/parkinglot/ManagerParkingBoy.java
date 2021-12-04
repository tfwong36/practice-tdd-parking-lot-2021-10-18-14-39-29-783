package com.parkinglot;

import java.util.List;

public class ManagerParkingBoy extends StandardParkingBoy{
    private List<ParkingBoy> parkingBoys;
    public ManagerParkingBoy(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
    }

    public Ticket assignParkingBoy2Park(StandardParkingBoy boy1, Car car) {
        return boy1.park(car);
    }

    public void assignParkingLot2ParkingBoy(StandardParkingBoy boy1, ParkingLot parkingLot) {
        boy1.addParkingLot(parkingLot);
    }

    public Car orderParkingBoy2Pick(StandardParkingBoy boy1, Ticket ticket) {
        return new Car();
    }
}
