import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.CardLayout;

public class SimulateBookingView {
    private JFrame mainFrame;
    private JLabel menuLbl, titleLbl, titleLbl_1, titleLbl_2, titleLbl_3, titleLbl_4, titleLbl_5, chooseLbl, feedbackLbl, feedbackLbl_2, feedbackLbl_3, feedbackLbl_4, feedbackLbl_5,
    enterNameLbl, enterCheckInLbl, enterCheckOutLbl, roomTypeLbl, enterDiscLbl, hotelListLbl, guestNameLbl, checkInLbl, checkOutLbl, roomTypeLbl_2, discountLbl;
    private JButton backToMainBtn, enterBtn, StandardBtn, DeluxeBtn, ExecBtn, backBtn, chooseBtn, enterBtn_2;
    private JPanel hotelListPanel, guestInfoPanel, showRoomPanel, cardPanel, roomTypePanel, enterDiscountPanel; 
    private JTextField guestNameTF, checkInTF, checkOutTF, chooseHotelTF, enterDiscountTF, roomTypeTF;
    

    private ImageIcon titleImageIcon, titleImageIcon_1, titleImageIcon_2, logoImageIcon;

    public SimulateBookingView(){
        this.mainFrame = new JFrame("Book Room");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.setSize(650, 1080);

        titleImageIcon = new ImageIcon(getClass().getResource("HRS Title_SimulateBooking.png"));
        titleLbl = new JLabel("");
        titleLbl.setIcon(titleImageIcon);
        titleLbl.setBounds(230, 50, 620, 30);

        titleImageIcon_1 = new ImageIcon(getClass().getResource("HRS Title_SimulateBooking_ChooseHotel.png"));
        titleLbl_1 = new JLabel("");
        titleLbl_1.setIcon(titleImageIcon_1);
        titleLbl_1.setBounds(230, 50, 650, 30);

        titleImageIcon_2 = new ImageIcon(getClass().getResource("HRS Title_SimulateBooking_ChooseReservation.png"));
        titleLbl_2 = new JLabel("");
        titleLbl_2.setIcon(titleImageIcon_2);
        titleLbl_2.setBounds(230, 50, 650, 30);

        titleLbl_3 = new JLabel("");
        titleLbl_3.setIcon(titleImageIcon);
        titleLbl_3.setBounds(230, 50, 650, 30);

        titleLbl_4 = new JLabel("");
        titleLbl_4.setIcon(titleImageIcon);
        titleLbl_4.setBounds(230, 50, 650, 30);

        titleLbl_5 = new JLabel("");
        titleLbl_5.setIcon(titleImageIcon);
        titleLbl_5.setBounds(230, 50, 650, 30);

        

        logoImageIcon = new ImageIcon(getClass().getResource("HRS Logo.png"));
        mainFrame.setIconImage(logoImageIcon.getImage());



        //Hotel Panel
        this.chooseLbl = new JLabel("Hotels: "); 
        this.chooseLbl.setPreferredSize(new Dimension(620, 30));
        this.chooseLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        this.hotelListLbl = new JLabel("");
        this.hotelListLbl.setPreferredSize(new Dimension(620, 30));
        this.hotelListLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        this.chooseHotelTF = new JTextField();
        this.chooseHotelTF.setColumns(20);
        this.chooseHotelTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.chooseBtn = new JButton("Book");
        this.chooseBtn.setPreferredSize(new Dimension(100, 30));
        this.chooseBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl = new JLabel("");
        this.feedbackLbl.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        hotelListPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        hotelListPanel.add(titleLbl_1);
        hotelListPanel.add(chooseLbl);
        hotelListPanel.add(hotelListLbl);
        hotelListPanel.add(chooseHotelTF);
        hotelListPanel.add(chooseBtn);
        hotelListPanel.add(feedbackLbl);
        hotelListPanel.setPreferredSize(new Dimension(650, 1080));

        //Input guest Info 
        this.enterNameLbl = new JLabel("Enter Guest Name: ");
        this.enterNameLbl .setPreferredSize(new Dimension(620, 10));
        this.guestNameTF = new JTextField();
        this.guestNameTF.setColumns(20);
        this.enterNameLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
        this.guestNameTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.enterCheckInLbl = new JLabel("Enter Check-In Date: ");
        this.enterCheckInLbl.setPreferredSize(new Dimension(620, 10));
        this.checkInTF = new JTextField();
        this.checkInTF.setColumns(20);
        this.enterCheckInLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
        this.checkInTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.enterCheckOutLbl = new JLabel("Enter Check-Out Date: ");
        this.enterCheckOutLbl.setPreferredSize(new Dimension(620, 10));
        this.checkOutTF = new JTextField();
        this.checkOutTF.setColumns(20);
        this.enterCheckOutLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
        this.checkOutTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.roomTypeLbl = new JLabel("Room Type: ");
        this.roomTypeLbl.setPreferredSize(new Dimension(620, 10));
        this.roomTypeTF = new JTextField();
        this.roomTypeTF.setColumns(20);
        this.roomTypeLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
        this.roomTypeTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.discountLbl = new JLabel("Discount Code: ");
        this.discountLbl.setPreferredSize(new Dimension(620, 10));
        this.enterDiscountTF = new JTextField();
        this.enterDiscountTF.setColumns(20);
        this.discountLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));
        this.enterDiscountTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.enterBtn = new JButton("Enter");
        this.enterBtn.setPreferredSize(new Dimension(620, 30));
        this.enterBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_2 = new JLabel("");
        this.feedbackLbl_2.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        this.feedbackLbl_3 = new JLabel("");
        this.feedbackLbl_3.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl_3.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        guestInfoPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        guestInfoPanel.setPreferredSize(new Dimension(650, 1080));
        guestInfoPanel.add(titleLbl_2);
        guestInfoPanel.add(feedbackLbl_2);
        guestInfoPanel.add(enterNameLbl);
        guestInfoPanel.add(guestNameTF);
        guestInfoPanel.add(enterCheckInLbl);
        guestInfoPanel.add(checkInTF);
        guestInfoPanel.add(enterCheckOutLbl);
        guestInfoPanel.add(checkOutTF);
        guestInfoPanel.add(roomTypeLbl);
        guestInfoPanel.add(roomTypeTF);
        guestInfoPanel.add(discountLbl);
        guestInfoPanel.add(enterDiscountTF);
        guestInfoPanel.add(enterBtn);
        guestInfoPanel.add(feedbackLbl_3);
        
        //showRoomInfo Panel 
        this.menuLbl = new JLabel("Reserving in ");
        this.menuLbl.setPreferredSize(new Dimension(620, 30));
        this.menuLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,20));

        this.guestNameLbl = new JLabel("Guest Name: ");
        this.guestNameLbl.setPreferredSize(new Dimension(620, 30));
        this.guestNameLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.checkInLbl = new JLabel("Check-In Date: ");
        this.checkInLbl.setPreferredSize(new Dimension(620, 30));
        this.checkInLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.checkOutLbl = new JLabel("Check-Out Date: ");
        this.checkOutLbl.setPreferredSize(new Dimension(620, 30));
        this.checkOutLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.roomTypeLbl_2 = new JLabel("Room Type: ");
        this.roomTypeLbl_2.setPreferredSize(new Dimension(620, 30));
        this.roomTypeLbl_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.discountLbl= new JLabel("Discount: ");
        this.discountLbl.setPreferredSize(new Dimension(620, 30));
        this.discountLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backToMainBtn = new JButton("Back to Main Menu");
        this.backToMainBtn.setPreferredSize(new Dimension(220, 30));
        this.backToMainBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        

        showRoomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        showRoomPanel.setPreferredSize(new Dimension(650, 1080));
        showRoomPanel.add(titleLbl_3);
        showRoomPanel.add(menuLbl);
        showRoomPanel.add(guestNameLbl);
        showRoomPanel.add(checkInLbl);
        showRoomPanel.add(checkOutLbl);
        showRoomPanel.add(roomTypeLbl_2);
        showRoomPanel.add(discountLbl);
        showRoomPanel.add(backToMainBtn);
        //showRoomPanel.add(feedbackLbl_3);

        //room type panel
        /*this.roomTypeLbl = new JLabel("Choose a Room Type: ");
        this.roomTypeLbl.setBounds(230, 50, 650, 30);
        this.roomTypeLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.StandardBtn = new JButton("Standard Room");
        this.StandardBtn.setPreferredSize(new Dimension(650, 30));
        this.StandardBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.DeluxeBtn = new JButton("Deluxe Room");
        this.DeluxeBtn.setPreferredSize(new Dimension(650, 30));
        this.DeluxeBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.ExecBtn = new JButton("Executive Room");
        this.ExecBtn.setPreferredSize(new Dimension(650, 30));
        this.ExecBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.backBtn = new JButton("Back To Guest Information");
        this.backBtn.setPreferredSize(new Dimension(650, 30));
        this.backBtn.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_4 = new JLabel("");
        this.feedbackLbl_4.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl_4.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        roomTypePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        roomTypePanel.setPreferredSize(new Dimension(650, 1080));
        roomTypePanel.add(titleLbl_4);
        roomTypePanel.add(roomTypeLbl);
        roomTypePanel.add(StandardBtn);
        roomTypePanel.add(DeluxeBtn);
        roomTypePanel.add(ExecBtn);
        roomTypePanel.add(backBtn);
        roomTypePanel.add(feedbackLbl_4);*/

        //enter discode
        /*this.enterDiscLbl = new JLabel("Enter Discount Code: ");
        this.enterDiscLbl.setBounds(230, 250, 1950, 50);
        this.enterDiscLbl.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.enterDiscountTF = new JTextField();
        this.enterDiscountTF.setColumns(20);
        this.enterDiscountTF.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.enterBtn_2 = new JButton("Enter");
        this.enterBtn_2.setPreferredSize(new Dimension(100, 30));
        this.enterBtn_2.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        this.feedbackLbl_5 = new JLabel("");
        this.feedbackLbl_5.setPreferredSize(new Dimension(620, 30));
        this.feedbackLbl_5.setFont(new Font("Times New Roman", Font.CENTER_BASELINE,15));

        enterDiscountPanel  = new JPanel(new FlowLayout(FlowLayout.CENTER));
        enterDiscountPanel.setPreferredSize(new Dimension(650, 1080));
        enterDiscountPanel.add(titleLbl_5);
        enterDiscountPanel.add(enterDiscLbl);
        enterDiscountPanel.add(enterDiscountTF);
        enterDiscountPanel.add(enterBtn_2);
        enterDiscountPanel.add(feedbackLbl_5);*/


        cardPanel = new JPanel(new CardLayout());
        cardPanel.add(hotelListPanel, "HotelListPanel");
        cardPanel.add(guestInfoPanel, "GuestInfoPanel");
        cardPanel.add(showRoomPanel, "ShowRoomPanel");
        
        //choose type, enter discode (maybe JOP)
        //cardPanel.add(roomTypePanel, "RoomTypePanel");
        //cardPanel.add(enterDiscountPanel, "EnterDiscountPanel");

        mainFrame.add(cardPanel);

    }

    //action Listeners
    public void goToBookAL(ActionListener al){
        this.chooseBtn.addActionListener(al);
    }

    /*public void goToRoomInfoAL(ActionListener al){
        this.enterBtn_2.addActionListener(al);
    }*/

    public void goToRoomInfoAL(ActionListener al){
        this.enterBtn.addActionListener(al);
    }

    
    /*public void backToGuestInfoAL(ActionListener al){
        this.backBtn.addActionListener(al);
    }
 
    public void goToDiscountAL(ActionListener al){
        this.StandardBtn.addActionListener(al);
    }

    public void goToDiscountAL_2(ActionListener al){
        this.DeluxeBtn.addActionListener(al);
    }

    public void goToDiscountAL_3(ActionListener al){
        this.ExecBtn.addActionListener(al);
    }*/

    public void backToMainAL(ActionListener al){
        this.backToMainBtn.addActionListener(al);
    }

    public void show(boolean visible) {
        mainFrame.setVisible(visible);
    }

    public void close(boolean visible) {
        mainFrame.setVisible(visible);
    }

     //switch panels
     public void switchPanel(String panelName){
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel, panelName);
    }

    //text
    public void setHotelList(String text){
        this.hotelListLbl.setText(text);
    }

    public void setFeedbackLbl(String text){
        this.feedbackLbl.setText(text);
    }

    public void clearTF(){
        this.chooseHotelTF.setText("");
    }

    public String getChooseHotelText() {
        return chooseHotelTF.getText();
    }

    public void setFeedbackLbl_2(String text){
        this.feedbackLbl_2.setText(text);
    }


    public void setFeedbackLbl_3(String text){
        this.feedbackLbl_3.setText(text);
    }

    public void setFeedbackLbl_4(String text){
        this.feedbackLbl_4.setText(text);
    }

    public void setFeedbackLbl_5(String text){
        this.feedbackLbl_5.setText(text);
    }

    public void clearTF_2(){
        this.guestNameTF.setText("");
    }

    public String getGuestNameText() {
        return guestNameTF.getText();
    }

    public void clearTF_3(){
        this.checkInTF.setText("");
    }

    public int getCheckInText() {
        try {
            return Integer.parseInt(checkInTF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + checkInTF.getText() + " is not a valid integer.");
            return -1; 
        }
    }

    public void clearTF_4(){
        this.checkOutTF.setText("");
    }

    public int getCheckOutText() {
        try {
            return Integer.parseInt(checkOutTF.getText());
        } catch (NumberFormatException e) {
            System.err.println("Invalid input: " + checkOutTF.getText() + " is not a valid integer.");
            return -1; 
        }
    }

    public void clearTF_5(){
        this.roomTypeTF.setText("");
    }

    public String getRoomTypeText() {
        return roomTypeTF.getText();
    }

    public void clearTF_6(){
        this.enterDiscountTF.setText("");
    }

    public String getDiscountText() {
        return enterDiscountTF.getText();
    }

    public void displayRoomInfo(Hotel hotel, String guestName, int checkIn, int checkOut, String roomType, String discountCode) {
        menuLbl.setText("Reserving in " + hotel.getHotelName());
        guestNameLbl.setText("Guest Name: " + guestName);
        checkInLbl.setText("Check-In Date: " + checkIn);
        checkOutLbl.setText("Check-Out Date: " + checkOut);
        roomTypeLbl_2.setText("Room Type: " + roomType);
        discountLbl.setText("Discount Code: " + discountCode);
    }
}
