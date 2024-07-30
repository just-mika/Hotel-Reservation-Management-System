import java.util.ArrayList;
/**
 * Represents a reservation system that manages a collection of hotels.
 * It provides methods to add or remove hotels, manage reservations, and update hotel details.
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
     * Gets the list of hotels managed by the reservation system.
     *
     * @return The list of hotels.
     */
    public ArrayList<Hotel> getHotelList(){
        return hotelList;
    }

    /**
     * Gets the number of hotels in the reservation system.
     *
     * @return The number of hotels.
     */
    public int countHotels(){
        return hotelList.size();
    }


    /**
     * Selects a hotel by name.
     *
     * @param hotelName The name of the hotel to select.
     * @return The selected hotel, or null if no hotel with the specified name is found.
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
     * @param hotelName The name of the hotel to create.
     * @return {@code true} if the hotel was created and added; {@code false} if a hotel with the same name already exists.
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
     * @param hotel        The selected hotel.
     * @param newHotelName The new name of the hotel.
     * @return {@code true} if the hotel name change was successful; {@code false} otherwise.
     */
    public boolean changeHotelName(Hotel hotel, String newHotelName){
        if(this.selectHotel(newHotelName) == null && hotel != null){
            hotel.setHotelName(newHotelName); //only change hotel name if the given name isn't already found in the list
            return true;
        }
        return false;
    }

    /**
     * Adds a specified number of rooms to the selected hotel.
     *
     * @param hotel     The selected hotel.
     * @param roomType  The type of room to add.
     * @param quantity  The number of rooms to add.
     * @return {@code true} if rooms were successfully added; {@code false} otherwise.
     */
    public boolean addRooms(Hotel hotel, String roomType, int quantity){
        if(hotel != null) {
            if (hotel.getRoomManager().getRoomList().size() + quantity <= 50) { //only add if adding the rooms will not exceed the limit
                for (int i = 0; i < quantity; i++) {
                    hotel.getRoomManager().addRoom(hotel, roomType);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Removes a specified number of rooms from the selected hotel.
     *
     * @param hotel    The selected hotel.
     * @param roomType The type of rooms to remove.
     * @param quantity The number of rooms to remove.
     * @return {@code true} if rooms were successfully removed; {@code false} otherwise.
     */
    public boolean removeRooms(Hotel hotel, String roomType, int quantity){
        if(hotel != null){ //only remove if the number of rooms to remove is less than the current amt of rooms
            System.out.println(hotel.getRoomManager().getRoomList().size() - quantity);
            if(hotel.getRoomManager().getRoomList().size() - quantity > 0
                    && hotel.getRoomManager().countRooms(roomType) - quantity >= 0){
                for(int i = 0; i < quantity; i++)
                    hotel.getRoomManager().removeRoom(roomType);
                return true;
            }
        }
        return false;
    }

    /**
     * Updates the base price of rooms in the selected hotel.
     *
     * @param hotel    The selected hotel.
     * @param newPrice The new base price to set.
     * @return {@code true} if the base price was successfully updated; {@code false} otherwise.
     */
    public boolean updateBasePrice(Hotel hotel, double newPrice){
        if(hotel != null) { //only change base price if it is greater than or equal to 100 and if current hotel has no reservations
            if (hotel.getReservationManager().getReserveList().isEmpty() && newPrice >= 100) {
                hotel.setBasePrice(newPrice);
                //update the prices for all rooms
                for (Room room : hotel.getRoomManager().getRoomList()) {
                    room.setRoomPrice(newPrice);
                }
                return true;
            }
        }
            return false;
    }

    /**
     * Modifies the price rate for a specific date in the selected hotel.
     *
     * @param hotel    The selected hotel.
     * @param date     The date to modify.
     * @param rate     The new price rate for the date.
     * @return {@code true} if the price rate was successfully modified; {@code false} otherwise.
     */
    public boolean modifyDatePrice(Hotel hotel, int date, double rate){
        if(hotel != null && hotel.getDatePriceManager().findDate(date) != null && rate >= 0){
            //only change date if hotel and date exists and rate is not negative
            hotel.getDatePriceManager().changeDatePrice(date, rate);
            return true;
        }
        return false;
    }


    /**
     * Reserves a room in the selected hotel for a specified guest and date range.
     *
     * @param hotel        The selected hotel.
     * @param guestName    The name of the guest.
     * @param checkInDate  The check-in date.
     * @param checkOutDate The check-out date.
     * @param roomType     The type of room to reserve.
     * @return {@code true} if the reservation was successfully added; {@code false} otherwise.
     */
    public boolean reserveRoom(Hotel hotel, String guestName, int checkInDate, int checkOutDate, String roomType){
        int dateCount = checkOutDate - checkInDate + 1;
        //only reserve a room if hotel exists, guest has yet to reserve, and dateCount is not zero
        if(hotel != null && hotel.getReservationManager().findReservation(guestName) == null && dateCount > 1)  {
            return hotel.getReservationManager().addReservation(hotel,
                    guestName, checkInDate, checkOutDate, roomType); //add reservation in the hotel
        }
        return false;
    }

    /**
     * Reserves a room in the selected hotel for a specified guest and date range with a discount code.
     *
     * @param hotel        The selected hotel.
     * @param guestName    The name of the guest.
     * @param checkInDate  The check-in date.
     * @param checkOutDate The check-out date.
     * @param roomType     The type of room to reserve.
     * @param discount     The discount code to apply.
     * @return {@code true} if the reservation was successfully added, regardless of whether the discount was applied; {@code false} otherwise.
     */
    public boolean reserveRoom(Hotel hotel, String guestName, int checkInDate,
                               int checkOutDate, String roomType, String discount){
        int dateCount = checkOutDate - checkInDate + 1;
        //only reserve a room if hotel exists, guest has yet to reserve, and dateCount is not zero
        if(hotel != null && hotel.getReservationManager().findReservation(guestName) == null && dateCount > 1) {
            if(discount.equals("I_WORK_HERE")){
                return hotel.getReservationManager().addReservation(hotel, guestName,
                        checkInDate, checkOutDate, roomType, "I_WORK_HERE");
            }
            else if(discount.equals("STAY4_GET1")){
                if(checkOutDate - checkInDate >= 5) //only apply discount if reservation has 5 days or more
                    return hotel.getReservationManager().addReservation(hotel, guestName,
                            checkInDate, checkOutDate, roomType, "STAY4_GET1");
            }
            else if(discount.equals("PAYDAY")){
                boolean applyDiscount = checkPayDay(checkInDate, checkOutDate); //helper function to check if 15 or 30 are in the dates

                if(applyDiscount) //only apply discount if discount is in there
                    return hotel.getReservationManager().addReservation(hotel, guestName,
                            checkInDate, checkOutDate, roomType, "PAYDAY");
            }
            //if not applied, just create a regular reservation
            return hotel.getReservationManager().addReservation(hotel, guestName,
                    checkInDate, checkOutDate, roomType);
        }
        return false;
    }

    /**
     * Removes a reservation from the selected hotel.
     *
     * @param hotel     The selected hotel.
     * @param guestName The name of the guest who made the reservation.
     * @return {@code true} if the reservation was successfully removed; {@code false} otherwise.
     */
    public boolean removeReservation(Hotel hotel, String guestName){
        if(hotel != null && hotel.getReservationManager().findReservation(guestName) != null) { //only remove reservation if the given hotel is found
            return hotel.getReservationManager().removeReservation(guestName); //return the resulting boolean value
        }
        return false;
    }

    /**
     * Removes a hotel from the reservation system.
     *
     * @param hotelName The name of the hotel to be removed.
     * @return {@code true} if the hotel was successfully removed; {@code false} otherwise.
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
