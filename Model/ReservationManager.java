import java.util.ArrayList;

/**
 * Manages the list of reservations in a hotel.
 */
public class ReservationManager {
    private ArrayList<Reservation> reserveList; //attribute for list of reservations

    /**
     * Constructs the reservation manager.
     */
    public ReservationManager(){
        this.reserveList = new ArrayList<Reservation>();
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
     * Adds a reservation to the hotel for a specified guest and date range.
     *
     * @param hotel the hotel the guest will reserve in
     * @param guestName The name of the guest.
     * @param checkInDate The check-in date.
     * @param checkOutDate The check-out date.
     * @param roomType the type of room to be reserved
     * @return `true` if the reservation was successfully added; `false` otherwise.
     */
    public boolean addReservation(Hotel hotel, String guestName, int checkInDate, int checkOutDate, String roomType){
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

        int index = lookForRoom(hotel, checkInDate, checkOutDate, roomType);
        Room room = hotel.getRoomManager().getRoomList().get(index);

        if(index != -1)
            return reserveList.add(new Reservation(guestName, room, checkInDate, checkOutDate));
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
    public boolean addReservation(Hotel hotel, String guestName, int checkInDate, int checkOutDate, String roomType, String discount){
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

        int index = lookForRoom(hotel, checkInDate, checkOutDate, roomType);
        Room room = hotel.getRoomManager().getRoomList().get(index);

        if(index != -1)
            return reserveList.add(new DiscountedReservation(guestName, room, checkInDate, checkOutDate, discount));
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

    //helper function to look for the room
    private int lookForRoom(Hotel hotel, int checkInDate, int checkOutDate, String roomType) {
        ArrayList<Room> roomList = hotel.getRoomManager().getRoomList();
        int dateCount = checkOutDate - checkInDate + 1;

        for (int i = 0; i < roomList.size(); i++) {
            int ctr = 0;
            if (dateCount + roomList.get(i).computeReservedDates() > 31
                    && !roomType.equals(roomList.get(i).getRoomType()))
                continue; //skip iteration if reservation exceeds reserved dates AND not the same room type
            else {
                for (int date = checkInDate; date <= checkOutDate; date++) {
                    if (roomList.get(i).isAvailable(date)
                            && roomType.equals(roomList.get(i).getRoomType())) //check if room is available for ALL dates
                        ctr++;
                }
                if (ctr == dateCount)
                    return i; //return index if it is available for all dates
            }
        }
        return -1; //return -1 if not
    }


}
