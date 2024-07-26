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
                    mhView.switchPanel("ManageHotelPanel");
                    mhView.clearTF();
                } else {
                    mhView.setFeedbackLbl_2("Please Try Again! Hotel not found.");
                }
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
                            mhView.switchPanel("ManageHotelPanel");
                            mhView.clearTF_2();
                            mhView.setFeedbackLbl_3("");
                        } else {
                            mhView.setFeedbackLbl_3("Please enter a different name!");
                        }
                    } else {
                        mhView.switchPanel("ManageHotelPanel");
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
                mhView.switchPanel("AddRoomsPanel");
            }
        });

        this.mhView.addRoomInfoAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = mhView.getAddRoomsText();
                String roomType = mhView.getTypeRoomsText();

                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to add " + quantity + " rooms?", 
                                                             "Confirm Add Rooms", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                    if(quantity != -1 && (roomType.equals("Standard") || roomType.equals("Deluxe") || roomType.equals("Executive"))) {
                        boolean add = rs.addRooms(selectedHotel, roomType, quantity);

                        if (add) {
                            mhView.displayAddedRooms(selectedHotel, roomType, quantity);
                            mhView.clearTF_3();
                            mhView.clearTF_4();
                            mhView.setFeedbackLbl_4("Rooms added successfully to " + selectedHotel.getHotelName());
                            mhView.switchPanel("AddRoomsPanel");

                        } else {
                            mhView.setFeedbackLbl_4("Failed to add rooms. Please try again.");
                            mhView.switchPanel("AddRoomsPanel");
                        }
                    }
                    else{
                        mhView.setFeedbackLbl_4("Invalid inputs!");
                        mhView.switchPanel("AddRoomsPanel");
                    }
                } else {
                    mhView.switchPanel("ManageHotelPanel");
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
                mhView.switchPanel("RemoveRoomsPanel");
            }
        });

        this.mhView.removeRoomInfoAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = mhView.getRemoveRoomsText();
                String roomType = mhView.getTypeRoomsText_2();

                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove " + quantity + " rooms?", 
                                                             "Confirm Remove Rooms", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                    boolean remove = rs.removeRooms(selectedHotel, roomType, quantity);
                    System.out.println(remove);
                    if (remove) {
                        mhView.displayRemovedRooms(selectedHotel, roomType, quantity);
                        mhView.clearTF_5();
                        mhView.clearTF_6();
                        mhView.setFeedbackLbl_5("Rooms removed successfully from " + selectedHotel.getHotelName());
                        //mhView.switchPanel("RemoveRoomsPanel");
                    } else {
                        mhView.setFeedbackLbl_5("Failed to remove rooms. Please try again.");
                      //  mhView.switchPanel("RemoveRoomsPanel");
                    }
                } else {
                    mhView.switchPanel("ManageHotelPanel");
                }
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

        this.mhView.goToRemoveReserveAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.switchPanel("RemoveReservationPanel");
                String reservation = mhView.getRemoveReserveText();

                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the reservation for " + reservation + "?",
                                                             "Confirm Remove Reservation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                    boolean remove = rs.removeReservation(selectedHotel, reservation);

                    if (remove) {
                        mhView.displayRemoveReserve(selectedHotel, reservation);
                        mhView.clearTF_8();
                        mhView.setFeedbackLbl_7("Reservation removed in " + selectedHotel.getHotelName() + " for " + reservation);
                        mhView.switchPanel("ManageHotelPanel");
                    } else {
                        mhView.setFeedbackLbl_7("Failed to remove reservation. Please try again.");
                        mhView.switchPanel("RemoveReservationPanel");
                    }
                } else {
                    mhView.switchPanel("ManageHotelPanel");
                }
            }
        });

        this.mhView.removeReserveAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                /*
                mhView.switchPanel("RemoveHotelPanel");
                mhView.setFeedbackLbl_8("");*/
            }
        });
/*
        this.mhView.goToManageAL_7(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hotelName = mhView.getRemoveHotelText();
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove hotel " + hotelName + "?",
                                                             "Confirm Remove Hotel", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                    Hotel selectedHotel = rs.selectHotel(hotelName);
                    boolean remove = rs.removeHotel(hotelName);

                    if (remove) {
                        mhView.displayRemoveHotel(selectedHotel, hotelName);
                        mhView.clearTF_9();
                        mhView.setFeedbackLbl_8("Removed " + hotelName);
                        mhView.switchPanel("HighLvlInfoPanel");
                    } else {
                        mhView.setFeedbackLbl_8("Failed to remove hotel. Please try again.");
                        mhView.switchPanel("RemoveHotelPanel");
                    }
                } else {
                    mhView.switchPanel("ManageHotelPanel");
                }
            }
        });*/

        this.mhView.backToMainAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.close(false);
                mController.showMainMenuView(true);
                mhView.switchPanel("HotelListPanel");
            }
        });
        this.mhView.backToMainAL_2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mhView.close(false);
                mController.showMainMenuView(true);
                mhView.clearTF();
                mhView.setFeedbackLbl("");
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
}
