package com.parkinglot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
    @Test
    void should_return_ticket_when_pack_car_given_parkinglot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        Ticket ticket = parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }
    @Test
    void should_return_null_when_park_car_given_no_spare_slot_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());
        //when
        Ticket ticket = parkingLot.park(new Car());

        //then
        assertNull(ticket);
    }

    //3. given a parking lot with a parked car, and a parking ticket, When fetch the car, then return the parked car
    @Test
    void should_return_parked_car_when_fetch_car_given_parkinglot_with_parked_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();

        //when
        Ticket ticket = parkingLot.park(car);
        Car pickCar= parkingLot.pick(ticket);

        //then
        assertEquals(pickCar, car);
    }

    //4. given a parking lot with two parked cars, and two parking tickets, when fetch the car twice, Then return the right car with each ticket
    @Test
    void should_return_Corresponding_Car_when_pick_car_twice_given_two_parked_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(2);
        Car car1 = new Car();
        Car car2 = new Car();
        Ticket ticket1 = parkingLot.park(car1);
        Ticket ticket2 = parkingLot.park(car2);

        //when
        Car pickCar1= parkingLot.pick(ticket1);
        Car pickCar2= parkingLot.pick(ticket2);

        //then
        assertEquals(pickCar1, car1);
        assertEquals(pickCar2, car2);
    }

    //5. given a parking lot, and a wrong parking ticket, When fetch the car, Then return nothing.
    @Test
    void should_return_null_when_Wrong_ticket_given_parkingLot() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);

        //when
        Ticket ticket = new Ticket(999);
        Car pickCar= parkingLot.pick(ticket);

        //then
        assertNull(pickCar);
    }

    //6. given a parking lot, and a sed parking ticket, whren fetch the car, then return nothing.

}
