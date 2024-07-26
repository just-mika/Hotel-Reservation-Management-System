import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateHotelController {
    private CreateHotelView cView;
    private MainMenuController mController;
    private ReservationSystem rs;

    public CreateHotelController(MainMenuController mController, ReservationSystem rs){
        this.cView = new CreateHotelView();
        this.mController = mController;
        this.rs = rs;

        this.cView.addBtnAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hotelName = cView.getHotelNameTf();
                if(!hotelName.equals("")) {
                    boolean result = rs.createHotel(hotelName);

                    if (result) {
                        cView.setFeedbackLbl("Successfully added " + hotelName);
                        cView.clearTF();
                    } else {
                        cView.setFeedbackLbl("Cannot add " + hotelName + ". It's already been added.");
                    }
                    updateHotelListTA();
                }
                else
                    cView.setFeedbackLbl("Name field is empty!");
            }
        });

        this.cView.backToMainAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cView.close(false);
                mController.showMainMenuView(true);
                cView.clearTF();
                cView.setFeedbackLbl("");;
            }
        });
    }

    public void showCreateHotelView(boolean result) {
        updateHotelListTA();
        cView.show(result);
    }

    private void updateHotelListTA(){
        StringBuilder displayTxt = new StringBuilder();
        for(Hotel hotel : rs.getHotelList()){
            displayTxt.append(hotel.getHotelName()).append("\n");
        }

        cView.setHotelListTA(displayTxt.toString());
    }
}
