import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    public Hotel(String name){
        this.name = name;
        this.bedrooms = new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
    }

    public String getName() {
        return name;
    }

    public void addBedroom(Bedroom bedroom){
        this.bedrooms.add(bedroom);
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom){
        this.conferenceRooms.add(conferenceRoom);
    }

    public boolean checkInToBedroom(Guest guest, Bedroom bedroom){
       return bedroom.add(guest);
    }

    public void checkOutOfBedroom(Guest guest, Bedroom bedroom){
        bedroom.checkOut(guest);
    }

    public void checkOutAllGuestsBedroom(Bedroom bedroom){
        bedroom.checkOutAll();
    }

    public void checkInToConferenceRoom(Guest guest, ConferenceRoom conferenceRoom){
        conferenceRoom.add(guest);
    }

    public void checkOutOfConferenceRoom(Guest guest, ConferenceRoom conferenceRoom){
        conferenceRoom.checkOut(guest);
    }

    public int countBedrooms(){
        return this.bedrooms.size();
    }

    public int countConferenceRooms(){
        return this.conferenceRooms.size();
    }

    public void checkOutAllGuestsConferenceRoom(ConferenceRoom conferenceRoom){
        conferenceRoom.checkOutAll();
    }

    public Booking bookRoom(Bedroom bedroom, int nightsBooked){
       Booking booking = new Booking(bedroom, nightsBooked);
       return booking;
    }
}
