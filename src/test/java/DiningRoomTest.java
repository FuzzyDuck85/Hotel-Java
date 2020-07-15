import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DiningRoomTest {
    DiningRoom diningRoom;
    Guest guest1;
    Guest guest2;

    @Before
    public void before(){
        diningRoom = new DiningRoom("Tuck Inn");
        guest1 = new Guest("Basil");
        guest2 = new Guest("Sybil");
    }

    @Test
    public void checkDiningRoomInitialiseWithNoGuests(){
        assertEquals(0, diningRoom.countGuests());
    }

    @Test
    public void canAddGuest(){
        diningRoom.add(guest1);
        diningRoom.add(guest2);
        assertEquals(2, diningRoom.countGuests());
    }

    @Test
    public void canRemoveGuest(){
        diningRoom.add(guest1);
        diningRoom.add(guest2);
        diningRoom.remove(guest2);
        assertEquals(1, diningRoom.countGuests());
    }
}
