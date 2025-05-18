package model.hotel;

import model.hotel.room.*;
import model.hotel.reservation.*;
import model.hotel.dateprice.*;

/**
 * Represents a hotel, containing managers for its rooms, reservations, and date price rates.
 */
public class Hotel {
    private String hotelName; //attribute for hotel name
    private RoomManager roomManager; //manager for the room
    private ReservationManager reservationManager; //manager for the reservation
    private DatePriceManager datePriceManager; //manager for the date price rates
    private double basePrice; //attribute for the room base price

    /**
     * Constructs a new `Hotel` with the specified name.
     * Initializes the room manager, reservation manager, date price manager,
     * and sets a default base price for the rooms.
     *
     * @param name The name of the hotel.
     * @throws NullPointerException if the provided name is null.
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
     * @return The total earnings from reservations.
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
     * @param hotelName The new name of the hotel.
     * @throws IllegalArgumentException if the provided name is null.
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
     * @param price The new base price of the rooms.
     * @throws IllegalArgumentException if the provided price is less than 100.0.
     */
    public void setBasePrice(double price) {
        if(price < 100.0)
            throw new IllegalArgumentException("Base Price cannot be less than 100.0!");
        this.basePrice = price;
    }
    /**
     * Gets the hotel's room manager.
     *
     * @return The hotel's room manager.
     */
    public RoomManager getRoomManager(){
        return this.roomManager;
    }

    /**
     * Gets the hotel's reservation manager.
     *
     * @return The hotel's reservation manager.
     */
    public ReservationManager getReservationManager(){
        return this.reservationManager;
    }

    /**
     * Gets the hotel's date price rate manager.
     *
     * @return The hotel's date price rate manager.
     */
    public DatePriceManager getDatePriceManager(){
        return this.datePriceManager;
    }
}
