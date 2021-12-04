package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SmartParkingBoyTest {
//    Case 1 - Given a Smart parking boy, who manage two parking lot, with same number of empty space, and a car, When park the
//    car, Then the car will be parked to the first parking lot.
    @Test
    void should_return_Ticket_and_park_in_first_parkinglot_when_park_car_given_SmartParkingboy_manage_two_parkinglot_with_same_number_of_spare_position_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        //when
        Ticket ticket = smartParkingBoy.park(new Car());

        //then
        assertNotNull(ticket);
        assertEquals(0, parkingLot1.getNumberOfSpareLot());
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

//    Case 4 - Given a Smart parking boy, who manage two parking lots, and an unrecognized ticket, when fetch the car,
//    then return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_exception_when_pick_car_given_SmartParkingboy_manage_two_parkinglot_and_unrecognized_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        parkingLot1.park(new Car());
        parkingLot2.park(new Car());

        //when

        //then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()->{
            smartParkingBoy.pick(new Ticket());
        });
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getMessage());
    }
//    Case 5 - Given a Smart parking boy, who manage two parking lots, and use a used ticket, when fetch the car, ten
//    return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_UnrecognizedParkingTicketException_when_pick_car_given_SmartParkingboy_manage_two_parkinglot_with_used_ticket_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Ticket ticket1 = parkingLot1.park(new Car());
        parkingLot2.park(new Car());

        //when
        //then
        smartParkingBoy.pick(ticket1);
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()->{
            smartParkingBoy.pick(ticket1);
        });
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getMessage());

    }

//    Case 6 - Given a Smart parking boy, who manage two parking lots, both without any position, and a car, When park
//    the car, then return nothing with error message "No available position.
    @Test
    void should_return_NoAvailablePositionException_when_park_car_given_SmartParkingboy_manage_two_parkinglot_without_spare_lot() {
        //given
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(Arrays.asList(new ParkingLot(0), new ParkingLot(0)));

        //when
        //then
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, ()->{
            smartParkingBoy.park(new Car());
        });
        assertEquals("No available position.", noAvailablePositionException.getMessage());
    }
}
