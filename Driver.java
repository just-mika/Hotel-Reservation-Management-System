
public class Driver {

    public static void main(String[] args) {
        MainMenuView mView = new MainMenuView();
        //CreateHotelView cView = new CreateHotelView();
        //ViewHotelView vView = new ViewHotelView();
        //ManageHotelView mhView = new ManageHotelView();
        //SimulateBookingView sbView = new SimulateBookingView();
        //DatePriceView dpView = new DatePriceView();
        //ExitView eView = new ExitView();
        ReservationSystem rSystem = new ReservationSystem();

        MainMenuController mController = new MainMenuController(mView, rSystem);
        //CreateHotelController cController = new CreateHotelController(cView);
        //ViewHotelController vController = new ViewHotelController(mController);
    }
    
}
