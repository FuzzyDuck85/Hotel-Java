public class Booking {
    private Bedroom bedroom;
    private int nightsBooked;

    public Booking(Bedroom bedroom, int nightsBooked){
        this.bedroom = bedroom;
        this.nightsBooked = nightsBooked;
    }

    public int totalBill(){
        return this.bedroom.getRate() * this.nightsBooked;
    }



}
