import java.util.ArrayList;
import java.util.HashMap;

public class DiningRoom {
    private String name;
    private ArrayList<Guest> guests;

    public DiningRoom(String name){
        this.name = name;
        this.guests = new ArrayList<Guest>();
    }

    public String getName() {
        return name;
    }

    public int countGuests(){
        return this.guests.size();
    }

    public boolean checkGuest(Guest guest){
        return this.guests.contains(guest);
    }

    public void add(Guest guest){
        this.guests.add(guest);
    }

    public void remove(Guest guest){
        if (this.checkGuest(guest)) {
            this.guests.remove(guest);
        }
    }
}

