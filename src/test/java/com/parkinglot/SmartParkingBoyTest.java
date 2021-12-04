package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {
//    Case 1 - Given a Smart parking boy, who manage one parking lot, with available position, and a car, When park the
//    car, Then the car will be parked to the parking lot.
    @Test
    void should_return_ticket_when_park_car_given_SmartParkingboy_manage_one_parkinglot_with_available_position_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot));

        //when
        Ticket ticket = smartParkingBoy.park(new Car());

        //then
        assertNotNull(ticket);
    }
//    Case 2 - Given a Smart parking boy, who manage two parking lots, both with available position, and a car, when
//    park the car, then the car will be parked to the first parking lot.

//    Case 3 - Given a Smart parking boy, who manage two parking lots, first is full and second with available
//    position, and a car, When park the car, Then the car will be parked to the second parking lot

//    Case 4 - Given a Smart parking boy, who manage two parking lots, both with parked car, and two parking ticket,
//    when fetch the car twice, then return the right car with each ticket

//    Case 5 - Given a Smart parking boy, who manage two parking lots, and an unrecognized ticket, when fetch the car,
//    then return nothing with error message "Unrecognized parking ticket."

//    Case 6 - Given a Smart parking boy, who manage two parking lots, and use a used ticket, when fetch the car, ten
//    return nothing with error message "Unrecognized parking ticket."

//    Case 7 - Govem a Smart parking boy, who manage two parking lots, both without any position, and a car, When park
//    the car, then return nothing with error message "No available position.
}
