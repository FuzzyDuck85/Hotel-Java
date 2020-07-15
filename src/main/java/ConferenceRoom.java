import java.util.ArrayList;

public class ConferenceRoom {
    private String name;
    private int capacity;
    private ArrayList<Guest> guests;

    public ConferenceRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
    }

    public int guestCount(){
        return this.guests.size();
    }

    public boolean checkCapacity(){
        return this.capacity > this.guestCount();
    }

    public void add(Guest guest){
        if (this.checkCapacity()) {
            this.guests.add(guest);
        }
    }

    public boolean checkGuest(Guest guest){
        return this.guests.contains(guest);
    }

    public void checkOut(Guest guest){
        if (this.checkGuest(guest)) {
            this.guests.remove(guest);
        }
    }

    public void checkOutAll(){
        this.guests.clear();
    }
}
