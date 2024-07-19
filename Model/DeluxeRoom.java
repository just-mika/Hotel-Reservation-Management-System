/**
 * Represents a Deluxe room in a hotel. This room's price is 20% higher compared to Standard room.
 */
public class DeluxeRoom extends Room{
    /**
     * Constructs a new Deluxe Room.
     *
     * @param hotel the hotel the room belongs to.
     */
    public DeluxeRoom(Hotel hotel){
        super(hotel); //Instantiate a new room through the Room class
        this.roomName = 201 + hotel.getRoomManager().countRooms("Deluxe");
        //Automated naming for room. Use 201 as a base, then add depending on the current number of Deluxe rooms.
        this.roomPrice += this.roomPrice * 0.20; //Add 20% of the base price to the current price.
    }

    /**
     * Sets the room's price for the Deluxe room with a given value.
     *
     * @param roomPrice the base value to be set as the price.
     */
    public void setRoomPrice(double roomPrice) {
        if(roomPrice < 100.0)
            throw new IllegalArgumentException("roomPrice cannot be less than 100.0!");
        this.roomPrice = roomPrice + (roomPrice * 0.20); //Take the new price and add 20% of it.
    }

    /**
     * Gets this room's respective type.
     *
     * @return the room type of the Room instance.
     */
    public String getRoomType(){
        return "Deluxe";
    }
}
