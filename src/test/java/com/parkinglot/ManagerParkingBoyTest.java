package com.parkinglot;

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
//    @Test
//    void should_return_right_car_when_manager_specify_a_parking_boy_to_fetch_a_car_given_two_parkinglot_manager_added_parkingboy_to_a_parkinglot_management_list_and_a_parked_car() {
//        //given
//
//        //when
//
//        //then
//    }

    //AC1
//    @Test
//    void should_return_NoPermissionToMangeException_when_manager_specify_a_parking_boy_to_park_a_car_given_two_parkinglot_a_car() {
//        //given
//
//        //when
//
//        //then
//    }

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
