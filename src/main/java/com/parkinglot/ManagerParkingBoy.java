package com.parkinglot;

import java.util.List;

public class ManagerParkingBoy extends StandardParkingBoy{
    private List<ParkingBoy> parkingBoys;
    public ManagerParkingBoy(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
        super(parkingLots);
        this.parkingBoys = parkingBoys;
    }

    public void assignParkingLot2ParkingBoy(ParkingBoy boy, ParkingLot parkingLot) {
        boy.addParkingLot(parkingLot);
    }

    public Ticket orderParkingBoyToPark(ParkingBoy boy, Car car) {
        if (boy.parkingLots.size() == 0)
            throw new NoPermissionToManageParkingLotException("This Parking Boy Do Not Manage Any ParkingLot.");
        return boy.park(car);
    }

    public Car orderParkingBoyToPick(ParkingBoy boy, Ticket ticket) {
        ParkingLot parkingLot = parkingLots.stream()
                .filter(e -> e.isValidTicket(ticket))
                .findFirst()
                .orElse(null);
        if (boy.parkingLots.contains(parkingLot))
            return boy.pick(ticket);
        throw new NoPermissionToManageParkingLotException("This Parking Boy Do Not Manage That ParkingLot.");
    }
}
