import view.MainMenuView;
import model.ReservationSystem;
import controller.MainMenuController;

public class Driver {

    public static void main(String[] args) {
        MainMenuView mView = new MainMenuView();
        ReservationSystem rSystem = new ReservationSystem();

        MainMenuController mController = new MainMenuController(mView, rSystem);
    }
}
