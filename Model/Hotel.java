import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a hotel, managing its rooms and reservations.
 * It provides methods to add/remove rooms, manage reservations, and compute earnings.
 */
public class Hotel {
    private String hotelName; //attribute for hotel name
    private RoomManager roomManager; //manager for the room
    private ReservationManager reservationManager; //manager for the reservation
    private DatePriceManager datePriceManager; //manager for the date price rates
    private double basePrice; //attribute for the room base price

    /**
     * Constructs a new `Hotel` with the specified name.
     * Initializes the room list, reservation list, and default room price.
     *
     * @param name The name of the hotel.
     */
    public Hotel(String name) {
        if(name == null)
            throw new NullPointerException("Name cannot be null!");
        this.hotelName = name; //set name
        //initialize the following Arraylists
        this.roomManager = new RoomManager();
        this.reservationManager = new ReservationManager();
        this.datePriceManager = new DatePriceManager();
        this.basePrice = 1299.0; //set default base price to 1299.0

        //add one room for each type
        this.roomManager.addRoom(this, "Standard");
        this.roomManager.addRoom(this, "Deluxe");
        this.roomManager.addRoom(this, "Executive");
    }

    /**
     * Computes the total earnings from all reservations in the hotel.
     *
     * @return The total earnings.
     */
    public double computeEarnings() {
        double totalEarnings = 0.0; //declare variable for total earnings
        for (Reservation reservation : reservationManager.getReserveList()) {
            totalEarnings += reservation.computeTotalPrice(this);// Sum up the total price of all reservations
        }
        return totalEarnings; //return the resulting amount
    }

    /**
     * Gets the name of the hotel.
     *
     * @return The name of the hotel.
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets the name of the hotel.
     *
     * @param hotelName The edited name of the hotel.
     */
    public void setHotelName(String hotelName) {
        if(hotelName == null)
            throw new IllegalArgumentException("Hotel name cannot be null.");
        this.hotelName = hotelName;
    }

    /**
     * Gets the base price of a room.
     *
     * @return The base price of a room.
     */
    public double getBasePrice(){
        return basePrice;
    }

    /**
     * Sets the base price of the hotel's rooms.
     *
     * @param price The new price of the room.
     */
    public void setBasePrice(double price) {
        if(price < 100.0)
            throw new IllegalArgumentException("Base Price cannot be less than 100.0!");
        this.basePrice = price;
    }

    public RoomManager getRoomManager(){
        return this.roomManager;
    }
    public ReservationManager getReservationManager(){
        return this.reservationManager;
    }

    public DatePriceManager getDatePriceManager(){
        return this.datePriceManager;
    }
}
