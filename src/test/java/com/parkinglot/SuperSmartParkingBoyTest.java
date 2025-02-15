package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SuperSmartParkingBoyTest {
//Case 1 - Given a Super Smart parking boy, who manage two parking lots, both with same available position, and a car,
// when park the car, then the car will be parked to the first parking lot.
    @Test
    void should_return_Ticket_and_park_in_first_parkinglot_when_park_car_given_SuperSmartParkingboy_manage_two_parkinglot_with_same_number_of_spare_position_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        //when
        Ticket ticket = superSmartParkingBoy.park(new Car());

        //then
        assertNotNull(ticket);
        assertEquals(0, parkingLot1.getNumberOfSpareLot());
    }
//Case 2 - Given a Super Smart parking boy, who manage two parking lots, second one has larger available position rate,
// and a car, When park the car, Then the car will be parked to the second parking lot
    @Test
    void should_return_ticket_and_parked_second_parkinglot_when_park_car_given_SuperSmartparkingboy_manange_two_parkinglot_with_second_one_larger_availableRate_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(10);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));

        //when
        parkingLot1.park(new Car());
        Ticket ticket = superSmartParkingBoy.park(new Car());

        //then
        assertNotNull(ticket);
        assertEquals(9, parkingLot2.getNumberOfSpareLot());
    }
//Case 3 - Given a Super Smart parking boy, who manage two parking lots, both with a parked car, and two parking
// ticket, when fetch the car twice, then return the right car with each ticket
    @Test
    void should_return_right_car_withe_ticket_when_pick_car_given_SmartParkingboy_manage_two_pakinglot_with_both_parked_car_and_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot1.park(car1);
        Ticket ticket2 = parkingLot2.park(car2);

        //when
        Car pickCar2 = superSmartParkingBoy.pick(ticket2);
        Car pickCar1 = superSmartParkingBoy.pick(ticket1);

        //then
        assertEquals(car1, pickCar1);
        assertEquals(car2, pickCar2);
    }
//Case 4 - Given a Super Smart parking boy, who manage two parking lots, and an unrecognized ticket, when fetch the
// car, then return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_UnrecognizedParkingTicketException_when_pick_car_given_SuperSmartParkingboy_manage_two_parkinglot_and_unrecognized_ticket() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        parkingLot1.park(new Car());
        parkingLot2.park(new Car());

        //when

        //then
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()->{
            superSmartParkingBoy.pick(new Ticket());
        });
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getMessage());
    }

//Case 5 - Given a Super Smart parking boy, who manage two parking lots, and use a used ticket, when fetch the car,
// ten return nothing with error message "Unrecognized parking ticket."
    @Test
    void should_return_UnrecognizedParkingTicketException_when_pick_car_given_SuperSmartParkingboy_manage_two_parkinglot_with_used_ticket_and_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(parkingLot1, parkingLot2));
        Ticket ticket1 = parkingLot1.park(new Car());
        parkingLot2.park(new Car());

        //when
        //then
        superSmartParkingBoy.pick(ticket1);
        UnrecognizedParkingTicketException unrecognizedParkingTicketException = assertThrows(UnrecognizedParkingTicketException.class, ()->{
            superSmartParkingBoy.pick(ticket1);
        });
        assertEquals("Unrecognized parking ticket.", unrecognizedParkingTicketException.getMessage());

    }

//Case 6 - Given a Super Smart parking boy, who manage two parking lots, both without any position, and a car, When
// park the car, then return nothing with error message "No available position.
    @Test
    void should_return_NoAvailablePositionException_when_park_car_given_SuperSmartParkingboy_manage_two_parkinglot_without_spare_lot() {
        //given
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(Arrays.asList(new ParkingLot(0), new ParkingLot(0)));

        //when
        //then
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, ()->{
            superSmartParkingBoy.park(new Car());
        });
        assertEquals("No available position.", noAvailablePositionException.getMessage());
    }
}
