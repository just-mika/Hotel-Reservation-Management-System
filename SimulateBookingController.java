import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class SimulateBookingController {
    private SimulateBookingView sbView;
    private MainMenuController mController;
    private ReservationSystem rs;
    private Hotel selectedHotel;

    public SimulateBookingController(MainMenuController mController, ReservationSystem rs){
        this.sbView = new SimulateBookingView();
        this.mController = mController;
        this.rs = rs;

        this.sbView.goToBookAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hotelName = sbView.getChooseHotelText();
                selectedHotel = rs.selectHotel(hotelName); // Store the selected hotel

                if (selectedHotel != null) {
                    sbView.setFeedbackLbl_2("Booking in " + hotelName);
                    sbView.switchPanel("GuestInfoPanel");
                    sbView.clearTF();
                } else {
                    sbView.setFeedbackLbl("Please Try Again! Hotel not found.");
                }
                
            }
        });

        /*this.sbView.goToRoomInfoAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sbView.switchPanel("ShowRoomPanel");
            }
        });*/

        this.sbView.goToRoomInfoAL(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String guestName;
        int checkIn, checkOut;
        String roomType;
        String discountCode;

        try {
            guestName = sbView.getGuestNameText();
            roomType = sbView.getRoomTypeText();
            discountCode = sbView.getDiscountText();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error retrieving input data. Please try again.");
            return;
        }

        try {
            checkIn = sbView.getCheckInText();
            checkOut = sbView.getCheckOutText();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid numeric dates for check-in and check-out.");
            return;
        }

        // Validate guest name
        if (guestName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid name!");
            return;
        }

        // Validate check-in and check-out dates
        if (checkIn < 1 || checkIn > 31 || checkOut < 1 || checkOut > 31 || checkOut <= checkIn) {
            JOptionPane.showMessageDialog(null, "Please enter valid dates! Check-in and check-out dates must be between 1-31, and check-out must be after check-in.");
            return;
        }

        // Validate room type
        if (roomType.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a room type!");
            return;
        }

        // Validate discount code
        try {
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error validating discount code. Please try again.");
            return;
        }

        if (!discountCode.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid discount code! Please enter a valid discount code or leave it blank.");
            return;
        }

        // Try to reserve the room
        boolean reservation;
        try {
            reservation = rs.reserveRoom(selectedHotel, guestName, checkIn, checkOut, roomType);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error reserving the room. Please try again.");
            return;
        }

        if (reservation) {
            try {
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error calculating the total price. Please try again.");
                return;
            }

            sbView.displayRoomInfo(selectedHotel, guestName, checkIn, checkOut, roomType, discountCode);
            sbView.switchPanel("ShowRoomPanel");
            sbView.clearTF_2();
            sbView.clearTF_3();
            sbView.clearTF_4();
            sbView.clearTF_5();
            sbView.clearTF_6();
        } else {
            JOptionPane.showMessageDialog(null, "Please try again! Invalid information or room unavailable.");
        }
    }
});

        /*this.sbView.backToGuestInfoAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sbView.switchPanel("GuestInfoPanel");
            }
        });

        this.sbView.goToDiscountAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sbView.switchPanel("EnterDiscountPanel");
            }
        });

        this.sbView.goToDiscountAL_2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sbView.switchPanel("EnterDiscountPanel");
            }
        });

        this.sbView.goToDiscountAL_3(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sbView.switchPanel("EnterDiscountPanel");
            }
        });*/


        this.sbView.backToMainAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sbView.close(false);
                mController.showMainMenuView(true);
                sbView.switchPanel("HotelListPanel");
                sbView.setFeedbackLbl_3("");
            }
        });
    }
    
    public void showSimulateBookView(boolean result) {
        sbView.show(result);
    }

    public void displayHotels() {
        StringBuilder sb = new StringBuilder();
        for (Hotel hotel : rs.getHotelList()) {
            sb.append(" - ").append(hotel.getHotelName());
        }

        sbView.setHotelList(sb.toString());
    }
}
    

