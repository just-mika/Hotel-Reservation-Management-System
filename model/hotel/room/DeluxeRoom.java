package model.hotel.room;

import model.hotel.Hotel;

/**
 * Represents a Deluxe room in a hotel. This room's price is 20% higher compared to a Standard room.
 */
public class DeluxeRoom extends Room{
    /**
     * Constructs a new Deluxe Room.
     *
     * @param hotel the hotel to which the room belongs.
     * @throws NullPointerException if the hotel is null.
     */
    public DeluxeRoom(Hotel hotel){
        super(hotel); //Instantiate a new room through the Room class
        this.roomName = 201 + hotel.getRoomManager().countRooms("Deluxe");
        //Automated naming for room. Use 201 as a base, then add depending on the current number of Deluxe rooms.
        this.roomPrice += this.roomPrice * 0.20; //Add 20% of the base price to the current price.
    }

    /**
     * Sets the price for the Deluxe room.
     *
     * @param roomPrice the base value to be set as the price.
     * @throws IllegalArgumentException if the roomPrice is less than 100.0.
     */
    public void setRoomPrice(double roomPrice) {
        if(roomPrice < 100.0)
            throw new IllegalArgumentException("roomPrice cannot be less than 100.0!");
        this.roomPrice = roomPrice + (roomPrice * 0.20); //Take the new price and add 20% of it.
    }

    /**
     * Gets the type of this room.
     *
     * @return the room type of the Room instance.
     */
    public String getRoomType(){
        return "Deluxe";
    }
}
