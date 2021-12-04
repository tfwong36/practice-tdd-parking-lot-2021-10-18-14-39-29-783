package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
//    Case 2 - Given a Smart parking boy, who manage two parking lots, second one has more empty spare lot, and a car, when
//    park the car, then the car will be parked to the second parking lot.
    @Test
    void should_return_parked_first_parkinglot_when_park_car_given_Smartparkingboy_manange_two_parkinglot_with_second_one_more_spare_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(10);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        //when
        Ticket ticket = smartParkingBoy.park(new Car());

        //then
        assertNotNull(ticket);
        assertEquals(9, parkingLot2.getNumberOfSpareLot());
    }

//    Case 3 - Given a Smart parking boy, who manage two parking lots, both with a parked car, and two parking ticket
//    When fetch the car twice, Then return the right car with each ticket
    @Test
    void should_return_right_car_withe_ticket_when_pick_car_given_SmartParkingboy_manage_two_pakinglot_with_both_parked_car_and_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot1.park(car1);
        Ticket ticket2 = parkingLot2.park(car2);

        //when
        Car pickCar2 = smartParkingBoy.pick(ticket2);
        Car pickCar1 = smartParkingBoy.pick(ticket1);

        //then
        assertEquals(car1, pickCar1);
        assertEquals(car2, pickCar2);
    }

//    Case 4 - Given a Smart parking boy, who manage two parking lots, both with parked car, and two parking ticket,
//    when fetch the car twice, then return the right car with each ticket

//    Case 5 - Given a Smart parking boy, who manage two parking lots, and an unrecognized ticket, when fetch the car,
//    then return nothing with error message "Unrecognized parking ticket."

//    Case 6 - Given a Smart parking boy, who manage two parking lots, and use a used ticket, when fetch the car, ten
//    return nothing with error message "Unrecognized parking ticket."

//    Case 7 - Govem a Smart parking boy, who manage two parking lots, both without any position, and a car, When park
//    the car, then return nothing with error message "No available position.
}
