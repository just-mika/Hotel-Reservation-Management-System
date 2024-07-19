import java.util.ArrayList;

/**
 * Represents a hotel, managing its rooms and reservations.
 * It provides methods to add/remove rooms, manage reservations, and compute earnings.
 */
public class Hotel {
    private String hotelName; //attribute for hotel name
    private ArrayList<Room> roomList; //attribute for the list of rooms
    private ArrayList<Reservation> reserveList; //attribute for list of reservations
    private ArrayList<DatePriceRate> datePriceRateList; //attribute for list of date price rates
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
        this.roomList = new ArrayList<Room>();
        this.reserveList = new ArrayList<Reservation>();
        this.datePriceRateList = new ArrayList<DatePriceRate>();
        this.basePrice = 1299.0; //set default base price to 1299.0

        //instantiate all dates.
        for(int i = 0; i < 31; i++){
            DatePriceRate datePriceRate = new DatePriceRate(i + 1);
            datePriceRateList.add(datePriceRate);
        }

        //add one room for each type
        this.addRoom("Standard");
        this.addRoom("Deluxe");
        this.addRoom("Executive");
    }

    /**
     * Adds a new room to the hotel.
     *
     * @param type the type of room to add.
     */
    public void addRoom(String type) {
        if(type == null)
            throw new NullPointerException("Room type cannot be null!");
        if(this.roomList.size() == 50)
            throw new IllegalArgumentException("No. of rooms cannot exceed 50.");
        Room newRoom;
        //create a new room based on the given type
        if(type.equals("Standard"))
            newRoom = new StandardRoom(this);
        else if(type.equals("Deluxe"))
            newRoom = new DeluxeRoom(this);
        else if(type.equals("Executive"))
            newRoom = new ExecutiveRoom(this);
        else
            throw new IllegalArgumentException("Room type does not exist.");
        roomList.add(newRoom); //add the new room to the list.
    }

    /**
     * Gets the total number of rooms in the hotel with a given type.
     *
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
     * Computes the total earnings from all reservations in the hotel.
     *
     * @return The total earnings.
     */
    public double computeEarnings() {
        double totalEarnings = 0.0; //declare variable for total earnings
        for (Reservation reservation : reserveList) {
            totalEarnings += reservation.computeTotalPrice(this);// Sum up the total price of all reservations
        }
        return totalEarnings; //return the resulting amount
    }

    /**
     * Adds a reservation to the hotel for a specified guest and date range.
     *
     * @param guestName The name of the guest.
     * @param checkInDate The check-in date.
     * @param checkOutDate The check-out date.
     * @param roomType the type of room to be reserved
     * @return `true` if the reservation was successfully added; `false` otherwise.
     */
    public boolean addReservation(String guestName, int checkInDate, int checkOutDate, String roomType){
        if(checkInDate == checkOutDate)
            throw new IllegalArgumentException("Check-in date cannot be equal to check-out date!");
        if(checkInDate > checkOutDate)
            throw new IllegalArgumentException("Check-in date must be less than check out date!");
        if(checkInDate < 1 || checkInDate > 30)
            throw new IllegalArgumentException("Check-in date not within the range of 1 to 30!");
        if(checkOutDate > 31)
            throw new IllegalArgumentException("Check-out date not within the range of 1 to 30!");

        if(guestName == null)
            throw new NullPointerException("Guest name cannot be null.");
        if(roomType == null)
            throw new NullPointerException("Room type cannot be null.");
        if(!(roomType.equals("Standard") || roomType.equals("Deluxe") || roomType.equals("Executive")))
            throw new IllegalArgumentException("Room type does not exist.");

        int index = lookForRoom(checkInDate, checkOutDate, roomType);
        if(index != -1)
            return reserveList.add(new Reservation(guestName, roomList.get(index), checkInDate, checkOutDate));
        else
            return false;
    }

    /**
     * Adds a reservation to the hotel for a specified guest and date range with a given discount code.
     *
     * @param guestName The name of the guest.
     * @param checkInDate The check-in date.
     * @param checkOutDate The check-out date.
     * @param roomType the type of room to be reserved
     * @param discount The discount code the guest used.
     * @return `true` if the reservation was successfully added; `false` otherwise.
     */
    public boolean addReservation(String guestName, int checkInDate, int checkOutDate, String roomType, String discount){
        if(checkInDate == checkOutDate)
            throw new IllegalArgumentException("Check-in date cannot be equal to check-out date!");
        if(checkInDate > checkOutDate)
            throw new IllegalArgumentException("Check-in date must be less than check out date!");
        if(checkInDate < 1 || checkInDate > 30)
            throw new IllegalArgumentException("Check-in date not within the range of 1 to 30!");
        if(checkOutDate > 31)
            throw new IllegalArgumentException("Check-out date not within the range of 1 to 30!");

        if(guestName == null)
            throw new NullPointerException("Guest name cannot be null.");
        if(roomType == null)
            throw new NullPointerException("Room type cannot be null.");
        if(!(roomType.equals("Standard") || roomType.equals("Deluxe") || roomType.equals("Executive")))
            throw new IllegalArgumentException("Room type does not exist.");
        if(discount == null)
            throw new NullPointerException("Discount cannot be null!");
        if(!(discount.equals("I_WORK_HERE") || discount.equals("STAY4_GET1") || discount.equals("PAYDAY")))
            throw new IllegalArgumentException("Discount code does not exist.");

        int index = lookForRoom(checkInDate, checkOutDate, roomType);
        if(index != -1)
            return reserveList.add(new DiscountedReservation(guestName, roomList.get(index), checkInDate, checkOutDate, discount));
        else
            return false;
    }

    /**
     * Finds the reservation by the guest's name.
     *
     * @param guestName The name of the guest.
     * @return The reservation if found; `null` otherwise.
     */
    public Reservation findReservation(String guestName) {
        if(guestName == null)
            throw new NullPointerException("Guest name cannot be null.");
        for (Reservation reservation : reserveList) {
            if (guestName.equals(reservation.getGuestName())) {
                return reservation; //return the reservation that matches guest name
            }
        }
        return null;
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
     * Removes a reservation by the guest's name.
     *
     * @param guestName The name of the guest.
     * @return 'true' if reservation is found and removed; `false` otherwise.
     */
    public boolean removeReservation(String guestName) {
        if(guestName == null)
            throw new NullPointerException("Guest name cannot be null.");
        Reservation removedReserve = this.findReservation(guestName); //find the reservation by guest name
        if(removedReserve != null){ //if found, removed reserved dates of the reservation to its room
            removedReserve.getRoom().removeReservedDates(removedReserve);
            return reserveList.remove(removedReserve); //remove reservation itself
        }
        return false; //if not found
    }

    /**
     * Finds the date price rate by a given date.
     *
     * @param date the given date to find in the list.
     * @return the date price rate of the given date; 'null' otherwise.
     */
    public DatePriceRate findDate(int date) {
        for (DatePriceRate datePriceRate : datePriceRateList) {
            if (datePriceRate.getDate() == date) {
                return datePriceRate; //return the datePriceRate of the given date.
            }
        }
        return null;
    }

    /**
     * Changes the price rate of a given date.
     *
     * @param date the given date to change the rate of.
     * @param rate the new rate value.
     */
    public void changeDatePrice(int date, double rate){
        if(date < 1 || date > 31)
            throw new IllegalArgumentException("Date not within the range of 1 to 31!");
        if(rate < 0.0)
            throw new IllegalArgumentException("Rate cannot be negative!");
        if(this.findDate(date) != null) //if date is found, set rate.
            findDate(date).setRate(rate);
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
     * Gets the list of rooms in the hotel.
     *
     * @return The list of rooms.
     */
    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    /**
     * Gets the total number of rooms in the hotel, regardless of their type.
     *
     * @return The total number of rooms.
     */
    public int getTotalRooms() {
        return roomList.size();
    }

    /**
     * Gets the list of reservations in the hotel.
     *
     * @return The list of reservations.
     */
    public ArrayList<Reservation> getReserveList() {
        return reserveList;
    }

    /**
     * Gets the total number of reservations in the hotel.
     *
     * @return The total number of reservations.
     */
    public int getTotalReservations() {
        return reserveList.size();
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
     * Gets the list of dates with their price rates.
     *
     * @return The list of DatePriceRates
     */
    public ArrayList<DatePriceRate> getDatePriceRateList(){
        return datePriceRateList;
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

    //helper function to look for the room
    private int lookForRoom(int checkInDate, int checkOutDate, String roomType) {
        int dateCount = checkOutDate - checkInDate + 1;
        for (int i = 0; i < roomList.size(); i++) {
            int ctr = 0;
            if (dateCount + roomList.get(i).computeReservedDates() > 31 && !roomType.equals(roomList.get(i).getRoomType()))
                continue; //skip iteration if reservation exceeds reserved dates AND not the same room type
            else {
                for (int date = checkInDate; date <= checkOutDate; date++) {
                    if (roomList.get(i).isAvailable(date) && roomType.equals(roomList.get(i).getRoomType())) //check if room is available for ALL dates
                        ctr++;
                }
                if (ctr == dateCount)
                    return i; //return index if it is available for all dates
            }
        }
        return -1; //return -1 if not
    }
}
