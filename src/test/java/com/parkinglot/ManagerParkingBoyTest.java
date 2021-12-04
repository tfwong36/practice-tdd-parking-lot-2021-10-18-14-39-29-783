package com.parkinglot;

import javafx.concurrent.Service;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerParkingBoyTest {
    //AC1
    @Test
    void should_return_Ticket_when_Manager_specify_a_parking_boy_to_park_a_car_given_a_parkinglot_and_manager_added_parkingboy_to_a_parkinglot_management_list_and_a_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        StandardParkingBoy boy1 = new StandardParkingBoy(Collections.emptyList());
        ManagerParkingBoy manager = new ManagerParkingBoy(Arrays.asList(parkingLot1), Arrays.asList(boy1));
        //when
        manager.assignParkingLot2ParkingBoy(boy1, parkingLot1);
        Ticket ticket = manager.assignParkingBoy2Park(boy1, new Car());

        //then
        assertNotNull(ticket);
        assertEquals(0, parkingLot1.getNumberOfSpareLot());
    }

    //AC1
    @Test
    void should_return_right_car_when_manager_specify_a_parking_boy_to_fetch_a_car_given_one_parkinglot_with_two_parked_car_and_manager_added_parkingboy_to_a_parkinglot_management_list_and_a_parked_car() {
        //given
        ParkingLot parkingLot1 = new ParkingLot(2);
        StandardParkingBoy boy1 = new StandardParkingBoy(Collections.emptyList());
        ManagerParkingBoy manager = new ManagerParkingBoy(Arrays.asList(parkingLot1), Arrays.asList(boy1));

        //when
        Car car1 = new Car();
        Car car2 = new Car();
        parkingLot1.park(car1);
        Ticket ticket = parkingLot1.park(car2);
        manager.assignParkingLot2ParkingBoy(boy1, parkingLot1);
        Car pickCar = manager.orderParkingBoy2Pick(boy1, ticket);

        //then
        assertEquals(pickCar,car2);
    }

    //AC1
    @Test
    void should_return_NoPermissionToManageParkingLotException_when_manager_specify_a_parking_boy_to_park_a_car_in_parkinglot_not_managed_by_him_given_one_parkinglot__and_a_car() {
        //parking boy have no parkinglot, cannot park the car
        //given
        ParkingLot parkingLot1 = new ParkingLot(1);
        StandardParkingBoy boy1 = new StandardParkingBoy(Collections.emptyList());
        ManagerParkingBoy manager = new ManagerParkingBoy(Arrays.asList(parkingLot1), Arrays.asList(boy1));

        //when
        //then
        NoPermissionToManageParkingLotException noPermissionToManageParkingLotException = assertThrows(NoPermissionToManageParkingLotException.class, ()->{
            manager.assignParkingBoy2Park(boy1, new Car());
        });
        assertEquals("This Parking Boy Do Not Manage Any ParkingLot.", noPermissionToManageParkingLotException.getMessage());
    }
    @Test
    void should_return_Ticket_from_parkinglot2_when_manager_specify_a_standard_parking_boy_to_park_a_car_given_two_parkinglot_and_parkinglot1_is_empty_and_a_car_and_parkingboy_responsible_for_parkinglot2() {
        //standard parking boy will only park at parkinglot2, although parking lot1 is empty
        //given
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        StandardParkingBoy boy1 = new StandardParkingBoy(Collections.emptyList());
        ManagerParkingBoy manager = new ManagerParkingBoy(Arrays.asList(parkingLot1, parkingLot2), Arrays.asList(boy1));
        manager.assignParkingLot2ParkingBoy(boy1, parkingLot2);

        //when
        Ticket ticket = manager.assignParkingBoy2Park(boy1, new Car());
        //then
        assertNotNull(ticket);
        assertEquals(9, parkingLot2.getNumberOfSpareLot());
    }

    //AC1
//    @Test
//    void should_return_NoPermissionToMangeException_when_manager_specify_a_parking_boy_to_fetch_a_car_given_two_parkinglot__a_parked_car_and_a_Ticket() {
//        //given
//
//        //when
//
//        //then
//    }

}
