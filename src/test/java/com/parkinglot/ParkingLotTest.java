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


        //then
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, ()->{
            Ticket ticket = parkingLot.park(new Car());
        });
        assertEquals("No available position.", noAvailablePositionException.getMessage());
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
        parkingLot.park(new Car());

        //when
        Ticket ticket2 = new Ticket();

        //then
        UnrecognizedParkingTicket unrecognizedParkingTicket = assertThrows(UnrecognizedParkingTicket.class, ()->{
            parkingLot.pick(ticket2);
        });
        assertEquals("Unrecognized packing ticket", unrecognizedParkingTicket.getMessage());
    }

    //6. given a parking lot, and a used parking ticket, when fetch the car, then return nothing.
    @Test
    void should_return_null_when_pick_car_given_one_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket1 = parkingLot.park(new Car());
        Car pickCar1= parkingLot.pick(ticket1);

        //when
        //then
        UnrecognizedParkingTicket unrecognizedParkingTicket = assertThrows(UnrecognizedParkingTicket.class, ()->{
            parkingLot.pick(ticket1);
        });
        assertEquals("Unrecognized packing ticket", unrecognizedParkingTicket.getMessage());
    }

    //storyline 2
    //Case 1 - Given a parking lot, and an unrecognized ticket, When fetch the car, Then return nothing with error message "Unrecognized parking ticket.
    @Test
    void should_return_UnrecognizedParkingTicket_exception_when_pick_car_given_unrecognized_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());

        //when
        //then
        Ticket ticket = new Ticket();
        UnrecognizedParkingTicket unrecognizedParkingTicket = assertThrows(UnrecognizedParkingTicket.class, ()->{
            parkingLot.pick(ticket);
        });
        assertEquals("Unrecognized packing ticket.", unrecognizedParkingTicket.getMessage());
    }

    //Case 2 - Given a parking lot, and a used ticket, When fetch the car, Then return nothing with error message "Unrecognized parking ticket.
    @Test
    void should_return_UnrecognizedParkingTicket_exception_when_pick_car_given_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.park(new Car());

        //when
        //then
        parkingLot.pick(ticket);
        UnrecognizedParkingTicket unrecognizedParkingTicket = assertThrows(UnrecognizedParkingTicket.class, ()->{
            parkingLot.pick(ticket);
        });
        assertEquals("Unrecognized packing ticket.", unrecognizedParkingTicket.getMessage());
    }

    //Case 3 - Given a parking lot without any position, and a car, When park the car, Then return nothing with error message "No available position.
    @Test
    void should_throw_noAvailablePosition_exception_when_park_car_given_parkinglot_without_position_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car());
        Car car = new Car();

        //when
        //then
        NoAvailablePositionException noAvailablePositionException = assertThrows(NoAvailablePositionException.class, ()->{
            parkingLot.park(car);
        });
        assertEquals("No available position.", noAvailablePositionException.getMessage());
    }

//    Case 1 - Given a standard parking boy, who manage one parking lot, with available position, and a car, When park
//    the car, Then the car will be parked to the parking lot.
    @Test
    void should_return_ticket_when_park_car_given_parkingboy_manage_one_parkinglot_with_available_position_and_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //when
        Ticket ticket = parkingBoy.park(new Car());

        //then
        assertNotNull(ticket);
    }


//    Case 2 - Given a standard parking boy, who manage two parking lots, both with available position, and a car, when
//    park the car, then the car will be parked to the first parking lot.

//    Case 3 - Given a standard parking boy, who manage two parking lots, first is full and second with available
//    position, and a car, When park the car, Then the car will be parked to the second parking lot

//    Case 4 - Given a standard parking boy, who manage two parking lots, both with parked car, and two parking ticket,
//    when fetch the car twice, then return the right car with each ticket

//    Case 5 - Given a standard parking boy, who manage two parking lots, and an unrecognized ticket, when fetch the
//    car, then return nothing with error message "Unrecognized parking ticket."

//    Case 6 - Given a standard parking boy, who manage two parking lots, and use a used ticket, when fetch the car,
//    ten return nothing with error message "Unrecognized parking ticket."

//    Case 7 - Given a standard parking boy, who manage two parking lots, both without any position, and a car, When
//    park the car, then return nothing with error message "No available position.

}
