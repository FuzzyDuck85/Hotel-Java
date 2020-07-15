import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HotelTest {
    Hotel hotel;
    Guest guest1;
    Guest guest2;
    ArrayList<Guest> guests;
    Bedroom bedroom1;
    Bedroom bedroom2;
    Bedroom bedroom3;
    ConferenceRoom conferenceRoom1;
    DiningRoom diningRoom1;
    DiningRoom diningRoom2;

    @Before
    public void before(){
        hotel = new Hotel("CodeClan Towers");
        guest1 = new Guest("Basil");
        guest2 = new Guest("Sybil");
        guests = new ArrayList<Guest>();
        bedroom1 = new Bedroom(1, 1, "Single", 50);
        bedroom2 = new Bedroom(2, 2, "Double", 75);
        bedroom3 = new Bedroom(3, 5, "Family", 100);
        conferenceRoom1 = new ConferenceRoom("Clyde", 5);
        diningRoom1 = new DiningRoom("Tuck Inn");
        diningRoom2 = new DiningRoom("Eat Off The Floor");
    }

    @Test
    public void checkHotelInitialisesWithNoRooms(){
        assertEquals(0, hotel.countBedrooms());
        assertEquals(0, hotel.countConferenceRooms());
    }

    @Test
    public void canAddRoomsToHotel(){
        hotel.addBedroom(bedroom1);
        hotel.addConferenceRoom(conferenceRoom1);
        assertEquals(1, hotel.countBedrooms());
        assertEquals(1, hotel.countConferenceRooms());
    }

    @Test
    public void canCheckGuestIntoBedroom(){
        guests.add(guest1);
        hotel.addBedroom(bedroom1);
        hotel.checkInToBedroom(guests, bedroom1);
        assertEquals(1, bedroom1.guestCount());
    }

    @Test
    public void canCheckGuestsOutOfBedroom(){
        guests.add(guest1);
        guests.add(guest2);
        hotel.addBedroom(bedroom2);
        hotel.checkInToBedroom(guests, bedroom2);
        hotel.checkOutOfBedroom(guest1, bedroom2);
        assertEquals(1, bedroom2.guestCount());
    }

    @Test
    public void canCheckAllGuestsOutOfBedroom(){
        guests.add(guest1);
        guests.add(guest2);
        hotel.addBedroom(bedroom2);
        hotel.checkInToBedroom(guests, bedroom2);
        hotel.checkOutAllGuestsBedroom(bedroom2);
        assertEquals(0, bedroom2.guestCount());
    }

    @Test
    public void canCheckGuestIntoConferenceRoom(){
        hotel.addConferenceRoom(conferenceRoom1);
        hotel.checkInToConferenceRoom(guest1, conferenceRoom1);
        hotel.checkInToConferenceRoom(guest1, conferenceRoom1);
        hotel.checkInToConferenceRoom(guest1, conferenceRoom1);
        assertEquals(3, conferenceRoom1.guestCount());
    }

    @Test
    public void canCheckGuestsOutOfConferenceRoom(){
        hotel.addConferenceRoom(conferenceRoom1);
        hotel.checkInToConferenceRoom(guest2, conferenceRoom1);
        hotel.checkInToConferenceRoom(guest1, conferenceRoom1);
        hotel.checkOutOfConferenceRoom(guest1, conferenceRoom1);
        assertEquals(1, conferenceRoom1.guestCount());
    }

    @Test
    public void canCheckAllGuestsOutOfConferenceRoom(){
        hotel.addConferenceRoom(conferenceRoom1);
        hotel.checkInToConferenceRoom(guest2, conferenceRoom1);
        hotel.checkInToConferenceRoom(guest1, conferenceRoom1);
        hotel.checkOutAllGuestsConferenceRoom(conferenceRoom1);
        assertEquals(0, conferenceRoom1.guestCount());
    }

    @Test
    public void canAddDiningRooms(){
        hotel.addDiningRoom(diningRoom1);
        hotel.addDiningRoom(diningRoom2);
        assertEquals(2, hotel.countDiningRooms());
    }

    @Test
    public void showOnlyVacantRooms(){
        guests.add(guest1);
        guests.add(guest2);
        hotel.addBedroom(bedroom1);
        hotel.addBedroom(bedroom2);
        hotel.addBedroom(bedroom3);
        hotel.checkInToBedroom(guests, bedroom2);
        assertEquals(2, hotel.getEmptybedrooms().size());
    }

    @Test
    public void allGuestsCheckOutWhenFireAlarmCalled(){
        guests.add(guest1);
        guests.add(guest2);
        hotel.addBedroom(bedroom2);
        hotel.addBedroom(bedroom3);
        hotel.checkInToBedroom(guests, bedroom2);
        hotel.checkInToBedroom(guests, bedroom3);
        hotel.addConferenceRoom(conferenceRoom1);
        hotel.checkInToConferenceRoom(guest1, conferenceRoom1);
        hotel.addDiningRoom(diningRoom1);
        hotel.addDiningRoom(diningRoom2);
        diningRoom1.add(guest1);
        hotel.fireAlarm();
        assertEquals(0, bedroom2.guestCount());
        assertEquals(0, bedroom3.guestCount());
        assertEquals(0, conferenceRoom1.guestCount());
        assertEquals(0, diningRoom1.countGuests());
        assertEquals(0, diningRoom2.countGuests());
    }
}
