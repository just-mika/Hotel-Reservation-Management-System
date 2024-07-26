import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class DatePriceController {
    private DatePriceView dpView;
    private MainMenuController mController;
    private ReservationSystem rs;
    private Hotel selectedHotel;

    public DatePriceController(MainMenuController mController, ReservationSystem rs){
        this.dpView = new DatePriceView();
        this.mController = mController;
        this.rs = rs;

        this.dpView.goToDatePriceAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hotelName = dpView.getChooseHotelText();
                selectedHotel = rs.selectHotel(hotelName); 

                if (selectedHotel != null) {
                    dpView.setFeedbackLbl_3("Modifying Date-Price in " + hotelName);
                    dpView.switchPanel("PriceModifierPanel");
                    dpView.clearTF();
                } else {
                    dpView.setFeedbackLbl("Please Try Again! Hotel not found.");
                }
                
            }
        });

        this.dpView.backToMainAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int date = dpView.getDateText();
                double percentage = dpView.getPercetageText();

                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to change day " + date + " to " +percentage+ "% ?", 
                                                             "Confirm Base Price Change", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                    boolean change = rs.modifyDatePrice(selectedHotel, date, percentage);

                    if (change) {
                        selectedHotel.getBasePrice();
                        //dpView.setFeedbackLbl_2("Changing " +percentage+ " % to date "+date );
                        dpView.clearTF_2();
                        dpView.clearTF_3();
                        dpView.setFeedbackLbl_2("");

                        dpView.close(false);
                        mController.showMainMenuView(true);
                        dpView.switchPanel("HotelListPanel");
                    } else {
                        dpView.setFeedbackLbl_2("Invalid Input!");
                    }
                } else {
                    dpView.switchPanel("PriceModifierPanel");
                }


                
            }
        });
    }
    
    public void showDatePriceView(boolean result) {
        dpView.show(result);
    }

    public void displayHotels() {
        StringBuilder sb = new StringBuilder();
        for (Hotel hotel : rs.getHotelList()) {
            sb.append(" - ").append(hotel.getHotelName());
        }

        dpView.setHotelList(sb.toString());
    }
    
}
