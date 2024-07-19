import java.util.ArrayList;
/**
 * Represents the reservation system that manages and modifies different hotels.
 */

public class ReservationSystem {
    private ArrayList<Hotel> hotelList; //attribute for the list of hotels

    /**
     * Constructs the reservation system.
     */
    public ReservationSystem(){
        this.hotelList = new ArrayList<Hotel>(); //instantiate the hotel list
    }

    /**
     * Gets the list of hotels.
     *
     * @return the list of hotels.
     */
    public ArrayList<Hotel> getHotelList(){
        return hotelList;
    }

    /**
     * Gets the number of hotels in the list.
     *
     * @return the number of hotels.
     */
    public int countHotels(){
        return hotelList.size();
    }


    /**
     * Selects a hotel by name.
     *
     * @param hotelName the name of the hotel to select.
     * @return the selected hotel, or null if no hotel with the specified name is found.
     */
    public Hotel selectHotel(String hotelName) {
        for (Hotel hotel : hotelList) { //check all hotels if they have the same name as the given
            if (hotel.getHotelName().equals(hotelName)) {
                return hotel; //return said hotel if found
            }
        }
        return null; //return null if not found
    }

    /**
     * Creates a new hotel with the specified name and adds it to the list if it doesn't already exist.
     *
     * @param hotelName the name of the hotel to create.
     * @return true if the hotel was created and added, false if a hotel with the same name already exists.
     */
    public boolean createHotel(String hotelName) {
        if (this.selectHotel(hotelName) == null)
            return hotelList.add(new Hotel(hotelName)); //only create hotel if hotel isn't already found in the list
        else
            return false;
    }

    /**
     * Changes the name of the selected hotel.
     *
     * @param hotel        the selected hotel
     * @param newHotelName the new name of the hotel
     */
    public boolean changeHotelName(Hotel hotel, String newHotelName){
        if(this.selectHotel(newHotelName) == null && hotel != null){
            hotel.setHotelName(newHotelName); //only change hotel name if the given name isn't already found in the list
            return true;
        }
        return false;
    }

    /**
     * Adds rooms to the selected hotel.
     *
     * @param hotel     the selected hotel
     * @param roomType  the type of room to add
     * @param quantity  the number of rooms to add
     * @return 'true' if the adding is successful; 'false' otherwise.
     */
    public boolean addRooms(Hotel hotel, String roomType, int quantity){
        if(hotel != null) {
            if (hotel.getRoomList().size() + quantity <= 50) { //only add if adding the rooms will not exceed the limit
                for (int i = 0; i < quantity; i++) {
                    hotel.addRoom(roomType);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a specified number of rooms from the selected hotel.
     *
     * @param hotel    the selected hotel
     * @param roomType the type of rooms to remove
     * @param quantity the number of rooms to remove
     * @return 'true' if rooms are successfully removed; 'false' otherwise.
     */
    public boolean removeRooms(Hotel hotel, String roomType, int quantity){
        if(hotel != null){ //only remove if the number of rooms to remove is less than the current amt of rooms
            if(hotel.getRoomList().size() - quantity > 1 && hotel.countRooms(roomType) - quantity >= 0){
                for(int i = 0; i < quantity; i++)
                    hotel.removeRoom(roomType);
                return true;
            }
        }
        return false;
    }

    /**
     * Changes the price of rooms in the selected hotel.
     *
     * @param hotel    the selected hotel
     * @param newPrice the new price to set the current base price to.
     * @return 'true' if the base price is successfully set; 'false' otherwise.
     */
    public boolean updateBasePrice(Hotel hotel, double newPrice){
        if(hotel != null) { //only change base price if it is greater than or equal to 100 and if current hotel has no reservations
            if (hotel.getReserveList().isEmpty() && newPrice >= 100) {
                hotel.setBasePrice(newPrice);
                //update the prices for all rooms
                for (Room room : hotel.getRoomList()) {
                    room.setRoomPrice(newPrice);
                }
                return true;
            }
        }
            return false;
    }

    /**
     * Modifies the price rate at a given rate in a hotel.
     *
     * @param hotel    the selected hotel
     * @param date     the date to modify
     * @param rate     the new price rate of the date
     * @return 'true' if the price rate is successfully set; 'false' otherwise.
     */
    public boolean modifyDatePrice(Hotel hotel, int date, double rate){
        if(hotel != null && hotel.findDate(date) != null && rate >= 0){
            //only change date if hotel and date exists and rate is not negative
            hotel.changeDatePrice(date, rate);
            return true;
        }
        return false;
    }


    /**
     * Adds a reservation to the hotel for a specified guest and date range.
     *
     * @param hotel        The selected hotel
     * @param guestName    The name of the guest.
     * @param checkInDate  The check-in date.
     * @param checkOutDate The check-out date.
     * @param roomType     The type of room to reserve
     * @return `true` if the reservation was successfully added; `false` otherwise.
     */
    public boolean reserveRoom(Hotel hotel, String guestName, int checkInDate, int checkOutDate, String roomType){
        int dateCount = checkOutDate - checkInDate + 1;
        //only reserve a room if hotel exists, guest has yet to reserve, and dateCount is not zero
        if(hotel != null && hotel.findReservation(guestName) == null && dateCount > 1)  {
            return hotel.addReservation(guestName, checkInDate, checkOutDate, roomType); //add reservation in the hotel
        }
        return false;
    }

    /**
     * Adds a reservation to the hotel for a specified guest and date range with a given discount code.
     *
     * @param hotel        The selected hotel
     * @param guestName    The name of the guest.
     * @param checkInDate  The check-in date.
     * @param checkOutDate The check-out date.
     * @param roomType     The type of room to reserve
     * @param discount     The discount code the guest used.
     * @return `true` if the reservation was successfully added, regardless if the discount is applied or not; `false` otherwise.
     */
    public boolean reserveRoom(Hotel hotel, String guestName, int checkInDate, int checkOutDate, String roomType, String discount){
        int dateCount = checkOutDate - checkInDate + 1;
        //only reserve a room if hotel exists, guest has yet to reserve, and dateCount is not zero
        if(hotel != null && hotel.findReservation(guestName) == null && dateCount > 1) {
            if(discount.equals("I_WORK_HERE"))
                return hotel.addReservation(guestName, checkInDate, checkOutDate, "I_WORK_HERE");
            else if(discount.equals("STAY4_GET1")){
                if(checkOutDate - checkInDate >= 5) //only apply discount if reservation has 5 days or more
                    return hotel.addReservation(guestName, checkInDate, checkOutDate, "STAY4_GET1");
            }
            else if(discount.equals("PAYDAY")){
                boolean applyDiscount = checkPayDay(checkInDate, checkOutDate); //helper function to check if 15 or 30 are in the dates
                if(applyDiscount) //only apply discount if discount is in there
                    return hotel.addReservation(guestName, checkInDate, checkOutDate, "PAYDAY");
            }
            //if not applied, just create a regular reservation
            return hotel.addReservation(guestName, checkInDate, checkOutDate, roomType);
        }
        return false;
    }

    /**
     * Removes a reservation from the selected hotel.
     *
     * @param hotel     the selected hotel
     * @param guestName the name of the guest who reserved the room
     * @return 'true' if a reservation is successfully removed; 'false' otherwise.
     */
    public boolean removeReservation(Hotel hotel, String guestName){
        if(hotel != null && hotel.findReservation(guestName) != null) { //only remove reservation if the given hotel is found
            return hotel.removeReservation(guestName); //return the resulting boolean value
        }
        return false;
    }

    /**
     * Removes a hotel from the hotel list.
     *
     * @param hotelName the name of the hotel to be removed.
     * @return 'true' if a hotel is successfully removed; 'false' otherwise.
     */
    public boolean removeHotel(String hotelName) {
        for (Hotel hotel : hotelList) { //find hotel with the same name as the given hotelName in the list
            if (hotel.getHotelName().equals(hotelName)) {
                return hotelList.remove(hotel); //remove hotel if it is found.
            }
        }
        return false;
    }

    //helper function to check if PAYDAY discount can be applied.
    private boolean checkPayDay(int checkInDate, int checkOutDate){
        for(int i = checkInDate; i < checkOutDate; i++){
            if(i == 15 || i == 30) { //check if either 15 or 30 is in the reservation
                return true;
            }
        }
        return false;
    }

}
