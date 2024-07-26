import java.util.ArrayList;
import java.util.List;

/**
 * Manages the list of rooms in a hotel.
 */

public class RoomManager {
    private ArrayList<Room> roomList; //attribute for the list of rooms

    /**
     * Constructs a room manager.
     */
    public RoomManager(){
        this.roomList = new ArrayList<Room>();
    }

    /**
     * Adds a new room to the hotel.
     *
     * @param hotel the hotel to add a room to.
     * @param type the type of room to add.
     */
    public void addRoom(Hotel hotel, String type) {
        if(type == null)
            throw new NullPointerException("Room type cannot be null!");
        if(this.roomList.size() == 50)
            throw new IllegalArgumentException("No. of rooms cannot exceed 50.");
        Room newRoom;
        //create a new room based on the given type
        if(type.equals("Standard"))
            newRoom = new StandardRoom(hotel);
        else if(type.equals("Deluxe"))
            newRoom = new DeluxeRoom(hotel);
        else if(type.equals("Executive"))
            newRoom = new ExecutiveRoom(hotel);
        else
            throw new IllegalArgumentException("Room type does not exist.");
        roomList.add(newRoom); //add the new room to the list.
    }

    /**
     * Finds the index of a room by its name.
     *
     * @param roomName The name of the room to find.
     * @return The room itself if it is found; 'null' if not found.
     */
    public Room findRoom(int roomName){
        if(roomName < 101 || roomName > 350)
            throw new IllegalArgumentException("Invalid room name!");
        for(Room room : roomList){
            if(room.getRoomName() == roomName) //check each room if it matches the given room name.
                return room;
        }
        return null;
    }

    /**
     * Removes a room from the hotel.
     *
     * @param roomType the type of room to remove.
     */
    public void removeRoom(String roomType) {
        if(roomType == null)
            throw new NullPointerException("Room type cannot be null!");
        if(!(roomType.equals("Standard") || roomType.equals("Deluxe") || roomType.equals("Executive")))
            throw new IllegalArgumentException("Room type does not exist.");
        if(this.roomList.size() == 1)
            throw new IllegalArgumentException("No. of rooms cannot be less than 1.");
        int index = -1;
        for (int i = roomList.size() - 1; i >= 0; i--) {
            //checks if the room has no current reservations and the room type matches
            if (roomList.get(i).computeReservedDates() == 0 && roomType.equals(roomList.get(i).getRoomType())) {
                index = i; //get index and terminate loop
                break;
            }
        }
        if (index != -1) {//if found, returns the index of the room to be removed
            roomList.remove(index);
        }
    }

    /**
     * Gets the total number of rooms in the hotel with a given type.
     *
     * @param type the type of room to count.
     * @return The total number of rooms of the given type.
     */
    public int countRooms(String type){
        if(type == null)
            throw new NullPointerException("Room type cannot be null.");
        if(!(type.equals("Standard") || type.equals("Deluxe") || type.equals("Executive")))
            throw new IllegalArgumentException("Room type does not exist.");
        int ctr = 0;
        for(Room room : roomList){
            if(type.equals(room.getRoomType()))
                ctr++; //increment counter if current room is the given type
        }
        return ctr; //return resulting value
    }

    /**
     * Checks if the hotel is fully booked for all dates (1-31).
     *
     * @return `true` if all rooms are fully booked; `false` otherwise.
     */
    public boolean isFullyBooked() {
        for (Room room : this.getRoomList()) {
            int ctr = 0; // Counter for booked days in a month
            for (int i = 0; i < 31; i++) { // Check if each day is booked/reserved
                if (room.getReservedDates()[i] != 0) {
                    ctr++; //add to counter if date is reserved
                }
            }
            if (ctr != 30) {// If any room is not fully booked for the month, return false
                return false;
            }
        }
        return true;// All rooms are fully booked
    }

    /**
     * Computes the number of available rooms for a given date, regardless of its type.
     *
     * @param date The date to check for availability.
     * @return The number of total available rooms.
     */
    public int countAvailableRooms(int date) {
        if(date < 1 || date > 31)
            throw new IllegalArgumentException("Date not within the range of 1 to 31!");
        int AvailableNum = 0; //declare counter
        for (Room room : roomList) {
            if (room.isAvailable(date)) { // Check each room's availability for the given date
                AvailableNum++; //if its available, increment
            }
        }
        return AvailableNum; //return resulting number
    }

    /**
     * Computes the number of available rooms for a given date with a specified room type.
     *
     * @param date The date to check for availability.
     * @param type the type of room to count.
     * @return The number of total available rooms of the given type.
     */
    public int countAvailableRooms(int date, String type) {
        if(date < 1 || date > 31)
            throw new IllegalArgumentException("Date not within the range of 1 to 31!");
        if(type == null)
            throw new NullPointerException("Room type cannot be null.");
        if(!(type.equals("Standard") || type.equals("Deluxe") || type.equals("Executive")))
            throw new IllegalArgumentException("Room type does not exist.");

        int AvailableNum = 0; //declare counter
        for (Room room : roomList) {
            //Check each room of the given type's availability for the given date
            if (room.isAvailable(date) && type.equals(room.getRoomType())) {
                AvailableNum++; //if it is available, increment
            }
        }
        return AvailableNum; //return resulting number
    }

    /**
     * Computes the number of booked rooms for a given date, regardless of its type.
     *
     * @param date The date to check for bookings.
     * @return The number of booked rooms.
     */
    public int countBookedRooms(int date) {
        if(date < 1 || date > 31)
            throw new IllegalArgumentException("Date not within the range of 1 to 31!");
        int BookedNum = 0; //declare counter
        for (Room room : roomList) {
            if (!room.isAvailable(date)) { // Check each room's booking status for the given date
                BookedNum++;  //if it is NOT available, increment
            }
        }
        return BookedNum; //return resulting number
    }

    /**
     * Computes the number of booked rooms for a given date with a specified room type.
     *
     * @param date The date to check for bookings.
     * @param type the type of room to count.
     * @return The number of total booked rooms of the given type.
     */
    public int countBookedRooms(int date, String type) {
        if(date < 1 || date > 31)
            throw new IllegalArgumentException("Date not within the range of 1 to 31!");
        if(type == null)
            throw new NullPointerException("Room type cannot be null.");
        if(!(type.equals("Standard") || type.equals("Deluxe") || type.equals("Executive")))
            throw new IllegalArgumentException("Room type does not exist.");

        int BookedNum = 0; //declare counter
        for (Room room : roomList) {
            if (!room.isAvailable(date) && type.equals(room.getRoomType())) { // Check each room's booking status for the given date
                BookedNum++; //if it is NOT available, increment
            }
        }
        return BookedNum; //return resulting number
    }

    /**
     * Counts the number of unreserved rooms in the hotel, regardless of its type.
     *
     * @return The number of unreserved rooms.
     */
    public int countUnreservedRooms() {
        int ctr = 0; //declare counter
        for (Room room : roomList) {
            if (room.computeReservedDates() == 0) { //if reserved dates equal to 0, counts it
                ctr++; //increment
            }
        }
        return ctr; //return resulting value
    }

    /**
     * Counts the number of unreserved rooms in the hotel with a specified room type.
     *
     * @param type the type of room to count.
     * @return The number of unreserved rooms.
     */
    public int countUnreservedRooms(String type) {
        if(type == null)
            throw new NullPointerException("Room type cannot be null.");
        if(!(type.equals("Standard") || type.equals("Deluxe") || type.equals("Executive")))
            throw new IllegalArgumentException("Room type does not exist.");

        int ctr = 0; //declare counter
        for (Room room : roomList) {
            if (room.computeReservedDates() == 0 && type.equals(room.getRoomType())) { //if reserved dates equal to 0, counts it
                ctr++; //increment
            }
        }
        return ctr; //return resulting value
    }

    /**
     * Gets the list of rooms in the hotel.
     *
     * @return The list of rooms.
     */
    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    public List<Room> getAvailableRooms(int date) {
    if (date < 1 || date > 31)
        throw new IllegalArgumentException("Date not within the range of 1 to 31!");
    List<Room> availableRooms = new ArrayList<>();
    for (Room room : roomList) {
        if (room.isAvailable(date)) {
            availableRooms.add(room);
        }
    }
    return availableRooms;
}
}
