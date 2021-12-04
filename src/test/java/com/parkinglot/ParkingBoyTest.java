package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingBoyTest {
    //    Case 1 - Given a standard parking boy, who manage one parking lot, with available position, and a car, When park
//    the car, Then the car will be parked to the parking lot.
    @Test
    void should_return_ticket_when_park_car_given_parkingboy_manage_one_parkinglot_with_available_position_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot));

        //when
        Ticket ticket = parkingBoy.park(new Car());

        //then
        assertNotNull(ticket);
    }


//    Case 2 - Given a standard parking boy, who manage two parking lots, both with available position, and a car, when
//    park the car, then the car will be parked to the first parking lot.
    @Test
    void should_return_parked_first_parkinglot_when_park_car_given_parkingboy_manange_two_parkinglot_with_spare_lot_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot();
        ParkingLot parkingLot2 = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        //when
        Ticket ticket = parkingBoy.park(new Car());

        //then
        assertNotNull(ticket);
        assertEquals(9, parkingLot1.getNumberOfSpareLot());
    }


//    Case 3 - Given a standard parking boy, who manage two parking lots, first is full and second with available
//    position, and a car, When park the car, Then the car will be parked to the second parking lot
    @Test
    void should_park_Second_ParkingLot_when_park_car_given_parkingBoy_manage_two_parkingLot_with_first_full_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        //when
        parkingBoy.park(new Car());
        assertEquals(1, parkingLot2.getNumberOfSpareLot());

        //then
        Ticket ticket = parkingBoy.park(new Car());
        assertEquals(0, parkingLot2.getNumberOfSpareLot());
    }


//    Case 4 - Given a standard parking boy, who manage two parking lots, both with parked car, and two parking ticket,
//    when fetch the car twice, then return the right car with each ticket

//    Case 5 - Given a standard parking boy, who manage two parking lots, and an unrecognized ticket, when fetch the
//    car, then return nothing with error message "Unrecognized parking ticket."

//    Case 6 - Given a standard parking boy, who manage two parking lots, and use a used ticket, when fetch the car,
//    ten return nothing with error message "Unrecognized parking ticket."

//    Case 7 - Given a standard parking boy, who manage two parking lots, both without any position, and a car, When
//    park the car, then return nothing with error message "No available position.
}
