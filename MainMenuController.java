import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MainMenuController {
    private MainMenuView mView;
    private CreateHotelController chController;
    private ViewHotelController vController;
    private ManageHotelController mhController;
    private SimulateBookingController sbController;
    private DatePriceController dpController;
    private ExitView eView;
    private ReservationSystem rs;

    public MainMenuController(MainMenuView mView, ReservationSystem rs) {
        this.mView = mView;
        this.chController = new CreateHotelController(this, rs);
        this.vController = new ViewHotelController(this, rs);
        this.mhController = new ManageHotelController(this, rs);
        this.sbController = new SimulateBookingController(this);
        this.dpController = new DatePriceController(this);
        this.eView = new ExitView();
        this.rs = rs;

        this.mView.show(true);
        this.updateButtons();

        this.mView.createHotelAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mView.close(false);
                chController.showCreateHotelView(true);
            }
        });

        this.mView.viewHotelAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                vController.displayHotels();
                mView.close(false);
                vController.showViewHotelView(true);
            }
        });

        this.mView.manageHotelAL(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                mhController.displayHotels();
                mView.close(false);
                mhController.showManageHotelView(true);
            }
        });

        this.mView.bookRoomAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mView.close(false);
                sbController.showSimulateBookView(true);
            }
        });

        this.mView.modifyPriceAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mView.close(false);
                dpController.showDatePriceView(true);
            }
        });

        this.mView.exitProgramAL(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                mView.close(false);
                eView.show(true);
                startExitTimer();
            }
        });
    }

    public void showMainMenuView(boolean result) {
        updateButtons();
        mView.show(result);
    }

    private void updateButtons(){
        boolean showButtons = false;
        if(rs.getHotelList().size() > 0)
            showButtons = true;
        this.mView.setViewHotelEnabled(showButtons);
        this.mView.setManageHotelEnabled(showButtons);
        this.mView.setBookRoomEnabled(showButtons);
        this.mView.setModifyPrice(showButtons);
    }
    private void startExitTimer() {
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
    
}
