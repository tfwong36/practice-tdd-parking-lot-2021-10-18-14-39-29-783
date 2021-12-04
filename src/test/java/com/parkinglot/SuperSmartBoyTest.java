package com.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SuperSmartBoyTest {
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

//Case 4 - Given a Super Smart parking boy, who manage two parking lots, and an unrecognized ticket, when fetch the
// car, then return nothing with error message "Unrecognized parking ticket."

//Case 5 - Given a Super Smart parking boy, who manage two parking lots, and use a used ticket, when fetch the car,
// ten return nothing with error message "Unrecognized parking ticket."

//Case 6 - Govem a Super Smart parking boy, who manage two parking lots, both without any position, and a car, When
// park the car, then return nothing with error message "No available position.
}
