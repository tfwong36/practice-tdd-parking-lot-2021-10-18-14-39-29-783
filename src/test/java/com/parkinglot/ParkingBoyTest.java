package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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
        parkingLot1.park(new Car());
        assertEquals(1, parkingLot2.getNumberOfSpareLot());

        //then
        Ticket ticket = parkingBoy.park(new Car());
        assertEquals(0, parkingLot2.getNumberOfSpareLot());
    }


//    Case 4 - Given a standard parking boy, who manage two parking lots, both with parked car, and two parking ticket,
//    when fetch the car twice, then return the right car with each ticket
    @Test
    void should_return_right_car_withe_ticket_when_pick_car_given_parkingboy_manage_two_pakinglot_with_both_parked_car_and_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot1.park(car1);
        Ticket ticket2 = parkingLot2.park(car2);

        //when
        Car pickCar2 = parkingBoy.pick(ticket1);
        Car pickCar1 = parkingBoy.pick(ticket2);

        //then
        assertEquals(car1, pickCar1);
        assertEquals(car2, pickCar2);
    }


//    Case 5 - Given a standard parking boy, who manage two parking lots, and an unrecognized ticket, when fetch the
//    car, then return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_exception_when_pick_car_given_parkingboy_manage_two_parkinglot_and_unrecognized_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        parkingLot1.park(new Car());
        parkingLot2.park(new Car());

        //when

        //then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()->{
            parkingBoy.pick(new Ticket());
        });
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getMessage());
    }


//    Case 6 - Given a standard parking boy, who manage two parking lots, and use a used ticket, when fetch the car,
//    ten return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_UnrecognizedParkingTicketException_when_pick_car_given_parkingboy_manage_two_parkinglot_with_used_ticket_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Ticket ticket1 = parkingLot1.park(new Car());
        parkingLot2.park(new Car());

        //when
        //then
        parkingBoy.pick(ticket1);
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()->{
            parkingBoy.pick(ticket1);
        });
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getMessage());

    }

//    Case 7 - Given a standard parking boy, who manage two parking lots, both without any position, and a car, When
//    park the car, then return nothing with error message "No available position.
    @Test
    void should_return_NoAvailablePositionException_when_park_car_given_parkingboy_manage_two_parkinglot_without_spare_lot() {
        //given
        ParkingBoy parkingBoy = new ParkingBoy(Arrays.asList(new ParkingLot(0), new ParkingLot(0)));

        //when
        //then
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, ()->{
            parkingBoy.park(new Car());
        });
        assertEquals("No available position.", noAvailablePositionException.getMessage());
    }

}
