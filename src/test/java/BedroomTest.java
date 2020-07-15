import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    Bedroom bedroom;
    Guest guest1;
    Guest guest2;

    @Before
    public void before(){
        bedroom = new Bedroom(1, 1, "Single", 50);
        guest1 = new Guest("Basil");
        guest2 = new Guest("Sybil");
    }

    @Test
    public void bedroomInitialisedWithNoGuests(){
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void canAddGuestToBedroom(){
        bedroom.add(guest1);
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void willNotAddGuestIfExceedsCapacity(){
        bedroom.add(guest1);
        bedroom.add(guest1);
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void canCheckOut(){
        bedroom.add(guest1);
        bedroom.checkOut(guest1);
        assertEquals(0, bedroom.guestCount());
    }

    @Test
    public void doesNotCheckOutIfNotInRoom(){
        bedroom.add(guest1);
        bedroom.checkOut(guest2);
        assertEquals(1, bedroom.guestCount());
    }

    @Test
    public void checkBedroomHasRate(){
        assertEquals(50, bedroom.getRate());
    }

}
