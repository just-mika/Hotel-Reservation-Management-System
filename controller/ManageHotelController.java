package controller;

import model.ReservationSystem;
import model.hotel.Hotel;
import model.hotel.reservation.Reservation;

import view.ManageHotelView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ManageHotelController {
    private ManageHotelView mhView;
    private MainMenuController mController;
    private ReservationSystem rs;
    private Hotel selectedHotel;

    public ManageHotelController(MainMenuController mController, ReservationSystem rs){
        this.mhView = new ManageHotelView();
        this.mController = mController;
        this.rs = rs;

        mhView.switchPanel("HotelListPanel");

        this.mhView.goToManageAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hotelName = mhView.getChooseHotelText();
                selectedHotel = rs.selectHotel(hotelName); // Store the selected hotel

                if (selectedHotel != null) {
                    mhView.setFeedbackLbl("Managing " + hotelName);
                    updateButtons();
                    mhView.switchPanel("ManageHotelPanel");
                    mhView.clearTF();
                } else {
                    mhView.setFeedbackLbl_2("Please Try Again! Hotel not found.");
                }
                mhView.clearTF();
            }
        });

        this.mhView.changeNameAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.switchPanel("ChangeNamePanel");
            }
        });

        this.mhView.goToManageAL_2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newHotelName = mhView.getChangeHotelText();
                if(!newHotelName.equals("")) {
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to change to " + newHotelName + "?",
                            "Confirm Name Change", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {
                        boolean change = rs.changeHotelName(selectedHotel, newHotelName);

                        if (change) {
                            selectedHotel.setHotelName(newHotelName); // Update the name in the selectedHotel object
                            mhView.setFeedbackLbl("Managing " + newHotelName);
                            displayHotels(); // Refresh the hotel list
                            mhView.clearTF_2();
                            mhView.setFeedbackLbl_3("Changing to "+newHotelName);
                        } else {
                            mhView.setFeedbackLbl_3("Please enter a different name!");
                        }
                    } else {
                        mhView.switchPanel("ChangeNamePanel");
                    }
                }
                else
                    mhView.setFeedbackLbl_3("Name field is empty!");
            }
        });

        this.mhView.addRoomAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.displayRooms(selectedHotel);
                mhView.clearButtonSelection();
                mhView.switchPanel("AddRoomsPanel");
            }
        });

        this.mhView.addRoomInfoAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = mhView.getAddRoomsText();
                String roomType;
                if(mhView.isAddStandardSelected())
                    roomType = "Standard";
                else if (mhView.isAddDeluxeSelected())
                    roomType = "Deluxe";
                else if (mhView.isAddExecSelected())
                    roomType = "Executive";
                else
                    roomType = "null";

                if(quantity != -1 && (roomType.equals("Standard") || roomType.equals("Deluxe") || roomType.equals("Executive"))) {
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to add " + quantity + " " + roomType + " rooms?",
                            "Confirm Add Rooms", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        boolean add = rs.addRooms(selectedHotel, roomType, quantity);
                        if (add) {
                            updateButtons();
                            mhView.displayAddedRooms(selectedHotel, roomType, quantity);
                            mhView.clearTF_3();
                            mhView.clearButtonSelection();
                            mhView.setFeedbackLbl_4("Rooms added successfully to " + selectedHotel.getHotelName());
                            mhView.switchPanel("AddRoomsPanel");

                        } else {
                            mhView.setFeedbackLbl_4("Failed to add rooms. Please try again.");
                            mhView.switchPanel("AddRoomsPanel");
                        }
                    }
                    else
                        mhView.switchPanel("AddRoomsPanel");
                }
                else if (quantity == -1){
                    mhView.setFeedbackLbl_4("Invalid room numbers!");
                    mhView.switchPanel("AddRoomsPanel");
                }
                else {
                    mhView.setFeedbackLbl_4("No room type selected!");
                    mhView.switchPanel("AddRoomsPanel");
                }
            }
        });

        this.mhView.removeRoomInfoAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = mhView.getRemoveRoomsText();
                String roomType;
                if(mhView.isRemoveStandardSelected())
                    roomType = "Standard";
                else if (mhView.isRemoveDeluxeSelected())
                    roomType = "Deluxe";
                else if (mhView.isRemoveExecSelected())
                    roomType = "Executive";
                else
                    roomType = "null";

                if(quantity != -1 && (roomType.equals("Standard") || roomType.equals("Deluxe") || roomType.equals("Executive"))) {
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove " + quantity + " " + roomType + " rooms?",
                            "Confirm Remove Rooms", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                    if (response == JOptionPane.YES_OPTION) {
                        {
                            boolean remove = rs.removeRooms(selectedHotel, roomType, quantity);
                            if (remove) {
                                mhView.displayMaxRooms(selectedHotel);
                                mhView.clearTF_5();
                                mhView.setFeedbackLbl_5("Rooms removed successfully from " + selectedHotel.getHotelName());
                                updateButtons();
                                mhView.clearButtonSelection();
                                mhView.switchPanel("RemoveRoomsPanel");
                            } else {
                                mhView.setFeedbackLbl_5("Failed to remove rooms. Please try again.");
                                mhView.switchPanel("RemoveRoomsPanel");
                            }
                        }
                    } else {
                        mhView.switchPanel("RemoveRoomsPanel");
                    }
                }
                else if (quantity == -1) {
                    mhView.setFeedbackLbl_5("Invalid room numbers!");
                    mhView.switchPanel("RemoveRoomsPanel");
                } else {
                    mhView.setFeedbackLbl_5("No room type selected!");
                    mhView.switchPanel("RemoveRoomsPanel");
                }

            }
        });

        this.mhView.goToManageAL_3(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.setFeedbackLbl_4("");
                mhView.switchPanel("ManageHotelPanel");
            }
        });

        this.mhView.removeRoomAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.displayMaxRooms(selectedHotel);
                mhView.clearButtonSelection();
                mhView.switchPanel("RemoveRoomsPanel");
            }
        });

        this.mhView.goToManageAL_4(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.setFeedbackLbl_5("");
                mhView.switchPanel("ManageHotelPanel");
            }
        });

        this.mhView.updatePriceAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.displayUpdatedPrice(selectedHotel);
                mhView.switchPanel("UpdatePricePanel");
            }
        });

        this.mhView.updatePriceInfoAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double newPrice = mhView.getPriceText();

                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the price to " + newPrice + "?", 
                                                             "Confirm Price Update", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                    boolean update = rs.updateBasePrice(selectedHotel, newPrice);

                    if (update) {
                        mhView.displayUpdatedPrice(selectedHotel);
                        mhView.clearTF_7();
                        mhView.setFeedbackLbl_6("Price updated successfully in " + selectedHotel.getHotelName() + " to " + newPrice);
                        mhView.switchPanel("UpdatePricePanel");
                    } else {
                        mhView.setFeedbackLbl_6("Failed to update price. Please try again.");
                        mhView.switchPanel("UpdatePricePanel");
                    }
                } else {
                    mhView.switchPanel("ManageHotelPanel");
                }
            }
        });

        this.mhView.goToManageAL_5(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.setFeedbackLbl_6("");
                mhView.switchPanel("ManageHotelPanel");
            }
        });
        this.mhView.removeReserveBackAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.setFeedbackLbl_7("");
                mhView.clearTF_8();
                mhView.switchPanel("ManageHotelPanel");
            }
        });

        this.mhView.goToRemoveReserveAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reservation = mhView.getRemoveReserveText();
                if (reservation.isEmpty()) {
                    mhView.setFeedbackLbl_7("Please enter a reservation name!");
                    mhView.switchPanel("ReserveListPanel");
                } else if(selectedHotel.getReservationManager().findReservation(reservation) == null) {
                    mhView.setFeedbackLbl_7("Reservation not found!");
                    mhView.switchPanel("ReserveListPanel");
                }
                else{
                    mhView.switchPanel("RemoveReservationPanel");
                    mhView.displayRemoveReserve(selectedHotel, selectedHotel.getReservationManager().findReservation(reservation).getGuestName());
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the reservation for " + reservation + "?",
                            "Confirm Remove Reservation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {
                        boolean remove = rs.removeReservation(selectedHotel, reservation);

                        if (remove) {
                            mhView.clearTF_8();
                            //mhView.setFeedbackLbl_7("Reservation removed in " + selectedHotel.getHotelName() + " for " + reservation);
                            mhView.switchPanel("ManageHotelPanel");
                            updateButtons();
                            JOptionPane.showMessageDialog(null, reservation + "'s Reservation successfully removed.",
                                    "Delete Reservation Successful", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            mhView.clearTF_8();
                            mhView.switchPanel("ManageHotelPanel");
                            JOptionPane.showMessageDialog(null, "Reservation deletion failed.",
                                    "Delete Reservation Failed", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } else {
                        mhView.clearTF_8();
                        mhView.switchPanel("ManageHotelPanel");
                    }
                }
            }
        });

        this.mhView.removeReserveAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayReservationList();
                mhView.setFeedbackLbl_7("");
                mhView.switchPanel("ReserveListPanel");
            }
        });

        this.mhView.removeHotelAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hotelName = selectedHotel.getHotelName();
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove hotel " + hotelName + "?",
                        "Confirm Remove Hotel", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                    boolean remove = rs.removeHotel(hotelName);
                    if (remove) {
                        mhView.close(false);
                        mController.showMainMenuView(true);
                        mhView.clearTF();
                        mhView.setFeedbackLbl("");
                        JOptionPane.showMessageDialog(null, "Hotel " + hotelName + " successfully removed.", "Delete Successful", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        mhView.setFeedbackLbl_8("Failed to remove hotel. Please try again.");
                        mhView.switchPanel("ManageHotelPanel");
                    }
                } else {
                    mhView.switchPanel("ManageHotelPanel");
                }
            }
        });

        this.mhView.backToMainAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.close(false);
                mController.showMainMenuView(true);
                mhView.setFeedbackLbl_2("");
                mhView.switchPanel("HotelListPanel");
            }
        });
        this.mhView.backToMainAL_2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.close(false);
                mController.showMainMenuView(true);
                mhView.setFeedbackLbl_2("");
                mhView.clearTF();
                mhView.setFeedbackLbl("");
            }
        });

        this.mhView.enterPriceAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int date = mhView.getDateText();
                double percentage = mhView.getPercetageText();

                if(!(date < 1 || date > 31) && percentage > 0) {
                    int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to change day " + date + "'s " +
                                    "price rate from " + (selectedHotel.getDatePriceManager().findDate(date).getRate() * 100) + "% to " +
                                    percentage + "% ?", "Confirm Base Price Change", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                    if (response == JOptionPane.YES_OPTION) {
                        boolean change = rs.modifyDatePrice(selectedHotel, date, percentage/100);
                        mhView.setFeedbackLbl_9("");
                        if (change) {
                            mhView.setFeedbackLbl_10("Change successful. New price rate in date " + date + ": " + percentage + "%");
                            mhView.clearTF_9();
                            mhView.clearTF_10();

                        } else {
                            mhView.setFeedbackLbl_9("Invalid Input!");
                        }
                    } else{
                        mhView.switchPanel("PriceModifierPanel");
                    }
                }
                else if(date < 1 || date > 31)
                    mhView.setFeedbackLbl_9("Invalid date input!");
                else
                    mhView.setFeedbackLbl_9("Invalid percentage input!");
            }
        });


        this.mhView.goToManageAL_6(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.switchPanel("ManageHotelPanel");
                mhView.clearTF_9();
                mhView.clearTF_10();
                mhView.setFeedbackLbl_10("");
                mhView.setFeedbackLbl_9("");
            }
        });

        this.mhView.modifyPriceAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.switchPanel("PriceModifierPanel");
            }
        });

        this.mhView.goToManageAL_7(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.switchPanel("ManageHotelPanel");
                mhView.clearTF_2();
                mhView.setFeedbackLbl_3("");
            }
        });

        
    }

    public void showManageHotelView(boolean result) {
        mhView.show(result);
    }

    public void displayHotels(){
        StringBuilder displayTxt = new StringBuilder();
        for(Hotel hotel : rs.getHotelList()){
            displayTxt.append(hotel.getHotelName()).append("\n");
        }

        mhView.setHotelListTA(displayTxt.toString());
    }

    private void updateButtons(){
        boolean showButtons = false;
        int roomCount = selectedHotel.getRoomManager().getRoomList().size();
        if(selectedHotel.getReservationManager().getReserveList().size() > 0)
            showButtons = true;
        this.mhView.setRemoveHotelEnabled(!showButtons);
        this.mhView.setRemoveReserveEnabled(showButtons);
        this.mhView.setUpdatePriceEnabled(!showButtons);
        if(roomCount == 50) {
            this.mhView.setAddRoomsEnabled(false);
            this.mhView.setRemoveRoomsEnabled(true);
        }
        if(roomCount == 1) {
            this.mhView.setAddRoomsEnabled(true);
            this.mhView.setRemoveRoomsEnabled(false);
        }
    }


    public void displayReservationList(){
        StringBuilder displayTxt = new StringBuilder();
        for(Reservation reservation : selectedHotel.getReservationManager().getReserveList()){
            displayTxt.append(reservation.getGuestName()).append("\n");
        }
        mhView.setReserveListTA(displayTxt.toString());
    }
}
