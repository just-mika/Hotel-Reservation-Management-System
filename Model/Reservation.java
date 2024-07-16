/**
 * Represents a reservation for a hotel room.
 */

public class Reservation {
    protected final String guestName; //attribute representing guest's name
    protected final Room room; //attribute representing the reserved room
    protected final int checkInDate; //attribute representing the check-in date
    protected final int checkOutDate; //attribute representing the check-out date

    /**
     * Constructs a new reservation.
     *
     * @param guestName    the name of the guest making the reservation
     * @param room         the room being reserved
     * @param checkInDate  the check-in date (simplified to a single int value representing to the day)
     * @param checkOutDate the check-out date (simplified to a single int value representing to the day)
     */
    public Reservation(String guestName, Room room, int checkInDate, int checkOutDate){
        if(checkInDate == checkOutDate)
            throw new IllegalArgumentException("Check-in date cannot be equal to check-out date!");
        if(checkInDate > checkOutDate)
            throw new IllegalArgumentException("Check-in date must be less than check out date!");
        if(checkInDate < 1 || checkInDate > 30)
            throw new IllegalArgumentException("Check-in date not within the range of 1 to 30!");
        if(checkOutDate > 31)
            throw new IllegalArgumentException("Check-out date not within the range of 1 to 30!");

        if(room == null)
            throw new NullPointerException("Room cannot be null.");
        if(guestName == null)
            throw new NullPointerException("Guest name cannot be null.");

        //Set the attributes to the respective parameters
        this.guestName = guestName;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        //Add reserved dates to the room's record.
        this.room.addReservedDates(this);
    }

    /**
     * Gets the name of the guest who made the reservation.
     *
     * @return the guest's name
     */
    public String getGuestName(){
        return guestName;
    }

    /**
     * Gets the reserved room of the reservation.
     *
     * @return the room
     */
    public Room getRoom(){
        return room;
    }

    /**
     * Gets the check-in date (day) of the reservation.
     *
     * @return the check-in date
     */
    public int getCheckInDate(){
        return checkInDate;
    }

    /**
     * Gets the check-out date (day) of the reservation.
     *
     * @return the check-out date
     */
    public int getCheckOutDate(){
        return checkOutDate;
    }

    /**
     * Gets the reservation's price on a given date.
     *
     * @param date  the given date.
     * @param hotel the hotel the reservation belongs to.
     * @return the price of the reservation on the given date.
     */
    public double getDatePrice(int date, Hotel hotel){
        if(date < 1 || date > 31)
            throw new IllegalArgumentException("Date not within the range of 1 to 31!");
        if(hotel == null)
            throw new NullPointerException("Hotel can't be null!");
        return room.getRoomPrice() * hotel.findDate(date).getRate();
    }

    /**
     * Computes the current total price of the reservation. The price may change due to the date price modifier function.
     *
     * @param hotel the hotel the reservation belongs to.
     * @return the total computed price of the reservation.
     */
    public double computeTotalPrice(Hotel hotel){
        if(hotel == null)
            throw new NullPointerException("Hotel cannot be null!");
        double total = 0.0; //declare variable for the total price
        for(int i = checkInDate; i < checkOutDate; i++){
            total += this.getDatePrice(i, hotel); //add up the total price of the reservation
        }
        return total; //return the resulting value
    }

}
