import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {
    Booking booking;
    Bedroom bedroom;

    @Before
    public void before(){
        bedroom = new Bedroom(1,1,"Single", 50);
        booking = new Booking(bedroom, 4);
    }

    @Test
    public void canGetTotalBill(){
        assertEquals(200, booking.totalBill());
    }
}
