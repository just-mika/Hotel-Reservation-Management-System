package model.hotel.reservation;

import model.hotel.Hotel;
import model.hotel.room.*;


/**
 * Represents a discounted reservation for a hotel room.
 */

public class DiscountedReservation extends Reservation {
    private String discount; //attribute for the discount code

    /**
     * Constructs a new discounted reservation.
     *
     * @param guestName    the name of the guest making the reservation
     * @param room         the room being reserved
     * @param checkInDate  the check-in date (simplified to a single int value representing the day)
     * @param checkOutDate the check-out date (simplified to a single int value representing the day)
     * @param discount     the type of discount applied to the reservation
     * @throws IllegalArgumentException if the discount code does not exist
     * @throws NullPointerException     if the room or guest name is null
     */
    public DiscountedReservation(String guestName, Room room, int checkInDate, int checkOutDate, String discount){
        super(guestName, room, checkInDate, checkOutDate); //Instantiate a new reservation through the Reservation class
        if(!(discount.equals("I_WORK_HERE") || discount.equals("STAY4_GET1") || discount.equals("PAYDAY")))
            throw new IllegalArgumentException("Discount code does not exist.");
        this.discount = discount; //set the discount as the given discount code.
    }

    /**
     * Gets the discount code.
     *
     * @return the discount code used by the guest
     */
    public String getDiscountCode(){
        return discount;
    }

    /**
     * Gets the reservation's price on a given date, with a different implementation for discounts.
     *
     * @param date  the given date
     * @param hotel the hotel the reservation belongs to
     * @return the price of the reservation on the given date
     * @throws IllegalArgumentException if the date is not within the range of 1 to 31
     * @throws NullPointerException     if the hotel is null
     */
    @Override
    public double getDatePrice(int date, Hotel hotel){
        if(date < 1 || date > 31)
            throw new IllegalArgumentException("Date not within the range of 1 to 31!");
        if(hotel == null)
            throw new NullPointerException("Hotel can't be null!");

        if(discount.equals("STAY4_GET1") && date == checkInDate){
            return 0.0; //Check-in date is free if the STAY4_GET1 code is applied.
        }
        return room.getRoomPrice() * hotel.getDatePriceManager().findDate(date).getRate();
    }

    /**
     * Computes the current total price of the reservation, applying the respective discount.
     *
     * @param hotel the hotel the reservation belongs to
     * @return the total computed price of the reservation
     * @throws NullPointerException if the hotel is null
     */
    @Override
    public double computeTotalPrice(Hotel hotel){
        if(hotel == null)
            throw new NullPointerException("Hotel can't be null!");
        double total = 0.0; //declare variable for the total price
        //compute for the total price without discounts
        for(int i = checkInDate; i < checkOutDate; i++){
            total += this.getDatePrice(i, hotel);
        }
        if(discount.equals("I_WORK_HERE"))
            total -= total * 0.10; //I_WORK_HERE gives 10% off of the total price
        else if(discount.equals("PAYDAY")){
            total -= total * 0.07; //PAYDAY gives 7% off the total price
        }
        return total; //return the resulting price.
    }
}
