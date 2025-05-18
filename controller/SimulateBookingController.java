package controller;

import model.ReservationSystem;
import model.hotel.Hotel;
import model.hotel.reservation.Reservation;

import view.SimulateBookingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class SimulateBookingController {
    private SimulateBookingView sbView;
    private MainMenuController mController;
    private ReservationSystem rs;
    private Hotel selectedHotel;

    public SimulateBookingController(MainMenuController mController, ReservationSystem rs) {
        this.sbView = new SimulateBookingView();
        this.mController = mController;
        this.rs = rs;

        this.sbView.goToBookAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hotelName = sbView.getChooseHotelText();
                selectedHotel = rs.selectHotel(hotelName);

                if (selectedHotel != null) {
                    if(!selectedHotel.getRoomManager().isFullyBooked()) {
                        sbView.setFeedbackLbl_2("Booking in " + hotelName);
                        sbView.switchPanel("GuestInfoPanel");
                        sbView.clearTF();
                        sbView.clearButtonSelection();
                    }
                    else
                        sbView.setFeedbackLbl("This hotel is fully booked!");
                } else {
                    sbView.setFeedbackLbl("Please Try Again! Hotel not found.");
                }
            }
        });

        this.sbView.goToRoomInfoAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String guestName;
                int checkIn, checkOut;
                String roomType;
                String discountCode;

                try {
                    guestName = sbView.getGuestNameText();
                    discountCode = sbView.getDiscountText();
                    if (sbView.isStandardSelected())
                        roomType = "Standard";
                    else if (sbView.isDeluxeSelected())
                        roomType = "Deluxe";
                    else if (sbView.isExecSelected())
                        roomType = "Executive";
                    else
                        roomType = "null";
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error retrieving input data. Please try again.");
                    return;
                }

                // Validate discount code
                if (!discountCode.isEmpty() && !discountCode.equals("I_WORK_HERE") && !discountCode.equals("STAY4_GET1") && !discountCode.equals("PAYDAY")) {
                    JOptionPane.showMessageDialog(null, "Invalid discount code!");
                    return;
                }

                // Prompt if discount code is empty
                if (discountCode.isEmpty()) {
                    int response = JOptionPane.showConfirmDialog(null, "No discount code entered. Do you want to proceed without a discount?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (response != JOptionPane.YES_OPTION) {
                        return;
                    }
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
                if (roomType.equals("null")) {
                    JOptionPane.showMessageDialog(null, "Please choose a room type!");
                    return;
                }

                // Try to reserve the room
                boolean reservation;
                try {
                    reservation = rs.reserveRoom(selectedHotel, guestName, checkIn, checkOut, roomType, discountCode);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error reserving the room. Please try again.");
                    return;
                }

                if (reservation) {
                    try {
                        Reservation r = selectedHotel.getReservationManager().findReservation(guestName);

                        double totalPrice = computeTotalPrice(selectedHotel, r);
                        if(discountCode.isEmpty())
                            discountCode = "(none)";
                        sbView.displayRoomInfo(selectedHotel, guestName, checkIn, checkOut, roomType, discountCode, totalPrice);
                        sbView.switchPanel("ShowRoomPanel");
                        sbView.clearTF_2();
                        sbView.clearTF_3();
                        sbView.clearTF_4();
                        sbView.clearTF_6();
                        sbView.clearButtonSelection();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error calculating the total price. Please try again.");
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please try again! Invalid information or room unavailable.");
                }
            }
        });

        this.sbView.backToMainAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sbView.close(false);
                mController.showMainMenuView(true);
                sbView.switchPanel("HotelListPanel");
                sbView.setFeedbackLbl("");
                sbView.clearTF();
                sbView.clearTF_2();
                sbView.clearTF_3();
                sbView.clearTF_4();
                sbView.clearTF_6();
                sbView.clearButtonSelection();
            }
        });

        this.sbView.backToMainAL_2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sbView.close(false);
                mController.showMainMenuView(true);
                sbView.switchPanel("HotelListPanel");
                sbView.setFeedbackLbl("");
                sbView.clearTF();
                sbView.clearTF_2();
                sbView.clearTF_3();
                sbView.clearTF_4();
                sbView.clearTF_6();
                sbView.clearButtonSelection();
            }
        });

        this.sbView.backToMainAL_3(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sbView.close(false);
                mController.showMainMenuView(true);
                sbView.switchPanel("HotelListPanel");
                sbView.setFeedbackLbl("");
                sbView.clearTF();
                sbView.clearTF_2();
                sbView.clearTF_3();
                sbView.clearTF_4();
                sbView.clearTF_6();
                sbView.clearButtonSelection();
            }
        });
    }

    public void showSimulateBookView(boolean result) {
        sbView.show(result);
    }

    public void displayHotels() {
        StringBuilder displayTxt = new StringBuilder();
        for (Hotel hotel : rs.getHotelList()) {
            displayTxt.append(hotel.getHotelName()).append("\n");
        }

        sbView.setHotelListTA(displayTxt.toString());
    }

    private double computeTotalPrice(Hotel hotel, Reservation reservation) {
        return reservation.computeTotalPrice(hotel);
    }
}
