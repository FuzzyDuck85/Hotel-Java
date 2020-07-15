import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    ConferenceRoom conferenceRoom;
    Guest guest1;
    Guest guest2;

    @Before
    public void before() {
        conferenceRoom = new ConferenceRoom("Clyde", 5);
        guest1 = new Guest("Basil");
        guest2 = new Guest("Sybil");
    }

    @Test
    public void conferenceRoomInitialisedWithNoGuests() {
        assertEquals(0, conferenceRoom.guestCount());
    }

    @Test
    public void canAddGuestToConferenceRoom() {
        conferenceRoom.add(guest1);
        assertEquals(1, conferenceRoom.guestCount());
    }

    @Test
    public void willNotAddGuestIfExceedsCapacity() {
        conferenceRoom.add(guest1);
        conferenceRoom.add(guest1);
        conferenceRoom.add(guest1);
        conferenceRoom.add(guest1);
        conferenceRoom.add(guest1);
        conferenceRoom.add(guest1);
        assertEquals(5, conferenceRoom.guestCount());
    }

    @Test
    public void canCheckOut() {
        conferenceRoom.add(guest1);
        conferenceRoom.checkOut(guest1);
        assertEquals(0, conferenceRoom.guestCount());
    }

    @Test
    public void doesNotCheckOutIfNotInRoom() {
        conferenceRoom.add(guest1);
        conferenceRoom.checkOut(guest2);
        assertEquals(1, conferenceRoom.guestCount());
    }
}
