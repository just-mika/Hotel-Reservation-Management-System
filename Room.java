/**
 * Represents a room of a hotel. Serves as a template for the different types of rooms.
 */
public abstract class Room {
    protected int roomName; //attribute for the room's name
    protected double roomPrice; // attribute for the room's price
    private int[] reservedDates; //array of integers that serves as a record of the room's reserved dates.
    //(E.g. If only Day 1 is reserved, reservedDates[0] = 1 and reservedDates[1] onwards is 0.)

    /**
     * Constructs a new Room.
     *
     * @param hotel the hotel the room belongs to.
     */
    public Room(Hotel hotel) {
        if(hotel == null)
            throw new NullPointerException("Hotel can't be null!");
        this.reservedDates = new int[31]; //Create a new array of integers w/ size 31 (indicating 31 days)
        this.roomPrice = hotel.getBasePrice(); //Needs hotel's current room price.
    }

    /**
     * Sets the room's price with a given value.
     *
     * @param roomPrice the value to be set as the price.
     */
    public abstract void setRoomPrice(double roomPrice);

    /**
     * Gets the room's respective type.
     *
     * @return the room type of the Room instance.
     */
    public abstract String getRoomType();

    /**
     * Gets the room's name.
     *
     * @return the name of the Room instance.
     */
    public int getRoomName() {
        return roomName;
    }

    /**
     * Gets the room's base price.
     *
     * @return the Room's base price.
     */
    public double getRoomPrice() {
        return roomPrice;
    }

    /**
     * Gets the room's record of reserved dates.
     *
     * @return the array of reserved dates of the Room Instance.
     */
    public int[] getReservedDates() {
        return reservedDates;
    }

    /**
     * Computes the number of dates the Room instance is reserved for.
     *
     * @return the total number of reserved dates.
     */
    public int computeReservedDates() {
        int ctr = 0; //declare a counter
        for (int i = 0; i < 31; i++) { //for loop to go through the array
            if (reservedDates[i] != 0) //increase count if current date is reserved.
                ctr++;
        }
        return ctr; //return resulting count
    }

    /**
     * Checks if the Room instance is available at a particular date.
     *
     * @param date the given date to check the Room for
     * @return true if it is available at the given date, false otherwise.
     */
    public boolean isAvailable(int date) {
        if(date < 1 || date > 31)
            throw new IllegalArgumentException("Date not within the range of 1 to 31!");
        return reservedDates[date - 1] == 0; //return the resulting boolean value.
    }

    /**
     * Adds/Records dates in the Room's records for reservation.
     *
     * @param reserve the given Reservation to be added.
     */
    public void addReservedDates(Reservation reserve) {
        if(reserve == null)
            throw new NullPointerException("Reservation cannot be null.");
        for (int i = reserve.getCheckInDate(); i < reserve.getCheckOutDate(); i++)
            reservedDates[i - 1] = 1; //sets current date's index into 1 to indicate said date is reserved.
    }

    /**
     * Removes recorded dates in the Room's records for reservation.
     *
     * @param reserve the given Reservation to be removed.
     */
    public void removeReservedDates(Reservation reserve) {
        if(reserve == null)
            throw new IllegalArgumentException("Reservation cannot be null.");
        if (this.computeReservedDates() != 0) { //only execute if there are reserved dates recorded.
            for (int i = reserve.getCheckInDate(); i < reserve.getCheckOutDate(); i++)
                reservedDates[i - 1] = 0; //sets current date's index into 0 to indicate said date is no longer reserved.
        }
    }
}
