import java.util.ArrayList;

public class Bedroom {
    private int roomNumber;
    private int capacity;
    private ArrayList<Guest> guests;
    private String type;
    private int rate;

    public Bedroom(int roomNumber, int capacity, String type, int rate){
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
        this.type = type;
        this.rate = rate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getRate() {
        return rate;
    }

    public int guestCount(){
        return this.guests.size();
    }

    public boolean checkCapacity(){
        return this.capacity > this.guestCount();
    }

    public boolean add(ArrayList<Guest> guests){
        int numberOfGuests = guests.size();
        if (this.checkAvailability()) {
            if(numberOfGuests <= this.capacity) {
                this.guests = guests;
                return true;
            }
        }
        return false;
    }

    public boolean checkAvailability(){
        return this.guestCount() == 0;
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
