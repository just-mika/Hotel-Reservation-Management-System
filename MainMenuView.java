import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MainMenuView {
    private JFrame mainFrame;
    private JLabel mainLbl, titleLbl;
    private JButton createHotelBtn, viewHotelBtn, manageHotelBtn, bookRoomBtn, datePriceBtn, exitBtn;
    private ImageIcon titleImageIcon, logoImageIcon;

    public MainMenuView(){
        this.mainFrame = new JFrame("Main Menu");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.setSize(650, 1080);
        
        titleImageIcon = new ImageIcon(getClass().getResource("HRS Title_MainMenu.png"));
       
        titleLbl = new JLabel("");
        titleLbl.setIcon(titleImageIcon);
        titleLbl.setBounds(230, 50, 620, 30);

        logoImageIcon = new ImageIcon(getClass().getResource("HRS Logo.png"));
        mainFrame.setIconImage(logoImageIcon.getImage());


        this.mainLbl = new JLabel("Choose a Feature: ");
        this.mainLbl.setBounds(230, 250, 1950, 50);
        this.mainLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        this.createHotelBtn = new JButton("Create Hotel");
        this.createHotelBtn.setPreferredSize(new Dimension(620, 30));
        this.createHotelBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.viewHotelBtn = new JButton("View Hotel");
        this.viewHotelBtn.setPreferredSize(new Dimension(620, 30));
        this.viewHotelBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.manageHotelBtn = new JButton("Manage Hotel");
        this.manageHotelBtn.setPreferredSize(new Dimension(620, 30));
        this.manageHotelBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.bookRoomBtn = new JButton("Book a Room");
        this.bookRoomBtn.setPreferredSize(new Dimension(620, 30));
        this.bookRoomBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.datePriceBtn = new JButton("Modify Date-Price");
        this.datePriceBtn.setPreferredSize(new Dimension(620, 30));
        this.datePriceBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.exitBtn = new JButton("Exit Program");
        this.exitBtn.setPreferredSize(new Dimension(620, 30));
        this.exitBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));


        this.mainFrame.add(titleLbl);
        this.mainFrame.add(mainLbl);
        this.mainFrame.add(createHotelBtn);
        this.mainFrame.add(viewHotelBtn);
        this.mainFrame.add(manageHotelBtn);
        this.mainFrame.add(bookRoomBtn);
        this.mainFrame.add(datePriceBtn);
        this.mainFrame.add(exitBtn);


    }

    public void createHotelAL(ActionListener al){
        this.createHotelBtn.addActionListener(al);
    }

    public void viewHotelAL(ActionListener al){
        this.viewHotelBtn.addActionListener(al);
    }

    public void manageHotelAL(ActionListener al){
        this.manageHotelBtn.addActionListener(al);
    }

    public void bookRoomAL(ActionListener al){
        this.bookRoomBtn.addActionListener(al);
    }

    public void modifyPriceAL(ActionListener al){
        this.datePriceBtn.addActionListener(al);
    }

    public void exitProgramAL(ActionListener al){
        this.exitBtn.addActionListener(al);
    }

    public void setViewHotelEnabled(boolean enabled){this.viewHotelBtn.setEnabled(enabled);}
    public void setManageHotelEnabled(boolean enabled){this.manageHotelBtn.setEnabled(enabled);}
    public void setBookRoomEnabled(boolean enabled){this.bookRoomBtn.setEnabled(enabled);}
    public void setModifyPrice(boolean enabled){this.datePriceBtn.setEnabled(enabled);}

    public void show(boolean visible) {
        mainFrame.setVisible(visible);
    }

    public void close(boolean visible) {
        mainFrame.setVisible(visible);
    }

}
