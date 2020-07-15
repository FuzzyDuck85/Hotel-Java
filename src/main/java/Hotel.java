import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private HashMap<String, DiningRoom> diningRooms;

    public Hotel(String name){
        this.name = name;
        this.bedrooms = new ArrayList<Bedroom>();
        this.conferenceRooms = new ArrayList<ConferenceRoom>();
        this.diningRooms = new HashMap<String, DiningRoom>();
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

    public boolean checkInToBedroom(ArrayList<Guest> guests, Bedroom bedroom){
       return bedroom.add(guests);
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

    public void addDiningRoom(DiningRoom diningRoom){
        this.diningRooms.put(diningRoom.getName(), diningRoom);
    }

    public int countDiningRooms(){
        return this.diningRooms.size();
    }

    public ArrayList<Bedroom> getEmptybedrooms(){
        ArrayList<Bedroom> emptyRooms = new ArrayList<Bedroom>();
        for(int i = 0; i < this.countBedrooms(); i++){
            if(this.bedrooms.get(i).guestCount() == 0) {
                emptyRooms.add(this.bedrooms.get(i));
            }
        }
        return emptyRooms;
    }

    public void fireAlarm(){
        for (int i = 0; i < this.countBedrooms(); i++){
            this.bedrooms.get(i).checkOutAll();
        }
        for (int i =0; i < this.countConferenceRooms(); i++){
            this.conferenceRooms.get(i).checkOutAll();
        }
        for(Map.Entry<String, DiningRoom> entry : this.diningRooms.entrySet()){
            entry.getValue().removeAll();
        }
    }
}
