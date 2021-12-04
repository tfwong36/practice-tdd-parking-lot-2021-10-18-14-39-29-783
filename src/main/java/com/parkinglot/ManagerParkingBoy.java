package com.parkinglot;

import java.util.List;

public class ManagerParkingBoy extends StandardParkingBoy{
    private List<ParkingBoy> parkingBoys;
    public ManagerParkingBoy(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
    }

    public Ticket assignParkingBoy2Park(StandardParkingBoy boy1, Car car) {
        if (boy1.parkingLots.size() == 0)
            throw new NoPermissionToManageParkingLotException("This Parking Boy Do Not Manage Any ParkingLot.");
        return boy1.park(car);
    }

    public void assignParkingLot2ParkingBoy(StandardParkingBoy boy1, ParkingLot parkingLot) {
        boy1.addParkingLot(parkingLot);
    }

    public Car orderParkingBoy2Pick(StandardParkingBoy boy1, Ticket ticket) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(e -> e.isValidTicket(ticket))
                .findFirst()
                .orElse(null);
        if (boy1.parkingLots.contains(parkingLot))
            return boy1.pick(ticket);
        throw new NoPermissionToManageParkingLotException("This Parking Boy Do Not Manage That ParkingLot.");
    }
}
