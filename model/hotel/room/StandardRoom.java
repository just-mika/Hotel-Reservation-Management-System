package model.hotel.room;

import model.hotel.Hotel;

/**
 * Represents a Standard room in a hotel.
 */
public class StandardRoom extends Room {
    /**
     * Constructs a new Standard Room.
     *
     * @param hotel the hotel to which the room belongs.
     * @throws NullPointerException if the hotel is null.
     */
    public StandardRoom(Hotel hotel){
        super(hotel); //Instantiate a new room through the Room class
        this.roomName = 101 + hotel.getRoomManager().countRooms("Standard");
        //Automated naming for room. Use 101 as a base, then add depending on the current number of Standard rooms.
    }

    /**
     * Sets the price for the Standard room.
     *
     * @param roomPrice the value to be set as the price.
     * @throws IllegalArgumentException if the roomPrice is less than 100.0.
     */
    public void setRoomPrice(double roomPrice) {
        if(roomPrice < 100.0)
            throw new IllegalArgumentException("roomPrice cannot be less than 100.0!");
        this.roomPrice = roomPrice;
    }

    /**
     * Gets the type of this room.
     *
     * @return the room type of the Room instance.
     */
    public String getRoomType(){
        return "Standard";
    }
}
