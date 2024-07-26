import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewHotelController {
    private ViewHotelView vView;
    private MainMenuController mController;
    private ReservationSystem rs;
    private Hotel selectedHotel;

    public ViewHotelController(MainMenuController mController, ReservationSystem rs) {
        this.vView = new ViewHotelView();
        this.mController = mController;
        this.rs = rs;

        this.vView.goToViewAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hotelName = vView.getChooseHotelText();
                selectedHotel = rs.selectHotel(hotelName); // Store the selected hotel

                if (selectedHotel != null) {
                    vView.setFeedbackLbl("Viewing " + hotelName);
                    vView.displayHotelHighInfo(selectedHotel);
                    vView.switchPanel("MainPanel");
                    if(selectedHotel.getReservationManager().getReserveList().size() != 0)
                        vView.setViewReserveEnabled(true);
                    else
                        vView.setViewReserveEnabled(false);
                    //vView.clearTF();
                } else {
                    vView.setHotelFeedbackLbl("Please Try Again! Hotel not found.");
                }
            }
        });

        this.vView.highLvlAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vView.switchPanel("HighLvlPanel");
            }
        });

        this.vView.lowLvlAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vView.switchPanel("LowLvlPanel");
            }
        });

        // Check Availability screeN
        this.vView.goToInputDateAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vView.clearTF_2();
                vView.switchPanel("InputDatePanel");
            }
        });

        this.vView.goToChkAvailAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int inputDate = vView.getInputDateText();
                if (inputDate >= 1 && inputDate <= 31) {
                    List<Room> availableRooms = selectedHotel.getRoomManager().getAvailableRooms(inputDate);
                    int totalBookedRooms = selectedHotel.getRoomManager().countBookedRooms(inputDate);

                    vView.displayAvailableRooms(availableRooms, totalBookedRooms);
                    vView.switchPanel("CheckAvailPanel");

                } else {
                    vView.setFeedbackLbl_2("Please enter a valid date between 1 and 31.");
                }
            }
        });
        this.vView.backToLowAL_1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vView.switchPanel("LowLvlPanel");
            }
        });

        // View Room Screen
        this.vView.goToChooseRoomAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vView.switchPanel("RoomListPanel");
                vView.clearTF_3();
            }
        });
        

        this.vView.goToViewRoomAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (selectedHotel != null) {
                        int roomNumber = vView.getInputRoomNameText();
                        if(roomNumber < 101 || roomNumber > 350)
                            vView.setFeedbackLbl_3("Invalid room number. Please enter a valid number.");
                        else{
                        Room selectedRoom = selectedHotel.getRoomManager().findRoom(roomNumber);

                        if (selectedRoom != null) {
                            vView.displayRoomInfo(selectedRoom);
                            vView.switchPanel("ViewRoomPanel");
                        } else {
                            vView.setFeedbackLbl_3("Room not found.");
                        }

                    }
                } else {
                    vView.setFeedbackLbl_3("Please select a hotel first.");
                }
            }
        });

        this.vView.backToLowAL_2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vView.switchPanel("LowLvlPanel");
            }
        });

        // View Reservation Screen
        this.vView.goToChooseReserveAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String guestName = vView.getInputReserveText();
        
                if (selectedHotel != null) {
                    Reservation reservation = selectedHotel.getReservationManager().findReservation(guestName);
        
                    if (reservation != null) {
                        vView.displayReservations(reservation, selectedHotel); // Update view to display reservation
                    } else {
                        vView.setFeedbackLbl_3("No reservation found for this guest.");
                    }
        
                } else {
                    vView.setFeedbackLbl_4("Please select a hotel first.");
                }
                vView.switchPanel("ReservationListPanel");
                vView.clearTF_4();
            }
        });

        this.vView.goToViewReserveAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vView.switchPanel("ViewReservePanel");
            }
        });

        this.vView.backToLowAL_3(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vView.switchPanel("LowLvlPanel");
            }
        });

        this.vView.backToViewAL_1(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vView.switchPanel("MainPanel");
            }
        });

        this.vView.backToViewAL_2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vView.switchPanel("MainPanel");
            }
        });

        this.vView.backToMainAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vView.close(false);
                mController.showMainMenuView(true);
                vView.switchPanel("HotelListPanel");
            }
        });
        this.vView.backToMainAL_2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vView.close(false);
                mController.showMainMenuView(true);
                vView.clearTF();
                vView.setHotelFeedbackLbl("");;
            }
        });
    }

    public void showViewHotelView(boolean result) {
        vView.show(result);
    }

    public void displayHotels(){
        StringBuilder displayTxt = new StringBuilder();
        for(Hotel hotel : rs.getHotelList()){
            displayTxt.append(hotel.getHotelName()).append("\n");
        }

        vView.setHotelListTA(displayTxt.toString());
    }
    
}
