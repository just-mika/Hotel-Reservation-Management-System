package model.hotel.room;

import model.hotel.Hotel;

/**
 * Represents an Executive room in a hotel. This room's price is 35% higher compared to a Standard room.
 */
public class ExecutiveRoom extends Room{
    /**
     * Constructs a new Executive Room.
     *
     * @param hotel the hotel to which the room belongs.
     * @throws NullPointerException if the hotel is null.
     */
    public ExecutiveRoom(Hotel hotel) {
        super(hotel); //Instantiate a new room through the Room class
        this.roomName = 301 + hotel.getRoomManager().countRooms("Executive");
        //Automated naming for room. Use 301 as a base, then add depending on the current number of Executive rooms.
        this.roomPrice += this.roomPrice * 0.35; //Add 35% of the base price to the current price.
    }

    /**
     * Sets the price for the Executive room.
     *
     * @param roomPrice the base value to be set as the price.
     * @throws IllegalArgumentException if the roomPrice is less than 100.0.
     */
    public void setRoomPrice(double roomPrice) {
        if(roomPrice < 100.0)
            throw new IllegalArgumentException("roomPrice cannot be less than 100.0!");
        this.roomPrice = roomPrice + (roomPrice * 0.35); //Take the new price and add 35% of it.
    }

    /**
     * Gets the type of this room.
     *
     * @return the room type of the Room instance.
     */
    public String getRoomType(){
        return "Executive";
    }
}
