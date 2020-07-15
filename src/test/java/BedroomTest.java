import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest1;
    Guest guest2;
    ArrayList<Guest> guests;

    @Before
    public void before(){
        bedroom = new Bedroom(1, 1, "Single", 50);
        guest1 = new Guest("Basil");
        guest2 = new Guest("Sybil");
        guests = new ArrayList<Guest>();
    }

    @Test
    public void bedroomInitialisedWithNoGuests(){
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void canAddGuestToBedroom(){
        guests.add(guest1);
        bedroom.add(guests);
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void willNotAddGuestIfExceedsCapacity(){
        guests.add(guest1);
        guests.add(guest2);

        bedroom.add(guests);

        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void canCheckOut(){
        guests.add(guest1);
        bedroom.add(guests);
        bedroom.checkOutAll();
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void doesNotCheckOutIfNotInRoom(){
        guests.add(guest1);
        bedroom.add(guests);
        bedroom.checkOut(guest2);
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void checkBedroomHasRate(){
        assertEquals(50, bedroom.getRate());
    }

}
